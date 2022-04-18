package com.clinicDental.persistence.entity.dto;

import com.clinicDental.persistence.entity.Patient;
import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String street;
    private Integer number;
    private String locality;
    private String province;
    private Boolean flag;


}
