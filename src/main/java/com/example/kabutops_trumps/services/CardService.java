package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.controllers.CardController;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
