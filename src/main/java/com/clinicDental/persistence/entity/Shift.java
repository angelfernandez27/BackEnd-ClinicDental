package com.clinicDental.persistence.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private boolean flag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id",nullable = false)
    //@JsonIgnore
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id",nullable = false)
    //@JsonIgnore
    private Dentist dentist;
}
