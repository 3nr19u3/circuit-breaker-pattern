package com.lgutierrez.orderservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Integer id;
    private String postalCode;
    private String state;
    private String city;
}
