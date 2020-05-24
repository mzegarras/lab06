package com.example.lab06.repository;

import com.example.lab06.config.Lab01Properties;
import com.example.lab06.core.domain.Account;
import com.example.lab06.core.dto.AccountDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private RestTemplate restTemplate;
    private Lab01Properties lab01Properties;

    public CustomerRepositoryImpl(Lab01Properties lab01Properties,
                                  RestTemplateBuilder builder){
        this.restTemplate=builder.build();
        this.lab01Properties=lab01Properties;
    }

    @Override
    public Account getById(String id) {

        String typed = id.substring(2,3);

        String apiUrl = null;

        if(typed.compareTo("0")==0) { //Ahorros
            apiUrl = lab01Properties.getCtaAhoApi().getUrl();
        }else if(typed.compareTo("1")==0){ //Corriente
            apiUrl = lab01Properties.getCtaCteApi().getUrl();
        }else{
            apiUrl = lab01Properties.getCtaAhoApi().getUrl();
        }


        AccountDto accountDto = null;

        try{
            accountDto = restTemplate.getForObject(apiUrl + "/" + id,AccountDto.class);
        }catch (HttpServerErrorException ex){
            if(ex.getStatusCode().value()==503){
                accountDto = new AccountDto();
                Account account = new Account();
                account.setAccountId(id + "FromCache");
                account.setAvailableBalance("+100");
                account.setBalance("+101");
                accountDto.setAccount(new Account());
            }
        }
        return accountDto.getAccount();
    }




}
