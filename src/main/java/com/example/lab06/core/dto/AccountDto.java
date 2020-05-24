package com.example.lab06.core.dto;

import com.example.lab06.core.domain.Account;
import com.example.lab06.core.domain.EventStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountDto implements Serializable {

    private static final long serialVersionUID = 7193203766462383090L;

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
