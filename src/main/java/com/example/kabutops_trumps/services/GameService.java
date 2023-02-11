package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.models.Game;
import com.example.kabutops_trumps.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kabutops_trumps.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    TypeRepository typeRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    //Type Multiplier - Eesaa Sheikh §§§§§§§§§§§§§§§§§§§§§§§§§§
    //§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§

    public Type typeCompare(Type typeA, Type typeB, int statA, int statB){
        int strAgainstMultiplier =  2;

        if (typeA.getStrongAgainst().contains(typeB.getName())){
            statA *= strAgainstMultiplier;
        }

        if (typeB.getStrongAgainst().contains(typeA.getName())){
            statB *= strAgainstMultiplier;
        }


        return statA;
    }

    //§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
    //§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
    public Game startNewGame(String accountA, String accountB){
        Game game = new Game(accountA, accountB);
        gameRepository.save(game);
        return game;
    }

    public String processRound(String accountA, String accountB, int statA, int statB){
        if(statA>statB){
            return accountA;
        }
        if(statB>statA){
            return accountB;
        }
        else{
            return null;
        }
    }

    public Game processGame(Game game, int statA, int statB) {
        int finalRound= 7;
        Game currentGame = gameRepository.findById(game.getId()).get();
        int roundNumber = currentGame.getRoundNumber();
        int scoreA = currentGame.getScoreA();
        int scoreB = currentGame.getScoreB();

        if(roundNumber<=finalRound) {
            if (processRound(game.getPlayerA(), game.getPlayerB(), statA, statB).equals(game.getPlayerA())) {
                scoreA += 1;
            } else if (processRound(game.getPlayerA(), game.getPlayerB(), statA, statB).equals(game.getPlayerB())) {
                scoreB += 1;
            } else {
                scoreA += 0.5;
                scoreB += 0.5;
            }
            currentGame.setScoreA(scoreA);
            currentGame.setScoreB(scoreB);
            roundNumber+=1;
            currentGame.setRoundNumber(roundNumber);
            currentGame.setPlayerATurn(!currentGame.isPlayerATurn());
            if(roundNumber==finalRound){
                if(scoreA>scoreB){
                    currentGame.setWinner(game.getPlayerA());
                }
                else if(scoreB>scoreA){
                    currentGame.setWinner(game.getPlayerB());
                }
                else{
                    currentGame.setWinner("Tie");
                }
            }
        }
        gameRepository.save(currentGame);
        return currentGame;
    }


}
