package com.example.lab06.service;

import com.example.lab06.config.Lab01Properties;
import com.example.lab06.core.domain.Account;
import com.example.lab06.repository.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImplV2 implements AccountService {

    private CustomerRepository customerRepository;
    private Lab01Properties lab01Properties;

    public CustomerServiceImplV2(CustomerRepository customerRepository,
                                 Lab01Properties lab01Properties){
        this.customerRepository=customerRepository;
        this.lab01Properties=lab01Properties;
    }




    @Override
    public Account getById(String id) {
        return customerRepository.getById(id);
    }




}
