package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.dto.AddressDto;
import com.clinicDental.persistence.repository.IAddressRepository;
import com.clinicDental.service.IAddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceTest {
    @Autowired
    IAddressRepository addressRepository;
    @Autowired
    AddressService addressService;
    private Address address=new Address();
    @BeforeEach
    void setUp() {
        address.setFlag(false);
        address.setStreet("florida");
        address.setLocality("Saenz Peña");
        address.setNumber(1222);
        address.setProvince("Chaco");
    }
    @Test
    public void testSave(){
        Address addressSave=addressRepository.save(address);
        Optional<Address> addressOptional=addressRepository.findById(addressSave.getId());
        assertTrue(addressOptional.isPresent());
    }



    @Test
    void findById() {
        Address addressSave=addressRepository.save(address);
        Optional<Address> addressOptional=addressRepository.findById(addressSave.getId());
        assertTrue(addressOptional.isPresent());


    }

    @Test
    void findAll() {
        List<Address>addressList=addressRepository.findAll();
        assertTrue(addressList.size()>=0);
    }


    @Test
    void update() {
        //no uso el de before porque generaba problemas con el proxy
        Address address=new Address();
        address.setStreet("salta");
        address.setNumber(222);
        address.setLocality("salta");
        address.setProvince("salta");
        address.setFlag(false);
        Address addressSave=addressRepository.save(address);
        addressSave.setStreet("Jujuy");
        Address addressUpdate=addressRepository.save(addressSave);
        assertEquals(addressUpdate.getStreet(),"Jujuy");

    }
    @Test
    void deleteById(){
        //no uso el de before porque generaba problemas con el proxy
        Address address=new Address();
        address.setStreet("salta");
        address.setNumber(222);
        address.setLocality("salta");
        address.setProvince("salta");
        address.setFlag(false);
        Address addressSave=addressRepository.save(address);
        assertFalse(addressRepository.findById(addressSave.getId()).isPresent());

    }
}