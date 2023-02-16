package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.CardRepository;
import com.example.kabutops_trumps.repositories.OwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnershipService {

    @Autowired
    OwnershipRepository ownershipRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CardRepository cardRepository;

    public List<Ownership> getAllOwnerships() {
        return ownershipRepository.findAll();
    }

    public List<Ownership> getOwnershipsByAccountInDeck(Long id){
        List<Ownership> ownershipsInAccountDeck = ownershipRepository.findByAccountAndInDeckTrue(accountRepository.findById(id).get());
        return ownershipsInAccountDeck;
    }

    public List<Ownership> getOwnershipsByAccount(Long id){
        List<Ownership> ownershipsInAccount = ownershipRepository.findByAccount(accountRepository.findById(id).get());
        return ownershipsInAccount;
    }

    public List<Ownership> getOwnershipsByAccountAndCard(Long accountId, Long cardId){

        Account account = accountRepository.findById(accountId).get();
        Card card = cardRepository.findById(cardId).get();
        List<Ownership> ownershipsInAccount = ownershipRepository.findByAccountAndCard(account, card);
        return ownershipsInAccount;
    }


    public Ownership addOwnership(long accountId, long cardId, boolean inDeck) {
        Account account = accountRepository.findById(accountId).get();
        Card card = cardRepository.findById(cardId).get();
        List<Ownership> ownershipsInAccount = ownershipRepository.findByAccountAndCard(account, card);
        if(ownershipsInAccount.isEmpty()){
            Ownership ownership = new Ownership(accountRepository.findById(accountId).get(), cardRepository.findById(cardId).get(), inDeck);
            ownershipRepository.save(ownership);
            return ownership;
        }
        else{
            return ownershipsInAccount.get(0);
        }
    }

    public void rewardWinner(Long winnerId, Long loserId){
        //get losers deck
        //get card that winner doesnt have
        //pick 2 random cards at most
        //create ownership for winner but not in deck

        //idea of returning list of cards won that game to show on frontend
        //congrats u won : display cards or nothing?
    }

    public Ownership updateOwnership(long id, boolean inDeck) {

        Ownership ownership = ownershipRepository.findById(id).get();
        ownership.setInDeck(inDeck);
        ownershipRepository.save(ownership);
        Ownership updatedOwnership = ownershipRepository.findById(id).get();
        return updatedOwnership;
    }

    public void deleteOwnership(long id) {
        ownershipRepository.deleteById(id);
    }
}
