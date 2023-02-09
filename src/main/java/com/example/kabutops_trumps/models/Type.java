package com.example.kabutops_trumps.models;

import java.util.ArrayList;

public class Type {

    private long id;
    private String name;
    private ArrayList<String> strongAgainst;
    private ArrayList<String> weakAgainst;

    public Type(String name, ArrayList<String> strongAgainst, ArrayList<String> weakAgainst) {
        this.name = name;
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
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
}
