package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.controllers.CardController;
import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;



    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public List<Card> shuffleDeck(Account account) {
        List<Card> deck = cardRepository.findByOwnershipsAccountAndOwnershipsInDeckTrue(account);
        Collections.shuffle(deck);
        return deck;
    }

}
