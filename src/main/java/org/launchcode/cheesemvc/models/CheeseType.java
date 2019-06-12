package org.launchcode.cheesemvc.models;

public enum CheeseType {

    //declare names that will be displayed
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    //constructor - default level
    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
