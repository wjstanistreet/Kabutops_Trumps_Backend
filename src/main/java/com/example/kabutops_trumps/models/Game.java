package com.example.kabutops_trumps.models;

import jakarta.persistence.*;

@Entity(name = "games")
public class Game {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "playerA")
    private String playerA;

    @Column(name = "playerB")
    private String playerB;

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

    public Game(String playerA, String playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
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

    public String getPlayerA() {
        return playerA;
    }

    public void setPlayerA(String playerA) {
        this.playerA = playerA;
    }

    public String getPlayerB() {
        return playerB;
    }

    public void setPlayerB(String playerB) {
        this.playerB = playerB;
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
