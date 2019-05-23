package com.biotrio.backend.controller;

import com.biotrio.backend.model.Customer;
import com.biotrio.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/test")
    public Customer test(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer user = customerService.findUserByEmail(auth.getName());
        return user;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public Customer createNewUser(@RequestBody Customer user) {
        Customer userExists = customerService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            return null;
        }
        customerService.saveCustomer(user);
        return user;
    }
}
