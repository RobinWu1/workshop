package com.example.workshop.ui.fun.foodScreen;

public class FoodsModel {

    public int foodImage;
    public String foodName;

    public FoodsModel(String foodName, int foodImage) {
        this.foodImage = foodImage;
        this.foodName = foodName;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
