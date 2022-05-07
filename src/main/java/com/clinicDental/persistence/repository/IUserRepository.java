package com.clinicDental.persistence.repository;

import com.clinicDental.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {


    public Optional<User> findByEmail(String email);

    public Optional<User> findByUsernameOrEmail(String username,String email);

    public Optional<User> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);

}
