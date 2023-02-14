package com.example.kabutops_trumps.services;

import com.example.kabutops_trumps.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.stereotype.Service;
import com.example.kabutops_trumps.repositories.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.compare;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    OwnershipService ownershipService;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    //Type Multiplier - Eesaa Sheikh §§§§§§§§§§§§§§§§§§§§§§§§§§
    //§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§

    public void rewardWinner(Long winnerId, Long loserId){
        //get losers deck
        //get card that winner doesnt have
        //pick 2 random cards at most
        //create ownership for winner but not in deck

        //idea of returning list of cards won that game to show on frontend
        //congrats u won : display cards or nothing?
    }

    public ArrayList<Double> typeCompare(Type typeA, Type typeB, int statA, int statB) {
        double strAgainstMultiplier = 2.0;

        double newStatA =statA;
        double newStatB =statB;

        if (typeA.getStrongAgainst().contains(typeB.getName())) {
            newStatA = statA * strAgainstMultiplier;
        }

        if (typeA.getWeakAgainst().contains(typeB.getName())) {
            newStatA = statA / strAgainstMultiplier;
        }

        if (typeB.getStrongAgainst().contains(typeA.getName())) {
            newStatB = statB * strAgainstMultiplier;
        }

        if (typeB.getWeakAgainst().contains(typeA.getName())) {
            newStatB = statB / strAgainstMultiplier;
        }

        ArrayList<Double> statList = new ArrayList<Double>();
        statList.add(newStatA);
        statList.add(newStatB);

        return statList;

    }

    //§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
    public Game startNewGame(long playerAId, long playerBId){
        Account accountA = accountRepository.findById(playerAId).get();
        Account accountB = accountRepository.findById(playerBId).get();
        List<Account> players = new ArrayList<>();
        players.add(accountA);
        players.add(accountB);
        System.out.println(players);
        Game game = new Game(players);
        game.setPlayers(players);
        gameRepository.save(game);
        return game;
    }

    public boolean alternatingTurn(boolean turn){
        if(turn){
            return false;
        }
        return true;
    }

    public Game processGame(Long id, int statA, int statB, Long typeAId, Long typeBId) {

        int finalRound= 7;
        Type typeA = typeRepository.findById(typeAId).get();
        Type typeB = typeRepository.findById(typeBId).get();
        Game game = gameRepository.findById(id).get();

        int roundNumber = game.getRoundNumber();
        double scoreA = game.getScoreA();
        double scoreB = game.getScoreB();

        // Type multiplier implementation
        ArrayList<Double> statList = typeCompare(typeA, typeB, statA, statB);
        Double newStatA = statList.get(0);
        Double newStatB = statList.get(1);

        if(roundNumber<finalRound) {
            double roundWinner = (Double.compare(newStatA, newStatB));
            if (roundWinner>0) {
                scoreA += 1;
            }
            else if (roundWinner<0) {
                scoreB += 1;
            } else {
                scoreA += 0.5;
                scoreB += 0.5;
            }
            roundNumber+=1;

            game.setScoreA(scoreA);
            game.setScoreB(scoreB);
            game.setRoundNumber(roundNumber);
            game.setPlayerATurn(alternatingTurn(game.isPlayerATurn()));
            if(roundNumber==finalRound){
                if(scoreA>scoreB){
                    game.setWinner(game.getPlayers().get(0).getUsername());
                }
                else if(scoreB>scoreA){
                    game.setWinner(game.getPlayers().get(1).getUsername());
                }
                else{
                    game.setWinner("Tie");
                }
            }
        }
        gameRepository.save(game);
        return game;
    }
}
