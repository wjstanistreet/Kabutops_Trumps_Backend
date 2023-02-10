package com.example.kabutops_trumps.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity(name = "pokeTypes")
public class PokeType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "strongAgainst")
    private ArrayList<String> strongAgainst;

    @Column(name = "weakAgainst")
    private ArrayList<String> weakAgainst;

    public PokeType(String name, ArrayList<String> strongAgainst, ArrayList<String> weakAgainst) {
        this.name = name;
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
    }

    public PokeType() {};

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
}
