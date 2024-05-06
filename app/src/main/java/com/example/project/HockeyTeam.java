package com.example.project;

public class HockeyTeam {
    private String id;
    private String name;
    private String location;
    private int size;
    private int cost;
    private String wiki;
    private String imgUrl;

    public HockeyTeam(String id, String name, String type, String location, int size, int cost, String wiki, String imgUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.size = size;
        this.cost = cost;
        this.wiki = wiki;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return name;
    }
}