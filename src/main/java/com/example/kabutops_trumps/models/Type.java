package com.example.kabutops_trumps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "pokeTypes")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "strongAgainst")
    private ArrayList<String> strongAgainst;

    @Column(name= "colourType")
    private String colourType;

    @Column(name = "weakAgainst")
    private ArrayList<String> weakAgainst;

    @OneToMany(mappedBy = "type")
    @JsonIgnoreProperties({"type"})
    private List<Card> cardList;

    public Type(String name, ArrayList<String> strongAgainst, ArrayList<String> weakAgainst, String colourType) {
        this.name = name;
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
        this.colourType =colourType;
    }

    public Type() {};

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

    public ArrayList<String> getStrongAgainst() {
        return strongAgainst;
    }

    public void setStrongAgainst(ArrayList<String> strongAgainst) {
        this.strongAgainst = strongAgainst;
    }

    public ArrayList<String> getWeakAgainst() {
        return weakAgainst;
    }

    public void setWeakAgainst(ArrayList<String> weakAgainst) {
        this.weakAgainst = weakAgainst;
    }


    public String getColourType() {
        return colourType;
    }

    public void setColourType(String colourType) {
        this.colourType = colourType;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }


}
