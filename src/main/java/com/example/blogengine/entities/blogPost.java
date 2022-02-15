package com.example.blogengine.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component
@Entity
@Table
public class blogPost {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ID;
    private String tagName;
    private String context;
    private LocalDateTime creationTime;
    private LocalDateTime lastModification;


    public blogPost(Integer ID, String tagName, String context, LocalDateTime creationTime, LocalDateTime lastModification) {
        this.ID = ID;
        this.tagName = tagName;
        this.context = context;
        this.creationTime = creationTime;
        this.lastModification = lastModification;
    }
    public blogPost() {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getLastModification() {
        return lastModification;
    }

    public void setLastModification(LocalDateTime lastModification) {
        this.lastModification = lastModification;
    }

    @Override
    public String toString() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "blogPost{" +
                "ID=" + ID +
                ", tagName='" + tagName + '\'' +
                ", context='" + context + '\'' +
                ", creationTime=" + creationTime.format(format) +
                ", lastModification=" + lastModification.format(format) +
                '}'+"<br>";
    }
}


