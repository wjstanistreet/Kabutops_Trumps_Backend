package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kabutops_trumps.repositories.*;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public void startNewGame(String accountA, String accountB){
        Game game = new Game(accountA, accountB);
        gameRepository.save(game);
    }

    public void processRound(int statA, int statB){

    }



}
