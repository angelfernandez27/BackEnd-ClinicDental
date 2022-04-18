package com.clinicDental.persistence.repository;

import com.clinicDental.persistence.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShiftRepository extends JpaRepository<Shift,Long> {
}
