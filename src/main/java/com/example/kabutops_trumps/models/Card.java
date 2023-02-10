package com.example.kabutops_trumps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity(name = "cards")
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "imgUrl")
    private String imgUrl;

    @ManyToOne
    @JsonIgnoreProperties({"cardList"})
    @JoinColumn(name = "type_id")
    private Type type; // may change this to Type Class later on

    @Column(name ="hp")
    private int hp;

    @Column(name ="attack")
    private int attack;

    @Column(name ="defence")
    private int defence;

    @Column(name ="specialAttack")
    private int specialAttack;

    @Column(name ="specialDefence")
    private int specialDefence;

    @Column(name ="speed")
    private int speed;

//    @ManyToMany(mappedBy = "cardsOwned")
//    @JsonIgnoreProperties({"cardsOwned"})
//    private ArrayList<Account> accountsThatOwnCards;

    @OneToMany(mappedBy = "card")
    @JsonIgnoreProperties({"card"})
    private List<Ownership> ownerships;

//    @ManyToMany(mappedBy = "deck")
//    @JsonIgnoreProperties({"deck"})
//    private ArrayList<Account> decksThatOwnCards;


    public Card(String name, String imgUrl, Type type, int hp, int attack, int defence, int specialAttack, int specialDefence, int speed) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defence = defence;
        this.specialDefence = specialDefence;
        this.speed = speed;
        this.ownerships = new ArrayList<>();
        //this.decksThatOwnCards = new ArrayList<Account>();
    }

    public Card() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpecialDefence() {
        return specialDefence;
    }

    public void setSpecialDefence(int specialDefence) {
        this.specialDefence = specialDefence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<Ownership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(List<Ownership> ownerships) {
        this.ownerships = ownerships;
    }

//    public ArrayList<Account> getDecksThatOwnCards() {
//        return decksThatOwnCards;
//    }
//
//    public void setDecksThatOwnCards(ArrayList<Account> decksThatOwnCards) {
//        this.decksThatOwnCards = decksThatOwnCards;
//    }
}
