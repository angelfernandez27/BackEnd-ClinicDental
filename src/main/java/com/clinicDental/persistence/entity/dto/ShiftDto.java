package com.clinicDental.persistence.entity.dto;

import com.clinicDental.persistence.entity.Dentist;
import com.clinicDental.persistence.entity.Patient;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public class ShiftDto {
    private Long id;
    private LocalDateTime date;
    private boolean flag;
    private Patient patient;
    private Dentist dentist;
}
