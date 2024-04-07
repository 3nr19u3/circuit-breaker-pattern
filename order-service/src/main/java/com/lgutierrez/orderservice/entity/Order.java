package com.lgutierrez.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order implements Type{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String orderNumber;
    private String postalCode;
    private String shippingState;
    private String shippingCity;
}
