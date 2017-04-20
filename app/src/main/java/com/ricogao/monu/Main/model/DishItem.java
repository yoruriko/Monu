package com.ricogao.monu.Main.model;

import java.util.List;

/**
 * Created by ricogao on 2017/4/20.
 */

public class DishItem {
    long id;
    float calories;
    String name;
    float price;
    List<String> imgSrcs;
    String description;
    String ingredients;
    String allergens;
    String bestGoWith;
    String dishFacts;

    public DishItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getImgSrcs() {
        return imgSrcs;
    }

    public void setImgSrcs(List<String> imgSrcs) {
        this.imgSrcs = imgSrcs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getBestGoWith() {
        return bestGoWith;
    }

    public void setBestGoWith(String bestGoWith) {
        this.bestGoWith = bestGoWith;
    }

    public String getDishFacts() {
        return dishFacts;
    }

    public void setDishFacts(String dishFacts) {
        this.dishFacts = dishFacts;
    }
}
