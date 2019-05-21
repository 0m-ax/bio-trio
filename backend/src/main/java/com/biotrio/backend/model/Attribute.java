package com.biotrio.backend.model;


import javax.persistence.*;

@Entity
@Table(name="tickets")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attributeID;

    public String attributeName;

    public Attribute(){

    }
    public Attribute(int attributeID, String attributeName){
        this.attributeID = attributeID;
        this.attributeName = attributeName;
    }

    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    @Override
    public String toString(){
        return "attirubteS{}";
    }

}

