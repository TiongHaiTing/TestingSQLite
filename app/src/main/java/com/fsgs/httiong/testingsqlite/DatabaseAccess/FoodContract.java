package com.fsgs.httiong.testingsqlite.DatabaseAccess;

import android.provider.BaseColumns;

public final class FoodContract {
    public FoodContract(){

    }
    public static abstract class Food implements BaseColumns{
        public static final String TABLE_NAME = "FOOD";
        public static final String COLUMN_NAME_FOOD_NAME = "Food_Name";
        public static final String COLUMN_NAME_FOOD_DESC = "Food_Desc";
        public static final String COLUMN_NAME_FOOD_CAT = "Food_Cat";
        public static final String COLUMN_NAME_HALAL = "Halal";
        public static final String COLUMN_NAME_FOOD_PRICE = "Food_Price";

    }
}
