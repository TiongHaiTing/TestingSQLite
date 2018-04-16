package com.fsgs.httiong.testingsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fsgs.httiong.testingsqlite.DatabaseAccess.FoodRecord;
import com.fsgs.httiong.testingsqlite.DatabaseAccess.FoodRecordAdapter;
import com.fsgs.httiong.testingsqlite.DatabaseAccess.FoodSQLDataSource;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvFoodList = (ListView)findViewById(R.id.lvfoodList);
        lvFoodList.setOnItemClickListener(this);

    }

    private void updateList() {
//Retrieve records from SQLite
        FoodSQLDataSource foodSQLDataSource= new FoodSQLDataSource(this);
        foodSQLDataSource.open();
        final List<FoodRecord> values = foodSQLDataSource.getAllFoods();
        FoodRecordAdapter adapter = new FoodRecordAdapter(this,
                R.layout.food_list_display, values);
//Link adapter to ListView
        lvFoodList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    protected void onResume() {
        updateList();
        super.onResume();
    }

}
