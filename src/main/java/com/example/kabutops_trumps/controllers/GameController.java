package com.example.kabutops_trumps.controllers;

import com.example.kabutops_trumps.models.Game;
import com.example.kabutops_trumps.repositories.GameRepository;
import com.example.kabutops_trumps.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Game> addNewReader(@RequestBody Game game) {
        Game newGame = gameService.startNewGame(game.getPlayerA(), game.getPlayerB());
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

}
