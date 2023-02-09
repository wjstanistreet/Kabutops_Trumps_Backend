package com.example.kabutops_trumps.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Card {

    private long id;
    private String name;
    private String imgUrl;
    private String type; // may change this to Type Class later on
    private HashMap<String, Integer> stats;

    public Card(String name, String imgUrl, String type, HashMap<String, Integer> stats) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.type = type;
        this.stats = stats;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Integer> stats) {
        this.stats = stats;
    }
}
