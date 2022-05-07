package com.clinicDental.util;
/*
import com.clinicDental.persistence.entity.Role;
import com.clinicDental.persistence.entity.User;
import com.clinicDental.persistence.repository.IUserRepository;
import com.clinicDental.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptPassword implements ApplicationRunner {
    @Autowired
   private IUserRepository userRepository;


    @Override
    public void run(ApplicationArguments args)  {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String hashedPassword=passwordEncoder.encode("password");

        BCryptPasswordEncoder passwordEncoder2=new BCryptPasswordEncoder();
        String hashedPassword2=passwordEncoder.encode("password2");

        //userRepository.save(new User("Angel","angel","angel@gmail.com",hashedPassword, Role.ADMIN));
        //userRepository.save(new User("Raúl","raul","raul@gmail.com",hashedPassword2, Role.USER));

    }
    public User save(User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
}*/
