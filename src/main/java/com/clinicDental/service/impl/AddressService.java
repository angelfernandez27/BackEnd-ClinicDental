package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.dto.AddressDto;
import com.clinicDental.persistence.repository.IAddressRepository;
import com.clinicDental.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.findById(id)
                .orElseThrow();
        Address address=addressRepository.getById(id);
        address.setFlag(true);
        addressRepository.save(address);
    }

    @Override
    public AddressDto findById(Long id) {
        addressRepository.findById(id)
                .orElseThrow();
        AddressDto addressDto=null;
        Optional<Address>address=addressRepository.findById(id);
        if (address.isPresent()&&!address.get().getFlag()){
            addressDto=mapper.convertValue(address,AddressDto.class);
        }
        return addressDto;
    }

    @Override
    public List<AddressDto> findAll() {
        AddressDto addressDto=null;
        List<AddressDto>addressDtoList=new ArrayList<>();
        List<Address> addressList=addressRepository.findAll();

            for (Address address : addressList) {
                addressDto=mapper.convertValue(address,AddressDto.class);
                if (!addressDto.getFlag()){
                    addressDtoList.add(addressDto);
                }

            }

        return addressDtoList;
    }

    @Override
    public Address update(Address address, Long id){
        addressRepository.findById(id)
                .orElseThrow();
        Address address1=addressRepository.getById(id);

        if (address1!=null)
            if (!address.getStreet().trim().isEmpty()){address1.setStreet(address.getStreet());}
            if (!(address.getNumber() ==null)){address1.setNumber(address.getNumber());}
            if (!address.getLocality().isEmpty()){address1.setLocality(address.getLocality());}
            if (!address.getProvince().isEmpty()){address1.setProvince(address.getProvince());}


        return addressRepository.save(address1);
    }
}
