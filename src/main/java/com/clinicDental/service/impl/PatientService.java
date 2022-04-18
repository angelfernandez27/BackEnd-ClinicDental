package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.dto.PatientDto;
import com.clinicDental.persistence.repository.IAddressRepository;
import com.clinicDental.persistence.repository.IPatientRepository;
import com.clinicDental.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.findById(id)
                .orElseThrow();
        Patient patient=patientRepository.getById(id);
        Address address=addressRepository.getById(patient.getAddress().getId());


        address.setFlag(true);
        addressRepository.save(address);
        patient.setFlag(true);
        patientRepository.save(patient);


    }

    @Override
    public PatientDto findById(Long id){
        patientRepository.findById(id)
                .orElseThrow();
        PatientDto patientDto=null;
        Optional<Patient> patient=patientRepository.findById(id);
        if (patient.isPresent()&&!patient.get().isFlag()){
            patientDto=mapper.convertValue(patient,PatientDto.class);
        }

        return patientDto;
    }

    @Override
    public List<PatientDto> findAll(){
        PatientDto patientDto=null;
        List<PatientDto> patientDtoList=new ArrayList<>();
        List<Patient> patientList=patientRepository.findAll();
        for (Patient patient : patientList) {
            patientDto=mapper.convertValue(patient,PatientDto.class);
            if (!patientDto.isFlag()){
                patientDtoList.add(patientDto);
            }
        }
        return patientDtoList;

    }

    @Override
    public Patient update(Patient patient, Long id) {
        patientRepository.findById(id)
                .orElseThrow();
        Patient patient1=patientRepository.getById(id);

        if (patient1!=null){
            if (!patient.getName().trim().isEmpty()){
                patient1.setName(patient.getName());
            }
            if (!patient.getLastname().trim().isEmpty()){patient1.setLastname(patient.getLastname());}
            if (!patient.getLastname().trim().isEmpty()){patient1.setEmail(patient.getEmail());}
            if (!patient.getDni().trim().isEmpty()){patient1.setDni(patient.getDni());}
            if (patient.getDateAdmission()!=null){patient1.setDateAdmission(patient.getDateAdmission());}
            if (!patient.isFlag()){patient1.setFlag(patient.isFlag());}
            if (patient.getAddress()!=null){patient1.setAddress(patient.getAddress());}
        }
        return patientRepository.save(patient1);
    }

    @Override
    public PatientDto findPatientByEmail(String email) {
        patientRepository.findPatientByEmail(email)
                .orElseThrow();
        Optional<Patient> patientOptional=patientRepository.findPatientByEmail(email);
        PatientDto patientDto=null;
        if (patientOptional.isPresent()&&!patientOptional.get().isFlag()){
            patientDto=mapper.convertValue(patientOptional,PatientDto.class);
        }
        return patientDto;
    }
}
