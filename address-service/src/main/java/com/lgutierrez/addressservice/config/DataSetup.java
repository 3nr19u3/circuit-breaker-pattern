package com.lgutierrez.addressservice.config;

import com.lgutierrez.addressservice.entity.Address;
import com.lgutierrez.addressservice.repository.AddressRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataSetup {
    @Autowired
    private AddressRepository addressRepository;
    @PostConstruct
    public void setupData() {
        addressRepository.saveAll(Arrays.asList(
                Address.builder().id(1).postalCode("1001").state("lima").city("lima").build(),
                Address.builder().id(2).postalCode("1002").state("cuzco").city("ccorca").build(),
                Address.builder().id(3).postalCode("1003").state("iquitos").city("loreto").build()));
    }
}
