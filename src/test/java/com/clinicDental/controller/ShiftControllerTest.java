package com.clinicDental.controller;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.Shift;
import com.clinicDental.persistence.entity.dto.ShiftDto;
import com.clinicDental.persistence.repository.IDentistRepository;
import com.clinicDental.persistence.repository.IPatientRepository;
import com.clinicDental.persistence.repository.IShiftRepository;
import com.clinicDental.service.IShiftService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ShiftControllerTest {

    @Autowired
    private IShiftService shiftService;
    @Autowired
    private IShiftRepository shiftRepository;
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private IDentistRepository dentistRepository;


    Shift shift=new Shift();

    @BeforeEach
    void setUp() {
        Patient patient=new Patient();
        patient.setName("Juan");
        patient.setLastname("Lorenzetti");
        patient.setDni("32433334");
        patient.setEmail("jssagghga@gmail.com"); ///hay que ir cambiando porque no se pude repetir en la db
        patient.setFlag(false);
        patient.setDateAdmission(LocalDate.of(2022,04,13));
        Address address=new Address();
        address.setStreet("Moreno");
        address.setNumber(199);
        address.setLocality("Chajarí");
        address.setProvince("Salta");
        address.setFlag(false);
        patient.setAddress(address);
        Patient patientSave=patientRepository.save(patient);
        Dentist dentist=new Dentist();
        dentist.setName("Jaime");
        dentist.setLastname("Dann");
        dentist.setEnrollment(332);
        dentist.setFlag(false);
        Dentist dentistSave=dentistRepository.save(dentist);
        shift.setDate(LocalDateTime.of(2022,04,13,13,54));
        shift.setFlag(false);
        shift.setDentist(dentistSave);
        shift.setPatient(patientSave);

    }

    @Test
    void save() {

        Shift shiftSave=shiftService.save(shift);
        assertTrue(shiftRepository.findById(shiftSave.getId()).isPresent());

    }



    @Test
    void findAll() {
        List<ShiftDto>shiftDtoList=shiftService.findAll();
        assertTrue(shiftDtoList!=null);
    }


    @Test
    void findById() {
        shiftService.save(shift);
        ShiftDto shiftDto=shiftService.findById(1L);
        assertTrue(shiftDto!=null);
    }


}