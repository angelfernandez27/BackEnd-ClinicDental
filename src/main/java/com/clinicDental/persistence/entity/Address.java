package com.clinicDental.persistence.entity;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "street can´t be empty")
    @NonNull
    @Size(min=2, max = 255, message = "Error.Street must be between 2 and 255")
    @Column(nullable = false)
    private String street;
    @NonNull
    @Column(nullable = false)
    private Integer number;
    @NotEmpty(message = "locality can´t be empty")
    @NonNull
    @Size(min=2, max = 255, message = "Error.Locality must be between 2 and 255")
    @Column(nullable = false)
    private String locality;
    @NotEmpty(message = "Province can´t be empty")
    @NonNull
    @Size(min=2, max = 255, message = "Error.Province must be between 2 and 255")
    @Column(nullable = false)
    private String province;
    @Column(nullable = false)
    private Boolean flag;

    public Address() {
    }
}
