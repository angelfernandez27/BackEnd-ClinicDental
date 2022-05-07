package com.clinicDental.persistence.repository;

import com.clinicDental.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    public Optional<Role> findByName(String name);
}
