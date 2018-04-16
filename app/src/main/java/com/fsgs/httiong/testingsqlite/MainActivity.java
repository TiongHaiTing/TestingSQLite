package com.fsgs.httiong.testingsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fsgs.httiong.testingsqlite.DatabaseAccess.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edFoodName, edDesc, edFoodCat, edHahal, edprice;
    private Button btnAdd, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edFoodName = (EditText)findViewById(R.id.edFoodName);
        edDesc  = (EditText)findViewById(R.id.edDesc);
        edFoodCat  = (EditText)findViewById(R.id.edFoodCat);
        edHahal  = (EditText)findViewById(R.id.edHahal);
        edprice  = (EditText)findViewById(R.id.edprice);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodRecord foodRecord = new FoodRecord();

                foodRecord.setFoodName(edFoodName.getText().toString());
                foodRecord.setFoodDesc(edDesc.getText().toString());
                foodRecord.setFoodCat(edFoodCat.getText().toString());
                foodRecord.setHalal(edHahal.getText().toString());
                foodRecord.setPrice(edprice.getText().toString());

                FoodSQLDataSource dbSource = new FoodSQLDataSource(getApplicationContext());
                long isInserted = dbSource.insertUser(foodRecord);

                if( isInserted != -1){
                    Toast.makeText(getApplicationContext(), "New Food Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView = (Button)findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
