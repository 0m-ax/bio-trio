package com.biotrio.backend.service;



import com.biotrio.backend.model.Customer;
import com.biotrio.backend.model.Role;
import com.biotrio.backend.repository.CustomerRepo;
import com.biotrio.backend.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service()
public class CustomerService {

    private CustomerRepo customerRepository;
    private RoleRepo roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public CustomerService(CustomerRepo userRepository,
                       RoleRepo roleRepository,
                      BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.customerRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    public Customer findUserByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public void saveCustomer(Customer user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role customerRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
        user.setActive(1);
        customerRepository.save(user);
    }

}