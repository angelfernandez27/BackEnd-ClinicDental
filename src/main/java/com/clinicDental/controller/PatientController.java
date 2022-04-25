package com.clinicDental.controller;

import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.dto.PatientDto;
import com.clinicDental.service.IPatientService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private IPatientService patientService;


    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Patient patient) {
        Patient patient1;
        patient1=patientService.save(patient);
        return new ResponseEntity<>(patient1,HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
            patientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Patient id: "+id+" eliminated");
    }
    @CrossOrigin
    @GetMapping("/findAll")
    public ResponseEntity<List<PatientDto>> findAll() {
        List<PatientDto>patientDtoList=null;
        patientDtoList=patientService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(patientDtoList);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PatientDto> findById(@PathVariable("id") Long id) {
        PatientDto patientDto=null;
        patientDto=patientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientDto);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<Patient> update(@Valid @RequestBody Patient patient,@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.update(patient,id));
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<PatientDto> findByEmail(@RequestParam String email){
        return  ResponseEntity.status(HttpStatus.OK).body(patientService.findPatientByEmail(email));
    }


}
