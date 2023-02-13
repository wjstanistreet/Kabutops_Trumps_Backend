package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Game;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.GameRepository;
import com.example.kabutops_trumps.repositories.TypeRepository;
import com.example.kabutops_trumps.services.GameService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService gameService;

    //get all games
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    //add new game
    @PostMapping
    public ResponseEntity<Game> addNewGame(@RequestParam (required = true, value = "playerAId") long playerAId,
                                             @RequestParam (required = true, value = "playerBId") long playerBId) {
        Game newGame = gameService.startNewGame(playerAId,playerBId);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

    //update game
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable long id,
                                           @RequestParam(value = "statA") int statA,
                                           @RequestParam(value = "statB") int statB,
                                           @RequestParam(value = "typeAId") long typeAId,
                                           @RequestParam(value = "typeBId") long typeBId){
        Game updatedGame = gameService.processGame(id, statA, statB, typeAId,typeBId);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);
    }

}
