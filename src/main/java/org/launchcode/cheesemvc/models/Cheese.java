package org.launchcode.cheesemvc.models;

public class Cheese {

    //set fields private
    private String name;
    private String description;
    private int cheeseId;
    private static int nextId = 1;

    //constructor
    public Cheese(String name, String description) {
        this(); //calls the default constructor below to initial the id field
        this.name = name;
        this.description = description;
    }

    //default constructor - needed to use model binding
    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    //getter and setter methods
    public String getName() {
        return name;
    }
    public void setName(String cheeseName) {
        this.name = cheeseName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String cheeseDesc) {
        this.description = cheeseDesc;
    }

    public int getCheeseId() {
        return cheeseId;
    }
    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }
}
