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

    public ArrayList<Integer> typeCompare(Type typeA, Type typeB, int statA, int statB) {
        int strAgainstMultiplier = 2;

        if (typeA.getStrongAgainst().contains(typeB.getName())) {
            statA *= strAgainstMultiplier;
        }

        if (typeA.getWeakAgainst().contains(typeB.getName())) {
            statA /= strAgainstMultiplier;
        }

        if (typeB.getStrongAgainst().contains(typeA.getName())) {
            statB *= strAgainstMultiplier;
        }

        if (typeB.getWeakAgainst().contains(typeA.getName())) {
            statB /= strAgainstMultiplier;
        }

        ArrayList<Integer> statList = new ArrayList<Integer>();
        statList.add(statA);
        statList.add(statB);

//        int stats[] = new int[2];
//
//        stats[0] = statA;
//        stats[1] = statB;

        return statList;

    }
    //§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
    //if the code from line 30 does not work, use this instead.


    //§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
//    public int typeCompareStrong(Type typeA, Type typeB, int statA, int statB){
//        int strAgainstMultiplier = 2;
//        if (typeA.getStrongAgainst().contains(typeB.getName())) {
//            statA *= strAgainstMultiplier;
//
//
//        }
//        return statA;
//    }
//
//    public int typeCompareWeak(Type typeA, Type typeB, int statA, int statB){
//        int strAgainstMultiplier = 2;
//        if (typeB.getStrongAgainst().contains(typeA.getName())) {
//            statB *= strAgainstMultiplier;
//
//
//        }
//        return statB;
//    }



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

    public Game processGame(Game game, int statA, int statB, Type typeA, Type typeB) {
        int finalRound= 7;
        Game currentGame = gameRepository.findById(game.getId()).get();
        int roundNumber = currentGame.getRoundNumber();
        int scoreA = currentGame.getScoreA();
        int scoreB = currentGame.getScoreB();

        // Type multiplier implementation
        ArrayList<Integer> statList = typeCompare(typeA, typeB, statA, statB);
        statA = statList.get(0);
        statB = statList.get(1);
        //

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
