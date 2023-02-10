package com.example.kabutops_trumps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity(name="ownerships")
public class Ownership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "inDeck")
    private boolean inDeck;

    @ManyToOne
    @JsonIgnoreProperties({"ownerships"})
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JsonIgnoreProperties({"ownerships"})
    @JoinColumn(name = "card_id")
    private Card card;

    public Ownership(Account account, Card card) {
        this.account = account;
        this.card = card;
        this.inDeck = false;
    }

    public Ownership(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
