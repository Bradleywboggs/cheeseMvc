package org.launchcode.cheesemvc.models;

import java.util.Objects;

public class Cheese {
    private static int nextId = 1;
    private int id;
    private String name;
    private String description;


    public Cheese(String name) {
        this.name = name;
        this.description = "";
    }

    public Cheese(String name, String description) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.description = description;
    }


    public int getId() {
        return id;
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
        return id == cheese.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
