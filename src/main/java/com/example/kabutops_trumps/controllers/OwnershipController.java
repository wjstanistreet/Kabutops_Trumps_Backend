package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.repositories.OwnershipRepository;
import com.example.kabutops_trumps.services.OwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ownerships")
public class OwnershipController {

    @Autowired
    OwnershipRepository ownershipRepository;

    @Autowired
    OwnershipService ownershipService;

    @GetMapping
    public ResponseEntity<List<Ownership>> getAllOwnerships(){
        List<Ownership> ownerships = ownershipService.getAllOwnerships();
        return new ResponseEntity<>(ownerships, HttpStatus.OK);
    }

}
