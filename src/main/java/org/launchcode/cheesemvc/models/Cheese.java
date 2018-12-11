package org.launchcode.cheesemvc.models;

public class Cheese {
    private String name;
    private String description;

    public Cheese(String name) {
        this.name = name;
        this.description = "";
    }

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String aName) {
        if (aName == null) {
            throw new IllegalArgumentException("Cheese name is required");
        }
        this.name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }
}
