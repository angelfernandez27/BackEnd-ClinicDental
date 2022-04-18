package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.dto.AddressDto;
import com.clinicDental.persistence.repository.IAddressRepository;
import com.clinicDental.service.IAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceTest {
    @Autowired
    IAddressRepository addressRepository;
    @Test
    public void testSave(){
        Address address=new Address();
        address.setFlag(false);
        address.setStreet("florida");
        address.setLocality("Saenz Peña");
        address.setNumber(1222);
        address.setProvince("Chaco");

        addressRepository.save(address);
        Optional<Address> addressOptional=addressRepository.findById(1L);

        assertTrue(addressOptional.isPresent());
    }

}