package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Type;
import com.example.kabutops_trumps.repositories.TypeRepository;
import com.example.kabutops_trumps.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    TypeService typeService;

    @GetMapping
    public ResponseEntity<List<Type>> getAllTypes(){
        List<Type> types = typeService.getAllTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

}
