package com.clinicDental.controller;

import com.clinicDental.exception.ExceptionResponse;
import com.clinicDental.exception.ResponseExceptionHandler;
import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.dto.DentistDto;
import com.clinicDental.persistence.repository.IDentistRepository;
import com.clinicDental.service.IDentistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    private IDentistService dentistService;
    private static final Logger logger = LoggerFactory.getLogger(ResponseExceptionHandler.class);


    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Dentist dentist){
        Dentist dentist1;
            dentist1=dentistService.save(dentist);
        return new ResponseEntity<>(dentist1,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
            dentistService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dentist id: "+id+" eliminated");
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<DentistDto>> findAll(){

        List<DentistDto>dentistDtoList=dentistService.findAll();
        logger.info("dentistList");
        return ResponseEntity.status(HttpStatus.OK).body(dentistDtoList);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<DentistDto> findById(@PathVariable("id") Long id) throws Exception{

        DentistDto dentistDto=null;
        dentistDto=dentistService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dentistDto);
    }


    @PutMapping("/update/id/{id}")
    public ResponseEntity<Dentist> update(@Valid @RequestBody Dentist dentist,@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(dentistService.update(dentist,id));
    }




}
