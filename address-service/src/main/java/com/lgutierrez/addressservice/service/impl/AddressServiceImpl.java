package com.lgutierrez.addressservice.service.impl;

import com.lgutierrez.addressservice.entity.Address;
import com.lgutierrez.addressservice.repository.AddressRepository;
import com.lgutierrez.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public Address getAddressByPostalCode(String postalCode) {
        return addressRepository.findByPostalCode(postalCode)
                .orElseThrow(() -> new RuntimeException("Address Not Found: " + postalCode));
    }
}
