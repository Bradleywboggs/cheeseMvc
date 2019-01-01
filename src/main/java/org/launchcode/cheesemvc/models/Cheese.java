package org.launchcode.cheesemvc.models;

import java.util.Objects;

public class Cheese {
    private String name;

    private String description;

    private static int nextId = 1;
    private final int cheeseId;



    public Cheese() {
        this.cheeseId = nextId;
        nextId++;

    }

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }



    public int getCheeseId() {
        return cheeseId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cheese cheese = (Cheese) o;
        return this.cheeseId == cheese.cheeseId;
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
