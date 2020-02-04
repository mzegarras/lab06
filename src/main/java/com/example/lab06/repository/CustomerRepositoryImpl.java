package com.example.lab06.repository;

import com.example.lab06.core.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {



    @Override
    public Account getById(String id) {

        //Account customer = jdbcTemplate.queryForObject("call GetAllCustomersById(?)", new Object[] { id }, customerRowMapper);
        //return customer;

        return new Account();
    }




}
