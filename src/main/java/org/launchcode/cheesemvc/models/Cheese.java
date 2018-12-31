package org.launchcode.cheesemvc.models;

import java.util.Objects;

public class Cheese {
    private static int nextId = 1;
    private int cheeseId;
    private String name;
    private String description;


    public Cheese(String name) {
        this.cheeseId = nextId;
        nextId++;
        this.description = "";
    }

    public Cheese(String name, String description) {
        this.cheeseId = nextId;
        nextId++;
        this.name = name;
        this.description = description;
    }


    public int getCheeseId() {
        return cheeseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cheese cheese = (Cheese) o;
        return cheeseId == cheeseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cheeseId);
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "cheeseId=" + cheeseId +
                ", name='" + name + '\'' +
                '}';
    }
}
