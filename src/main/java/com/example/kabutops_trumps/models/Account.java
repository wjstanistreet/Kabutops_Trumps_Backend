package com.example.kabutops_trumps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "gamesPlayed")
    private int gamesPlayed;


    @Column(name = "wins")
    private int wins;

//    @ManyToMany
//    @JoinTable(name = "accounts_cards",
//    joinColumns = @JoinColumn(name = "account_id"),
//    inverseJoinColumns = @JoinColumn(name ="card_id"))
//    @JsonIgnoreProperties({"accountsThatOwnCards"})
//    private ArrayList<Card> cardsOwned;

    @OneToMany(mappedBy = "account")
    @JsonIgnoreProperties({"account"})
    private List<Ownership> ownerships;

    @Column(name = "spriteNumber")
    private int spriteNumber;

    @Column(name = "trainerTitle")
    private String trainerTitle;

//    @ManyToMany
//    @JoinTable(name = "accounts_decks",
//    joinColumns = @JoinColumn(name = "account_id"),
//    inverseJoinColumns = @JoinColumn(name = "card_id"))
//    @JsonIgnoreProperties({"decksThatOwnCards"})
//    private ArrayList<Card> deck;

    @Column(name = "isComputer")
    private boolean isComputer;

    public Account(String username, String password, String trainerTitle, boolean isComputer ) {
        this.username = username;
        this.password = password;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.ownerships = new ArrayList<>();
        this.spriteNumber = 0;
        this.trainerTitle = trainerTitle;
        //this.deck = new ArrayList<Card>();
        this.isComputer = isComputer;
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


    public List<Ownership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(List<Ownership> ownerships) {
        this.ownerships = ownerships;
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


//    public ArrayList<Card> getDeck() {
//        return deck;
//    }
//
//    public void setDeck(ArrayList<Card> deck) {
//        this.deck = deck;
//    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }
}
