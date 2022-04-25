package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.dto.PatientDto;
import com.clinicDental.persistence.repository.IPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientServiceTest {

    @Autowired
    private IPatientRepository patientRepository;

    Patient patient=new Patient();

    @BeforeEach
    void setUp() {
        patient.setName("Hugo");
        patient.setLastname("Rodriguez");
        patient.setDateAdmission(LocalDate.of(2022,04,12));
        patient.setDni("12212211");
        patient.setEmail("gfg@gmail.com"); //hay que cambiar siempre porque no puede repetirse en la db ya que va a ser su username
        patient.setFlag(false);


    }

    @Test
    void save() {
        Patient patientSave=patientRepository.save(patient);
        assertTrue(patientSave!=null);
    }



    @Test
    void findById() {
        Patient patientSave=patientRepository.save(patient);
        Optional<Patient> patientOptional=patientRepository.findById(patientSave.getId());
        assertTrue(patientOptional.isPresent());
    }

    @Test
    void findAll() {
        List<Patient>patientList=patientRepository.findAll();
        assertTrue(patientList!=null);
    }



    @Test
    void findPatientByEmail() {
        Patient patientSave=patientRepository.save(patient);
        Optional<Patient>patientOptional=patientRepository.findPatientByEmail(patientSave.getEmail());
        assertTrue(patientOptional.isPresent());

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
        Patient patient=new Patient();
        patient.setFlag(false);
        patient.setName("Pedro");
        patient.setLastname("Denne");
        patient.setDni("434343434");
        patient.setEmail("dasd@gmail.com");
        patient.setDateAdmission(LocalDate.now());
        patient.setAddress(address);
        Patient patientSave=patientRepository.save(patient);
        patientSave.setName("Jorge");
        Patient patientUpdate=patientRepository.save(patientSave);
        assertEquals(patientUpdate.getName(),"Jorge");

    }

    @Test
    void deleteById() {
        //no uso el de before porque generaba problemas con el proxy
        Address address=new Address();
        address.setStreet("salta");
        address.setNumber(222);
        address.setLocality("salta");
        address.setProvince("salta");
        address.setFlag(false);
        Patient patient=new Patient();
        patient.setFlag(false);
        patient.setName("Pedro");
        patient.setLastname("Denne");
        patient.setDni("434343434");
        patient.setEmail("disra@gmail.com");
        patient.setDateAdmission(LocalDate.now());
        patient.setAddress(address);
        Patient patientSave=patientRepository.save(patient);
        patientRepository.deleteById(patientSave.getId());
        assertFalse(patientRepository.findById(patientSave.getId()).isPresent());
    }
}