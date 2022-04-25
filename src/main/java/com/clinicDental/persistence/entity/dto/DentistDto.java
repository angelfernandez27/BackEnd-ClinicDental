package com.clinicDental.persistence.entity.dto;
import com.clinicDental.persistence.entity.Shift;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DentistDto {
    private Long id;
    private String name;
    private String lastname;
    private int enrollment;
    private Boolean flag;

}
