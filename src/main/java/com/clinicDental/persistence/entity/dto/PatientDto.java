package com.clinicDental.persistence.entity.dto;

import com.clinicDental.persistence.entity.Address;
import com.clinicDental.persistence.entity.Shift;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PatientDto {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String dni;
    private LocalDate dateAdmission;
    private boolean flag;
    private Address address;
    //private List<Shift> shifts=new ArrayList<>();
}
