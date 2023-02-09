package com.example.kabutops_trumps.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Account {

    private long id;
    private String username;
    private String password;
    private int gamesPlayed;
    private int wins;
    private ArrayList<Card> cardsOwned;
    private int spriteNumber;
    private String trainerTitle;
    private ArrayList<Card> deck;
    private boolean isComputer;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.cardsOwned = new ArrayList<Card>();
        this.spriteNumber = 0;
        this.trainerTitle = "Trainer";
        this.deck = new ArrayList<Card>();
        this.isComputer = false;
    }

    public Account() {};

    // Methods may be needed

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public ArrayList<Card> getCardsOwned() {
        return cardsOwned;
    }

    public void setCardsOwned(ArrayList<Card> cardsOwned) {
        this.cardsOwned = cardsOwned;
    }

    public int getSpriteNumber() {
        return spriteNumber;
    }

    public void setSpriteNumber(int spriteNumber) {
        this.spriteNumber = spriteNumber;
    }

    public String getTrainerTitle() {
        return trainerTitle;
    }

    public void setTrainerTitle(String trainerTitle) {
        this.trainerTitle = trainerTitle;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }
}
