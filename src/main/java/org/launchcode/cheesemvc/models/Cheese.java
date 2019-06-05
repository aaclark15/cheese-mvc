package org.launchcode.cheesemvc.models;

public class Cheese {

    //set fields private
    private String name;
    private String description;

    //constructor
    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
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


}
