package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    //get all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    //get account by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id){
        Account account = accountService.findAccountByID(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

     //get account by username and password
    @GetMapping(value = "/login")
    public ResponseEntity<Account> getAccountByName(@RequestParam(name ="name") String name,
                                                    @RequestParam(name ="password") String password){
        Account account = accountService.findByAccountDetails(name,password);
        if(account==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }

    //add new account
    @PostMapping
    public ResponseEntity<Account> addNewAccount(@RequestBody Account account) {
        Account newAccount = accountService.addNewAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    //update an account
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody Account account){
        Account updatedAccount = accountService.updateAccountDetails(id, account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    //delete an account
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteAccount(@PathVariable long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
