package com.clinicDental.service.impl;

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
        patient.setEmail("hugooo@gmail.com"); //hay que cambiar siempre porque no puede repetirse en la db
        patient.setFlag(false);


    }

    @Test
    void save() {
        Patient patientSave=patientRepository.save(patient);
        assertTrue(patientSave!=null);
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
        patientRepository.save(patient);
        Optional<Patient> patientOptional=patientRepository.findById(1L);
        assertTrue(patientOptional.isPresent());
    }

    @Test
    void findAll() {
        List<Patient>patientList=patientRepository.findAll();
        assertTrue(patientList!=null);
    }

    @Test
    void update() {
    }

    @Test
    void findPatientByEmail() {
        patientRepository.save(patient);
        Optional<Patient>patientOptional=patientRepository.findPatientByEmail("hugooo@gmail.com");
        assertTrue(patientOptional.isPresent());

    }
}