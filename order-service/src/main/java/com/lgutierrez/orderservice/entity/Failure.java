package com.lgutierrez.orderservice.entity;

import lombok.*;

@Data
public class Failure implements Type{
    private final String msg;
}
