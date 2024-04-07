package com.lgutierrez.orderservice.config;

import com.lgutierrez.orderservice.entity.Order;
import com.lgutierrez.orderservice.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataSetup {
    @Autowired
    private OrderRepository orderRepository;
    @PostConstruct
    public void setupData() {
        orderRepository.saveAll(Arrays.asList(
                Order.builder().id(1).orderNumber("0c70c0c2").postalCode("1000001").build(),
                Order.builder().id(2).orderNumber("7f8f9f15").postalCode("1100000").build(),
                Order.builder().id(3).orderNumber("394627b2").postalCode("2100001").build()));
    }
}
