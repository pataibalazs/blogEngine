package com.example.blogengine.entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;

    public Category(Integer ID) {
        this.ID = ID;
    }

    public Category() {
    }

    public int getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }


    @Override
    public String toString() {
        return "Category{" +
                "ID=" + ID +
                '}'+"<br>";
    }
}

