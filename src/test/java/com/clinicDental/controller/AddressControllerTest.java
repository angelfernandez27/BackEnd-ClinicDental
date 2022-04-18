package com.clinicDental.controller;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.dto.AddressDto;
import com.clinicDental.persistence.repository.IAddressRepository;
import com.clinicDental.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressControllerTest {
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void save() {
        Address address=new Address();
        address.setStreet("Santa");
        address.setNumber(2323);
        address.setLocality("Los Pirpintos");
        address.setProvince("Jujuy");
        address.setFlag(false);
        Address addressSave=addressService.save(address);
        assertNotNull(addressSave);
    }
    //No anda



    @Test
    void findAll() {
       List<AddressDto> addressDtos= addressService.findAll();
       assertTrue(addressDtos!=null);
    }

    @Test
    void findById() {
        Address address=new Address();
        address.setFlag(false);
        address.setStreet("Amigas");
        address.setLocality("Saenz Peña");
        address.setNumber(2222);
        address.setProvince("Chaco");

        addressService.save(address);
        AddressDto addressDtoSave=addressService.findById(1L);
        assertTrue(addressDtoSave!=null);

    }
    //No anda
    @Test
    void update() {
        Address address=new Address();
        address.setFlag(false);
        address.setStreet("Amigas");
        address.setLocality("Saenz Peña");
        address.setNumber(2222);
        address.setId(1L);
        address.setProvince("Chaco");

        //addressService.save(address);
        //AddressDto addressDtoSave=addressService.findById(1L);
        //Address addressToUpdate=null;
        //addressToUpdate=mapper.convertValue(addressDtoSave,Address.class);
        Address addressDidUpdate=addressService.update(address,1L);
        assertTrue(addressDidUpdate!=null);

    }

    //no anda delete
    Address address1=null;
    @BeforeEach
    void setUp() {
        Address address=new Address();
        address.setFlag(false);
        address.setStreet("Chacra");
        address.setLocality("Saenz Peña");
        address.setNumber(2222);
        address.setProvince("Chaco");
        address.setId(22L);
        address1=addressService.save(address);
    }

    @Test
    void deleteById() {

        addressService.deleteById(address1.getId());
        AddressDto addressDto=addressService.findById(address1.getId());
        assertTrue(addressDto==null);
    }
}