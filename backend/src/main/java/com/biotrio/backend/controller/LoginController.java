package com.biotrio.backend.controller;

import com.biotrio.backend.model.User;
import com.biotrio.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    UserService customerService;
    @GetMapping(value = "/self")
    public User self(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = customerService.findUserByEmail(auth.getName());
        return user;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public Boolean createNewUser(@RequestBody User user) {
        User userExists = customerService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            return false;
        }
        customerService.saveCustomer(user);
        return true;
    }
}
