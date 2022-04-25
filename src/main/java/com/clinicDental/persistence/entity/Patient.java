package com.clinicDental.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name can´t be empty")
    @NonNull
    @Size(min=2, max = 255, message = "Error.name must be between 2 and 255")
    private String name;
    @NotEmpty(message = "lastname can´t be empty")
    @NonNull
    @Size(min=2, max = 255, message = "Error.lastname must be between 2 and 255")
    private String lastname;
    @Email(message = "email incorrect",regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    @NotBlank(message = "Email can not blank.")
    private String email;
    @NotEmpty(message = "dni can´t be empty")
    @NonNull
    @Size(min=2, max = 255, message = "Error.dni must be between 2 and 255")
    private String dni;
    @NotNull
    private LocalDate dateAdmission;
    @NotNull
    private boolean flag;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;
    //@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    //@JsonBackReference
    //private List<Shift> shift=new ArrayList<>();

   //@OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
   //@JsonIgnore
    //private List<Shift> shifts=new ArrayList<>();

    public Patient() {}

    /*public void addShift(Shift shift){
        shifts.add(shift);
        shift.setPatient(this);

    }*/


}
