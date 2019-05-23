package com.biotrio.backend.controller;

import com.biotrio.backend.model.SignupData;
import com.biotrio.backend.model.UserCreds;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
//    @PostMapping("/login")
//    public UserCreds greeting(@RequestBody UserCreds userCreds) {
//        System.out.println(userCreds.getUsername()+userCreds.getPassword());
//        return userCreds;
//    }
}
