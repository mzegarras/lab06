package com.example.lab06.repository;


import com.example.lab06.core.domain.Account;

public interface CustomerRepository {

    Account getById(String id);

}
