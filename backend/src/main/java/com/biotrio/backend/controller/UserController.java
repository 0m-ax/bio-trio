package com.biotrio.backend.controller;

import com.biotrio.backend.model.UserCreds;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @PostMapping("/login")
    public HttpSession greeting(@RequestBody UserCreds userCreds, HttpSession session) {
        System.out.println(userCreds.getUsername()+userCreds.getPassword());
        return session;
    }
}
