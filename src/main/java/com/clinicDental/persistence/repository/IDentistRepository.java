package com.clinicDental.persistence.repository;

import com.clinicDental.persistence.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistRepository extends JpaRepository<Dentist,Long> {
}
