package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.controllers.CardController;
import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.models.Type;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.CardRepository;
import com.example.kabutops_trumps.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TypeRepository typeRepository;



    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card findCardByID(Long id){
        Card card = cardRepository.findById(id).get();
        return card;
    }

    public List<Card> getCardsByAccountId(Long id){
        Account account = accountRepository.findById(id).get();
        List<Card> cardsInAccount = cardRepository.findByOwnershipsAccount(account);
        return cardsInAccount;
    }



    public List<Card> getCardsInDeckByAccountId(Long id){
        Account account = accountRepository.findById(id).get();
        List<Card> cardsInAccountDeck = cardRepository.findByOwnershipsAccountAndOwnershipsInDeckTrue(account);
        return cardsInAccountDeck;
    }

    public List<Card> getCardsByType(long id){
        Type type = typeRepository.findById(id).get();
        List<Card> typeCards = cardRepository.findByType(type);
//        List<Card> typeCards = new ArrayList<>();
//        for(Card currentCard : allCards){
//            if (currentCard.getType().getName().equals(pokeType)){
//                typeCards.add(currentCard);
//            }
//        }
        return typeCards;
    }

    public List<Card> shuffleDeck(Long id) {
        Account account = accountRepository.findById(id).get();
        List<Card> deck = cardRepository.findByOwnershipsAccountAndOwnershipsInDeckTrue(account);
        Collections.shuffle(deck);
        return deck;
    }

}
