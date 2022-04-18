package com.clinicDental.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can´t be empty")
    @NotNull
    @Size(min=2, max = 255, message = "Error.Name must be between 2 and 255")
    private String name;
    @NotEmpty(message = "lastname can´t be empty")
    @NotNull
    @Size(min=2, max = 255, message = "Error.lastname must be between 2 and 255")
    private String lastname;
    @NotNull(message = "flag does not null")
    @NonNull
    private int enrollment;
    @NotNull(message = "flag does not null")
    @NonNull
    private Boolean flag;
    //@OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonBackReference
    //private List<Shift> shift=new ArrayList<>();
    //@OneToMany(mappedBy = "dentist",fetch = FetchType.LAZY)
    //@JsonIgnore
    //private List<Shift> shifts=new ArrayList<>();

    public Dentist() {
    }
    /*public void addShift(Shift shift){
        shifts.add(shift);
        shift.setDentist(this);
    }*/
}
