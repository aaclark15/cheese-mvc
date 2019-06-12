package org.launchcode.cheesemvc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    //set fields private

    @NotNull //validation annotations to validate input in field
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message= "Description must not be empty")    //add size for error message
    private String description;

    private CheeseType type; // = would set default selection

    @Min(value=1, message = "Must enter rating between 1-5")
    @Max(value=5, message = "Must enter rating between 1-5")
    private int rating;

    private int cheeseId;
    private static int nextId = 1;

    //constructor
    public Cheese(String name, String description, int rating) {
        this(); //calls the default constructor below to initial the id field
        this.name = name;
        this.description = description;
        this.rating = rating;
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

    public CheeseType getType() {
        return type;
    }
    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
