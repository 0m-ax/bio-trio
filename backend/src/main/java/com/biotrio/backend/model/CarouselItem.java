package com.biotrio.backend.model;


import javax.persistence.*;

/**
 * Represents the carousel_items table in the database
 *
 * This class contains methods related to setting and getting different parameters of Carousel items.
 * Spring automatically generates the carousel_item table in the localhost using this model
 */
@Entity
@Table(name = "carousel_item")
public class CarouselItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carouselItemID;

    private String title;
    private String text;
    private String image;

    public CarouselItem(){

    }

    public CarouselItem(String title,String text,String image) {
        this.title = title;
        this.text = text;
        this.image = image;
    }

    @Override
    public String toString(){
        return "cinemas{}";
    }

    public int getCarouselItemID() {
        return carouselItemID;
    }

    public void setCarouselItemID(int carouselItemID) {
        this.carouselItemID = carouselItemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
