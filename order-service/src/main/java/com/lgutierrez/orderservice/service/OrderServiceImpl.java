package com.lgutierrez.orderservice.service;

import com.lgutierrez.orderservice.payload.AddressDTO;
import com.lgutierrez.orderservice.entity.Failure;
import com.lgutierrez.orderservice.entity.Order;
import com.lgutierrez.orderservice.entity.Type;
import com.lgutierrez.orderservice.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    private static final String SERVICE_NAME = "order-service";
    private static final String ADDRESS_SERVICE_URL = "http://localhost:9090/addresses/";
    @Override
    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public Type getOrderByPostCode(String orderNumber) {

        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order Not Found: " + orderNumber));

        logger.info("in getOrderByPostCode() method...");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AddressDTO> entity = new HttpEntity<>(null, headers);

        ResponseEntity<AddressDTO> response = restTemplate.exchange((ADDRESS_SERVICE_URL + order.getPostalCode()),
                                                                    HttpMethod.GET,
                                                                    entity,
                                                                    AddressDTO.class);

        AddressDTO addressDTO = response.getBody();

        if (addressDTO != null) {
            order.setShippingState(addressDTO.getState());
            order.setShippingCity(addressDTO.getCity());
        }

        return order;
    }

    private Type fallbackMethod(String orderNumber, Throwable e) {
        logger.error("in fallbackMethod() method..."+e.getMessage());
        return new Failure("Address service is not responding properly");
    }
}
