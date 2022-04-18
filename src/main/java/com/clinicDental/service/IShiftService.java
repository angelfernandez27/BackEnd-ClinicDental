package com.clinicDental.service;

import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.Shift;
import com.clinicDental.persistence.entity.dto.DentistDto;
import com.clinicDental.persistence.entity.dto.ShiftDto;

import java.util.List;

public interface IShiftService {
    Shift save(Shift shift);
    void deleteById(Long id);
    ShiftDto findById(Long id);
    List<ShiftDto> findAll();
    Shift update(Shift shift,Long id);
}
