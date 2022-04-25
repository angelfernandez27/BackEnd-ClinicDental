package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.Shift;
import com.clinicDental.persistence.repository.IDentistRepository;
import com.clinicDental.persistence.repository.IPatientRepository;
import com.clinicDental.persistence.repository.IShiftRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ShitServiceTest {
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
        patient.setEmail("khgrg@gmail.com"); ///hay que ir cambiando porque no se pude repetir en la db
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
        Shift shiftSave=shiftRepository.save(shift);
        assertTrue(shiftSave!=null);
    }

    @Test
    void findById() {
        Shift shiftSave=shiftRepository.save(shift);
        assertTrue(shiftRepository.findById(shiftSave.getId()).isPresent());
    }

    @Test
    void findAll() {
        List<Shift>shiftList=shiftRepository.findAll();
        assertTrue(shiftList.size()>=0);
    }

    @Test
    void update() {
        //no uso el de before porque generaba problemas con el proxy
        Patient patient=new Patient();
        patient.setName("Juan");
        patient.setLastname("Lorenzetti");
        patient.setDni("32433334");
        patient.setEmail("hllgglh@gmail.com"); ///hay que ir cambiando porque no se pude repetir en la db
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
        Shift shift=new Shift();
        shift.setDate(LocalDateTime.of(2022,04,13,13,54));
        shift.setFlag(false);
        shift.setDentist(dentistSave);
        shift.setPatient(patientSave);
        Shift shiftSave=shiftRepository.save(shift);
        shiftSave.setDate(LocalDateTime.of(2022,04,21,01,26,00));
        shiftRepository.save(shiftSave);
        assertEquals(shiftSave.getDate(),LocalDateTime.of(2022,04,21,01,26,00));
    }

    @Test
    void deleteById() {
        //no uso el de before porque generaba problemas con el proxy
        Patient patient=new Patient();
        patient.setName("Juan");
        patient.setLastname("Lorenzetti");
        patient.setDni("32433334");
        patient.setEmail("hghgweegh@gmail.com"); ///hay que ir cambiando porque no se pude repetir en la db
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
        Shift shift=new Shift();
        shift.setDate(LocalDateTime.of(2022,04,13,13,54));
        shift.setFlag(false);
        shift.setDentist(dentistSave);
        shift.setPatient(patientSave);
        Shift shiftSave=shiftRepository.save(shift);
        shiftRepository.deleteById(shiftSave.getId());
        assertFalse(shiftRepository.findById(shiftSave.getId()).isPresent());
    }
}