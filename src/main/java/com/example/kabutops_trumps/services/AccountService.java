package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.controllers.AccountController;
import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.OwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OwnershipRepository ownershipRepository;
    
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account findAccountByID(Long id){
        Account account = accountRepository.findById(id).get();
        return account;
    }

    public Account findByAccountDetails(String name, String password){
        List<Account> allAccounts = accountRepository.findAll();
        for(Account currentAccount : allAccounts){
            if ((currentAccount.getUsername().equals(name))&&(currentAccount.getPassword().equals(password))){
                return currentAccount;
            }
        }

        return null;
    }

    public Account addNewAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    public Account updateAccountDetails(long id, Account accountParameter) {
        Account account = accountRepository.findById(id).get();
        account.setUsername(accountParameter.getUsername());
        account.setPassword(accountParameter.getPassword());
        account.setGamesPlayed(accountParameter.getGamesPlayed());
        account.setWins(accountParameter.getWins());
        account.setOwnerships(accountParameter.getOwnerships());
        account.setSpriteNumber(accountParameter.getSpriteNumber());
        account.setTrainerTitle(accountParameter.getTrainerTitle());
        account.setComputer(accountParameter.isComputer());
        accountRepository.save(account);
        Account updatedAccount = accountRepository.findById(id).get();
        return updatedAccount;
    }

    // to complete
    public void deleteAccount(long id) {
        
        List<Ownership> ownershipsToDelete = ownershipRepository.findByAccount(accountRepository.findById(id).get());
        for (Ownership ownership : ownershipsToDelete) {
            ownershipRepository.deleteById(ownership.getId());
        }
        accountRepository.deleteById(id);

    }
}
