package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> addNewAccount(@RequestBody Account account) {
        Account newAccount = accountService.addNewAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

}
