package com.fsgs.httiong.testingsqlite.DatabaseAccess;

public class FoodRecord {

    private String foodName, foodDesc, foodCat;
    private String halal;
    private String price;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public String getFoodCat() {
        return foodCat;
    }

    public void setFoodCat(String foodCat) {
        this.foodCat = foodCat;
    }

    public String getHalal() {
        return halal;
    }

    public void setHalal(String halal) {
        this.halal = halal;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
