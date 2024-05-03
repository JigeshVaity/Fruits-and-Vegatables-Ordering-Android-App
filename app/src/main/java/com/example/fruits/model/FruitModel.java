package com.example.fruits.model;
import java.io.Serializable;
public class FruitModel implements Serializable {

    private String pic;
    private String title;
    private Double fee;
    private String weight;
    private int numberInCart;
    public FruitModel() {
    }

    public FruitModel(String  pic, String title, Double price, String weight) {
        this.pic = pic;
        this.title = title;
        this.fee = price;
        this.weight = weight;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
