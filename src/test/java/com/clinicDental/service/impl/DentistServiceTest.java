package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.dto.DentistDto;
import com.clinicDental.persistence.repository.IDentistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class DentistServiceTest {
    @Autowired
    private IDentistRepository dentistRepository;



    private Dentist dentist=new Dentist();
    @BeforeEach
    void setUp() {
        dentist.setName("Geremias");
        dentist.setLastname("Simpson");
        dentist.setEnrollment(1212);
        dentist.setFlag(false);
    }

    @Test
    void save() {
        Dentist dentistSave=dentistRepository.save(dentist);
        assertTrue(dentistSave!=null);
    }


    @Test
    void findAll() {
        Dentist dentistSave=dentistRepository.save(dentist);
        assertNotNull(dentistSave!=null);
        Optional<Dentist> dentistFind=dentistRepository.findById(1L);
        assertTrue(dentistFind.isPresent());
    }



    @Test
    void deleteById() {
    }

    @Test
    void findById() {
        dentistRepository.save(dentist);
        Optional<Dentist>dentistFind=dentistRepository.findById(1L);
        assertTrue(dentistFind.isPresent());
    }

    @Test
    void update() {
    }
}