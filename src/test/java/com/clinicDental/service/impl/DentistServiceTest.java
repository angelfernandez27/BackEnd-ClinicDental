package com.clinicDental.service.impl;

import com.clinicDental.controller.UserController;
import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.User;
import com.clinicDental.persistence.entity.dto.DentistDto;
import com.clinicDental.persistence.repository.IDentistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class DentistServiceTest {
    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    private UserController userController;



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
       // assertTrue(dentistSave!=null);
        assertEquals(dentist.getEnrollment(),dentistSave.getEnrollment());
    }


    @Test
    void findAll() {

        List<Dentist> dentistList=dentistRepository.findAll();
        assertTrue(dentistList.size()>=0);
    }



    @Test
    void findById() {
        Dentist dentistSave=dentistRepository.save(dentist);
        Optional<Dentist>dentistFind=dentistRepository.findById(dentistSave.getId());
        assertTrue(dentistFind.isPresent());
    }
    @Test
    void deleteById(){
        //no uso el de before porque generaba problemas con el proxy
        Dentist dentist=new Dentist();
        dentist.setName("Geremias");
        dentist.setLastname("Simpson");
        dentist.setEnrollment(1212);
        dentist.setFlag(false);
        Dentist dentistSave= dentistRepository.save(dentist);
        dentistRepository.deleteById(dentistSave.getId());
        assertFalse(dentistRepository.findById(dentistSave.getId()).isPresent());
    }

    @Test
    void update() {
        //no uso el de before porque generaba problemas con el proxy
        Dentist dentist=new Dentist();
        dentist.setName("Geremias");
        dentist.setLastname("Simpson");
        dentist.setEnrollment(1212);
        dentist.setFlag(false);
        Dentist dentistSave= dentistRepository.save(dentist);
        dentistSave.setName("Walter");
        dentistRepository.save(dentistSave);
        assertEquals(dentistSave.getName(),"Walter");
    }
}