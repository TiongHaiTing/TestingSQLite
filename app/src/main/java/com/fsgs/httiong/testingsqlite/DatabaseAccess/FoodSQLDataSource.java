package com.fsgs.httiong.testingsqlite.DatabaseAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.fsgs.httiong.testingsqlite.DatabaseAccess.FoodContract.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodSQLDataSource {
    private SQLiteDatabase database;
    private FoodSQLHelper dbHelper;
    private String[] allColumn = {
            Food.COLUMN_NAME_FOOD_NAME,
            Food.COLUMN_NAME_FOOD_DESC,
            Food.COLUMN_NAME_FOOD_CAT,
            Food.COLUMN_NAME_HALAL,
            Food.COLUMN_NAME_FOOD_PRICE
    };

    public FoodSQLDataSource(Context context) {
        dbHelper = new FoodSQLHelper(context );
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public long insertUser(FoodRecord foodRecord){
        ContentValues values = new ContentValues();
        values.put(Food.COLUMN_NAME_FOOD_NAME, foodRecord.getFoodName());
        values.put(Food.COLUMN_NAME_FOOD_DESC, foodRecord.getFoodDesc());
        values.put(Food.COLUMN_NAME_FOOD_CAT,foodRecord.getFoodCat());
        values.put(Food.COLUMN_NAME_HALAL, foodRecord.getHalal());
        values.put(Food.COLUMN_NAME_FOOD_PRICE,foodRecord.getPrice());

        database = dbHelper.getWritableDatabase();
        long isInseted = database.insert(Food.TABLE_NAME, null, values);
        database.close();

        return isInseted;
    }

    public List<FoodRecord> getAllFoods(){
        List<FoodRecord> records = new ArrayList<FoodRecord>();
        Cursor cursor = database.query(FoodContract.Food.TABLE_NAME, allColumn , null,
                null, null, null, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            FoodRecord foodRecord = new FoodRecord();
            foodRecord.setFoodName(cursor.getString(0));
            foodRecord.setFoodDesc(cursor.getString(1));
            foodRecord.setFoodCat(cursor.getString(2));
            foodRecord.setHalal(cursor.getString(3));
            foodRecord.setPrice(cursor.getString(4));
            records.add(foodRecord);
            cursor.moveToNext();
        }
        cursor.close();
        return records;
    }
}
