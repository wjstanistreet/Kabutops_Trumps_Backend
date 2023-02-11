package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.repositories.OwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnershipService {

    @Autowired
    OwnershipRepository ownershipRepository;

    public List<Ownership> getAllOwnerships() {
        return ownershipRepository.findAll();
    }



}
