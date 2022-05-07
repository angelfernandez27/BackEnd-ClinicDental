package com.clinicDental.controller.auth;
import com.clinicDental.persistence.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> user(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=new User();
        user.setName(userDetails.getUsername());
        return ResponseEntity.ok(user);
    }



}
