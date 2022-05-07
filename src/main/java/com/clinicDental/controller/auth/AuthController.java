package com.clinicDental.controller.auth;

import com.clinicDental.jwt.JwtAuthResponseDTO;
import com.clinicDental.jwt.JwtTokenProvider;
import com.clinicDental.persistence.entity.Role;
import com.clinicDental.persistence.entity.User;
import com.clinicDental.persistence.entity.dto.LoginDto;
import com.clinicDental.persistence.entity.dto.SigninDto;
import com.clinicDental.persistence.repository.IRoleRepository;
import com.clinicDental.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDTO(token));

    }
    @PostMapping("/signin")
    public ResponseEntity<?> signinUser(@RequestBody SigninDto signinDto){
        if (userRepository.existsByUsername(signinDto.getUsername())){
            return new ResponseEntity<>("Username already exist", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signinDto.getEmail())){
            return new ResponseEntity<>("Email already exist",HttpStatus.BAD_REQUEST);
        }
        User user=new User();
        user.setName(signinDto.getName());
        user.setUsername(signinDto.getUsername());
        user.setEmail(signinDto.getEmail());
        user.setPassword(passwordEncoder.encode(signinDto.getPassword()));

        Role role=roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
        return new ResponseEntity<>("SignIn User Successfully",HttpStatus.OK);
    }
}
