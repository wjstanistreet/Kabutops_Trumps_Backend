package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.OwnershipRepository;
import com.example.kabutops_trumps.services.OwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ownerships")
public class OwnershipController {

    @Autowired
    OwnershipRepository ownershipRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OwnershipService ownershipService;

    @GetMapping
    public ResponseEntity<List<Ownership>> getAllOwnerships(){
        List<Ownership> ownerships = ownershipService.getAllOwnerships();
        return new ResponseEntity<>(ownerships, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/deck")
    public ResponseEntity<List<Ownership>> getOwnershipsByAccountInDeck(@PathVariable long id){
        List<Ownership> ownershipsInAccountDeck = ownershipRepository.findByAccountAndInDeckTrue(accountRepository.findById(id).get());
        return new ResponseEntity<>(ownershipsInAccountDeck, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Ownership>> getOwnershipsByAccount(@PathVariable long id){
        List<Ownership> ownershipsInAccount = ownershipRepository.findByAccount(accountRepository.findById(id).get());
        return new ResponseEntity<>(ownershipsInAccount, HttpStatus.OK);
    }

}
