package com.lgutierrez.orderservice.controller;

import com.lgutierrez.orderservice.entity.Order;
import com.lgutierrez.orderservice.entity.Type;
import com.lgutierrez.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public Type getOrderByPostCode(@RequestParam("orderNumber") String postalCode) {
        return orderService.getOrderByPostCode(postalCode);
    }
}
