package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Cheese {

    @NotNull
    @Size(min=3,  max=15, message="Name must be between 3 and 15 characters long")
    @Pattern(regexp="^[ A-Za-z]+$", message="Entry must contain only letters and spaces.")
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;

    private CheeseType type;

    private static int nextId = 1;
    private final int cheeseId;



    public Cheese() {
        this.cheeseId = nextId;
        nextId++;

    }

    public Cheese(String name, String description, CheeseType type) {
        this();
        this.name = name;
        this.description = description;
        this.type = type;

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
