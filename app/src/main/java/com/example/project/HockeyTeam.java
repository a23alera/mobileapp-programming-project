package com.example.project;

public class HockeyTeam {
    private String id;
    private String name;
    private String location;
    private int size;
    private int cost;
    private String category;
    private String auxData;
    private String company;

    public HockeyTeam(String id, String name, String location, int size, int cost, String category, String auxData) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.size = size;
        this.cost = cost;
        this.category = category;
        this.auxData = auxData;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public String getAuxData() {
        return auxData;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return name;
    }
}
