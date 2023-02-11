package com.example.kabutops_trumps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "games")
public class Game {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
//    @JsonIgnoreProperties({"games"})
//    @JoinColumn(name = "account_id")
////    @Column(name = "playerA")
//    private Account playerA;
//
//    @ManyToOne
//    @JsonIgnoreProperties({"games"})
//    @JoinColumn(name = "account_id")
////    @Column(name = "playerB")
//    private Account playerB;

    @ManyToMany(mappedBy = "games")
    //@JsonIgnoreProperties({"games"})
    private List<Account> players;

    @Column(name = "scoreA")
    private int scoreA;

    @Column(name = "scoreB")
    private int scoreB;

    @Column(name = "roundNumber")
    private int roundNumber;

    @Column(name = "playerATurn")
    private boolean playerATurn;

    @Column(name = "winner")
    private String winner;

    public Game(List<Account> players) {
        this.players = players;
        this.scoreA = 0;
        this.scoreB = 0;
        this.roundNumber = 0;
        this.playerATurn = true; // might randomise this later
        this.winner = "";
    }

    public Game(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Account getPlayerA() {
//        return players.get(0);
//    }
//
//    public Account getPlayerB() {
//        return players.get(1);
//    }

    public List<Account> getPlayers() {
        return players;
    }

    public void setPlayers(List<Account> players) {
        this.players = players;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public boolean isPlayerATurn() {
        return playerATurn;
    }

    public void setPlayerATurn(boolean playerATurn) {
        this.playerATurn = playerATurn;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
