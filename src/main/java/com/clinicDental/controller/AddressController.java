package com.clinicDental.controller;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.dto.AddressDto;
import com.clinicDental.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    IAddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Address address) {
        Address address1;
        address1=addressService.save(address);
        return new ResponseEntity<>(address1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
            addressService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address Eliminated");

    }
    @GetMapping("/findAll")
    public ResponseEntity<List<AddressDto>> findAll(){
            List<AddressDto> addressList=addressService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(addressList);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable("id") Long id)  {
        AddressDto addressDto=null;
        addressDto=addressService.findById(id);
        return ResponseEntity.ok(addressDto);
    }
    @PutMapping("/update/id/{id}")
    public ResponseEntity<Address> update(@Valid @RequestBody Address address,@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(address,id));
    }


}
