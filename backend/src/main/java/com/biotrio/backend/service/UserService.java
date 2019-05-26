package com.biotrio.backend.service;



import com.biotrio.backend.model.User;
import com.biotrio.backend.model.Role;
import com.biotrio.backend.repository.UserRepo;
import com.biotrio.backend.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service()
public class UserService {

    private UserRepo userRepository;
    private RoleRepo roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserService(UserRepo userRepository,
                       RoleRepo roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveCustomer(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role customerRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
        user.setActive(1);
        userRepository.save(user);
    }

}