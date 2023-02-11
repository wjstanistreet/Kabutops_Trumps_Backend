package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.CardRepository;
import com.example.kabutops_trumps.repositories.OwnershipRepository;
import com.example.kabutops_trumps.services.AccountService;
import com.example.kabutops_trumps.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OwnershipRepository ownershipRepository;

    @Autowired
    CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/deck")
    public ResponseEntity<List<Card>> getCardsByAccountInDeck(@PathVariable long id){
        List<Card> cardsInAccountDeck = cardRepository.findByOwnershipsAccountAndOwnershipsInDeckTrue(accountRepository.findById(id).get());
        return new ResponseEntity<>(cardsInAccountDeck, HttpStatus.OK);
    }

}
