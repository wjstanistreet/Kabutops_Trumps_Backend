package com.example.kabutops_trumps.services;

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


    public Ownership addOwnership(long accountId, long cardId, boolean inDeck) {
        Ownership ownership = new Ownership(accountRepository.findById(accountId).get(), cardRepository.findById(cardId).get(), inDeck);

        ownershipRepository.save(ownership);
        return ownership;
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
