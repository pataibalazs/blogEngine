package com.example.blogengine.entities;


import javax.persistence.*;

@Entity
@Table
public class Combination {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;
    private Integer catID;
    private Integer blogID;
    private Integer tagID;
    private String tag;


    public Combination(Integer ID, Integer catID, Integer blogID, Integer tagID, String tag) {
        this.ID = ID;
        this.catID = catID;
        this.blogID = blogID;
        this.tagID = tagID;
        this.tag = tag;
    }

    public Combination() {
    }

    public String toString() {
        return "Combination{" +
                "ID=" + ID +
                ", catID=" + catID +
                ", blogID=" + blogID +
                ", tagID=" + tagID +
                ", tag='" + tag + '\'' +
                '}'+"<br>";
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCatID() {
        return catID;
    }

    public void setCatID(Integer catID) {
        this.catID = catID;
    }

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }

    public Integer getTagID() {
        return tagID;
    }

    public void setTagID(Integer tagID) {
        this.tagID = tagID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
