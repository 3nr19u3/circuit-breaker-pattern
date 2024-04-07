package com.lgutierrez.orderservice.service;

import com.lgutierrez.orderservice.entity.Type;

public interface OrderService {
    Type getOrderByPostCode(String orderNumber);
}
