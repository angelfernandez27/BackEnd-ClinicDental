package com.clinicDental.controller;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.dto.AddressDto;
import com.clinicDental.persistence.entity.dto.PatientDto;
import com.clinicDental.service.IAddressService;
import com.clinicDental.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientControllerTest {

    @Autowired
    private IPatientService patientService;

    @Autowired
    private IAddressService addressService;
    @Autowired
    private ObjectMapper mapper;



    Patient patient=new Patient();
    //AddressDto addressDto = addressService.findById(1L);


    @BeforeEach
    void setUp() {
        patient.setName("Juan");
        patient.setLastname("Lorenzetti");
        patient.setDni("32433334");
        patient.setEmail("jssaa@gmail.com"); ///hay que ir cambiando porque no se pude repetir en la db
        patient.setFlag(false);
        patient.setDateAdmission(LocalDate.of(2022,04,13));
        Address address=new Address();
        address.setStreet("Moreno");
        address.setNumber(199);
        address.setLocality("Chajarí");
        address.setProvince("Salta");
        address.setFlag(false);
        patient.setAddress(address);

    }

    @Test
    void save() {
        Patient patientSave=patientService.save(patient);
        assertTrue(patientSave!=null);
    }



    @Test
    void findAll() {
        List<PatientDto> patientDtoList=patientService.findAll();
        assertNotNull(patientDtoList);
    }

    @Test
    void findById() {
        patientService.save(patient);
        PatientDto patientDto=patientService.findById(1L);
        assertTrue(patientDto!=null);
    }



    @Test
    void findByEmail() {
        patientService.save(patient);
        PatientDto patientDto=patientService.findPatientByEmail("jsss@gmail.com");
        assertTrue(patientDto!=null);
    }
}