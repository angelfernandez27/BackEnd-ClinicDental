package com.clinicDental.service.impl;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.Patient;
import com.clinicDental.persistence.entity.Shift;
import com.clinicDental.persistence.entity.dto.PatientDto;
import com.clinicDental.persistence.entity.dto.ShiftDto;
import com.clinicDental.persistence.repository.IShiftRepository;
import com.clinicDental.service.IShiftService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShitService implements IShiftService {
    @Autowired
    private IShiftRepository shiftRepository;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public void deleteById(Long id) {
        shiftRepository.findById(id)
                .orElseThrow();
        Shift shift=shiftRepository.getById(id);
        shift.setFlag(true);
        shiftRepository.save(shift);
    }

    @Override
    public ShiftDto findById(Long id) {
        shiftRepository.findById(id)
                .orElseThrow();
        ShiftDto shiftDto=null;
        Optional<Shift> shiftOptional=shiftRepository.findById(id);
        if (shiftOptional.isPresent()&&!shiftOptional.get().isFlag()){
            shiftDto=mapper.convertValue(shiftOptional, ShiftDto.class);
        }

        return shiftDto;
    }

    @Override
    public List<ShiftDto> findAll() {
        ShiftDto shiftDto=null;
        List<ShiftDto> shiftDtoList=new ArrayList<>();
        List<Shift> shiftList=shiftRepository.findAll();
        for (Shift shift : shiftList) {
            shiftDto=mapper.convertValue(shift,ShiftDto.class);
            if (!shiftDto.isFlag()){
                shiftDtoList.add(shiftDto);
            }
        }
        return shiftDtoList;
    }

    @Override
    public Shift update(Shift shift, Long id) {
        shiftRepository.findById(id)
                .orElseThrow();
        Shift shift1=shiftRepository.getById(id);

        if (shift!=null){
            if (shift.getDate()!=null){
                shift1.setDate(shift.getDate());
            }
            if (!shift.isFlag()){shift1.setFlag(shift.isFlag());}
            if (shift.getDentist()!=null){shift1.setDentist(shift.getDentist());}
            if (shift.getPatient()!=null){shift1.setPatient(shift.getPatient());}

        }
        return shiftRepository.save(shift1);
    }
}
