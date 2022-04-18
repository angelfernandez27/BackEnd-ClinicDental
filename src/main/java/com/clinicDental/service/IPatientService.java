package com.clinicDental.service;

import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.dto.PatientDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IPatientService {
    Patient save(Patient patient);
    void deleteById(Long id);
    PatientDto findById(Long id);
    List<PatientDto> findAll();
    Patient update(Patient patient,Long id);
    PatientDto findPatientByEmail(String email);
}
