package com.fsgs.httiong.testingsqlite.DatabaseAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fsgs.httiong.testingsqlite.DatabaseAccess.FoodContract.Food;

public class FoodSQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";

    public FoodSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Food.TABLE_NAME + "(" +
                    Food.COLUMN_NAME_FOOD_NAME + " TEXT," +
                    Food.COLUMN_NAME_FOOD_DESC + " TEXT," +
                    Food.COLUMN_NAME_FOOD_CAT + " TEXT," +
                    Food.COLUMN_NAME_HALAL + " TEXT," +
                    Food.COLUMN_NAME_FOOD_PRICE + " TEXT" +
                    ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Food.TABLE_NAME;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
}
