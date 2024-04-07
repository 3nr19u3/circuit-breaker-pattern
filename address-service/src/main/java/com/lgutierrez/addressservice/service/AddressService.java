package com.lgutierrez.addressservice.service;

import com.lgutierrez.addressservice.entity.Address;

public interface AddressService {
    Address getAddressByPostalCode(String postalCode);
}
