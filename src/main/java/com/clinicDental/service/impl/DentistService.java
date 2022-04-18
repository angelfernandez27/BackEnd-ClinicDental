package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.dto.DentistDto;
import com.clinicDental.persistence.repository.IDentistRepository;
import com.clinicDental.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IDentistService {
    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public Dentist save(Dentist dentist){
        return dentistRepository.save(dentist);
    }

    @Override
    public void deleteById(Long id){
        dentistRepository.findById(id)
                .orElseThrow();
        Dentist dentist=dentistRepository.getById(id);
        /*if (dentist==null)
            throw new ApiException("Dentist id can not find");*/
        dentist.setFlag(true);
        dentistRepository.save(dentist);
    }

    @Override
    public DentistDto findById(Long id){
        dentistRepository.findById(id)
                .orElseThrow();
        DentistDto dentistDto=null;
        Optional<Dentist> dentist=dentistRepository.findById(id);
        if (dentist.isPresent()&&!dentist.get().getFlag()){
            dentistDto=mapper.convertValue(dentist,DentistDto.class);
        }
        return dentistDto;
    }

    @Override
    public List<DentistDto> findAll()  {
        DentistDto dentistDto=null;
        List<DentistDto>dentistDtoList=new ArrayList<>();
        List<Dentist> dentistList=dentistRepository.findAll();
        for (Dentist dentist : dentistList) {
            dentistDto=mapper.convertValue(dentist,DentistDto.class);
            if (!dentistDto.getFlag()){
                dentistDtoList.add(dentistDto);
            }

        }
        return dentistDtoList;
    }

    @Override
    public Dentist update(Dentist dentist, Long id){
        dentistRepository.findById(id)
                .orElseThrow();
        Dentist dentist1=dentistRepository.getById(id);
        /*if (dentist1==null)
            throw new ApiException("Dentist id can not find in db");*/
        if (dentist1!=null){
            if (!dentist.getName().trim().isEmpty()){
                dentist1.setName(dentist.getName());
            }
            if (!dentist.getLastname().trim().isEmpty()){dentist1.setLastname(dentist.getLastname());}
            if (dentist.getEnrollment()!=0){dentist1.setEnrollment(dentist.getEnrollment());}
        }
        return dentistRepository.save(dentist1);

    }
}
