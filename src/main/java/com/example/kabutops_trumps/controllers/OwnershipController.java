package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.OwnershipRepository;
import com.example.kabutops_trumps.services.OwnershipService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ownerships")
public class OwnershipController {


    @Autowired
    OwnershipService ownershipService;

    //get all ownerships
    @GetMapping
    public ResponseEntity<List<Ownership>> getAllOwnerships(){
        List<Ownership> ownerships = ownershipService.getAllOwnerships();
        return new ResponseEntity<>(ownerships, HttpStatus.OK);
    }

    //get ownerships by account in deck
    @GetMapping(value = "/{id}/deck")
    public ResponseEntity<List<Ownership>> getOwnershipsByAccountInDeck(@PathVariable long id){
        List<Ownership> ownershipsInAccountDeck = ownershipService.getOwnershipsByAccountInDeck(id);
        return new ResponseEntity<>(ownershipsInAccountDeck, HttpStatus.OK);
    }

    //get all ownerships by account
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Ownership>> getOwnershipsByAccount(@PathVariable long id){
        List<Ownership> ownershipsInAccount = ownershipService.getOwnershipsByAccount(id);
        return new ResponseEntity<>(ownershipsInAccount, HttpStatus.OK);
    }

    //add ownership
    @PostMapping(value = "/{accountId}/{cardId}")
    public ResponseEntity<Ownership> addOwnership(@PathVariable long accountId, @PathVariable long cardId, @RequestParam boolean inDeck){
        Ownership newOwnership = ownershipService.addOwnership(accountId, cardId, inDeck);
        return new ResponseEntity<>(newOwnership, HttpStatus.CREATED);
    }

    //update ownership
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Ownership> updateOwnershipDetails(@PathVariable long id, @RequestParam boolean inDeck){
        Ownership ownership = ownershipService.updateOwnership(id, inDeck);
        return new ResponseEntity<>(ownership, HttpStatus.OK);
    }

    //delete ownership
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteOwnership(@PathVariable long id){
        ownershipService.deleteOwnership(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }


}
