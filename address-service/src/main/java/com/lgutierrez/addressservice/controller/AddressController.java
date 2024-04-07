package com.lgutierrez.addressservice.controller;

import com.lgutierrez.addressservice.entity.Address;
import com.lgutierrez.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/{postalCode}")
    public Address getAddressByPostalCode(@PathVariable("postalCode") String postalCode) {
        return addressService.getAddressByPostalCode(postalCode);
    }

}
