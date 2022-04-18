package com.clinicDental.service;


import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.dto.DentistDto;

import java.util.List;

public interface IDentistService {
    Dentist save(Dentist dentist);
    void deleteById(Long id);
    DentistDto findById(Long id);
    List<DentistDto> findAll();
    Dentist update(Dentist dentist,Long id) ;
}
