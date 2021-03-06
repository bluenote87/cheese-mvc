package org.launchcode.cheesemvc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min=3, max=15, message = "The name of this cheese should be between 3 and 15 characters")
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;

    private CheeseType type;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    private int cheeseId;
    //protected static int nextID;

    public Cheese(String aName, String aDescription) {
        this();
        this.name = aName;
        this.description = aDescription;
    }

    public Cheese() {
        //cheeseId = nextID;
        //nextID++;

    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
