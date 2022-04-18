package com.clinicDental.service;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.dto.AddressDto;

import java.util.List;

public interface IAddressService {
    Address save(Address address);
    void deleteById(Long id);
    AddressDto findById(Long id);
    List<AddressDto> findAll();
    Address update(Address address,Long id);
}
