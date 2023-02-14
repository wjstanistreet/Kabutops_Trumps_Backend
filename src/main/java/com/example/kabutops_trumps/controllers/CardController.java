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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {




    @Autowired
    CardService cardService;

    //get all cards
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    //get card by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable long id){
        Card card = cardService.findCardByID(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    //get cards by account
    @GetMapping(value = "/account/{id}")
    public ResponseEntity<List<Card>> getCardsByAccountId(@PathVariable long id){
        List<Card> cardsInAccount = cardService.getCardsByAccountId(id);
        return new ResponseEntity<>(cardsInAccount, HttpStatus.OK);
    }

    //get cards in accounts deck
    @GetMapping(value = "/account/{id}/deck")
    public ResponseEntity<List<Card>> getCardsInDeckByAccountId(@PathVariable long id){
        List<Card> cardsInAccountDeck = cardService.getCardsInDeckByAccountId(id);
        return new ResponseEntity<>(cardsInAccountDeck, HttpStatus.OK);
    }

    //get shuffled deck of an account
    @GetMapping(value = "/account/{id}/deck/shuffle")
    public ResponseEntity<List<Card>> getShuffledDeckForAccount(@PathVariable long id){
        List<Card> shuffledDeck = cardService.shuffleDeck(id);
        return new ResponseEntity<>(shuffledDeck, HttpStatus.OK);
    }

    @GetMapping(value = "/type")
    public ResponseEntity<List<Card>> getCardsByType(@RequestParam(value = "typeId") Long id){
        List<Card> cardsByType = cardService.getCardsByType(id);
        return new ResponseEntity<>(cardsByType, HttpStatus.OK);
    }

}
