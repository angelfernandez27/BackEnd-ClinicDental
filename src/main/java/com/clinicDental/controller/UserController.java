package com.clinicDental.controller;

import com.clinicDental.persistence.entity.User;
import com.clinicDental.util.EncryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
    private AuthenticationManager authenticationManager;
   /* @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;*/
    @Autowired
    private EncryptPassword encryptPassword;

    public UserController() {
    }

    @PostMapping("/signin")
    public User save(@RequestBody User user){
        return encryptPassword.save(user);
    }
    /*@CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<?> authByPost(@RequestBody User user){
        try{
            Authentication auth=authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Log failed",HttpStatus.UNAUTHORIZED);
        }
    }*/

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<?> authByPost(@RequestBody User user){
        try{
            Authentication auth=authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Log failed",HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
