package com.example.lab06.controller.web;

import com.example.lab06.controller.web.dto.AccountWebDto;
import com.example.lab06.core.domain.Account;
import com.example.lab06.service.AccountService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public HttpEntity<AccountWebDto> getById(@PathVariable("id") String id) {

        Account account = accountService.getById(id);

        if(account!=null){
            AccountWebDto customerWebDto = new AccountWebDto();
            customerWebDto.setAccount(account);
            return new ResponseEntity<>(customerWebDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }







}