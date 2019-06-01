package com.biotrio.backend.model;


import javax.persistence.*;

/**
 * Represents the attribute table in the database
 *
 * This class contains methods related to setting and getting different parameters of attributes.
 * Spring automatically generates the attribute table in the localhost using this model
 */
@Entity
@Table(name="attribute")
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

