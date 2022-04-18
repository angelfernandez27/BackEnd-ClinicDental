package com.clinicDental.controller;

import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.dto.DentistDto;
import com.clinicDental.service.IDentistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DentistControllerTest {
    @Autowired
    private IDentistService dentistService;

    Dentist dentist=new Dentist();

    @BeforeEach
    void setUp() {
        dentist.setName("Jaime");
        dentist.setLastname("Dann");
        dentist.setEnrollment(332);
        dentist.setFlag(false);
    }

    @Test
    void save() {
        Dentist dentist1=dentistService.save(dentist);
        assertNotNull(dentist1);
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
        List<DentistDto> dentistDtoList=dentistService.findAll();
        assertTrue(dentistDtoList!=null);
    }

    @Test
    void findById() {
        dentistService.save(dentist);
        DentistDto dentistDto=dentistService.findById(1L);
        assertNotNull(dentistDto);
    }

    @Test
    void update() {
    }
}