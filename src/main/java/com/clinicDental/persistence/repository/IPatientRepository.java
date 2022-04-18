package com.clinicDental.persistence.repository;

import com.clinicDental.persistence.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long> {

    Optional<Patient> findPatientByEmail(@RequestParam String email);
}
