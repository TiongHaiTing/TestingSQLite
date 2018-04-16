package com.fsgs.httiong.testingsqlite.DatabaseAccess;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fsgs.httiong.testingsqlite.R;

import java.util.List;

public class FoodRecordAdapter extends ArrayAdapter<FoodRecord> {

    public FoodRecordAdapter(@NonNull Context context, int resource, @NonNull List<FoodRecord> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView,ViewGroup parent){
        FoodRecord foodRecord = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.food_list_display,
                            parent,
                            false);
        }

        TextView tvFoodName, tvDesc,tvFoodCat, tvHalal, tvprice;

        tvFoodName = (TextView) convertView.findViewById(R.id.tvFoodName);
        tvDesc= (TextView) convertView.findViewById(R.id.tvDesc);
        tvFoodCat= (TextView) convertView.findViewById(R.id.tvFoodCat);
        tvHalal = (TextView) convertView.findViewById(R.id.tvHalal);
        tvprice = (TextView) convertView.findViewById(R.id.tvPrice);

        tvFoodName.setText(foodRecord.getFoodName());
        tvDesc.setText(foodRecord.getFoodDesc());
        tvFoodCat.setText(foodRecord.getFoodCat());
        tvHalal.setText(foodRecord.getHalal());
        tvprice.setText(foodRecord.getPrice());

        return convertView;
    }
}
