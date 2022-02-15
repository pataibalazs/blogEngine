package com.example.blogengine.entities;


import javax.persistence.*;

@Entity
@Table
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagID;
    private Integer catID;
    private String tag;

    public Tag(Integer tagID, Integer catID, String tag) {
        this.tagID = tagID;
        this.catID = catID;
        this.tag = tag;
    }


    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagID=" + tagID +
                ", catID=" + catID +
                ", tag='" + tag + '\'' +
                '}'+"<br>";
    }

    public Integer getTagID() {
        return tagID;
    }

    public void setTagID(Integer tagID) {
        this.tagID = tagID;
    }

    public Integer getCatID() {
        return catID;
    }

    public void setCatID(Integer catID) {
        this.catID = catID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
