package com.example.aga.listaobrazkow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by aga on 21.03.15.
 */
public class MyListAdapter extends ArrayAdapter<Picture> {

    private int layoutResourceId;
    private List<Picture> data;
    LayoutInflater mInflater;

    public MyListAdapter(Context context, int resourceId, List<Picture> list) {
        super(context, resourceId);
        layoutResourceId = resourceId;
        data = list;
        mInflater = LayoutInflater.from(context.getApplicationContext());

    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        View itemView = row;
        if(itemView == null){
            itemView = mInflater.inflate(layoutResourceId, parent, false);
        }
        Picture currentPicture = data.get(position);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.icon2);
        imageView.setImageResource(currentPicture.getIconID());

        return itemView;
        //return super.getView(position, convertView, parent);
    }
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Make sure we have a view to work with (may have been given null)
//        View itemView = convertView;
//        if (itemView == null) {
//            itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
//        }
//
//        // Find the car to work with.
//        Car currentCar = myCars.get(position);
//
//        // Fill the view
//        ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
//        imageView.setImageResource(currentCar.getIconID());
//
//        // Make:
//        TextView makeText = (TextView) itemView.findViewById(R.id.item_txtMake);
//        makeText.setText(currentCar.getMake());
//
//        // Year:
//        TextView yearText = (TextView) itemView.findViewById(R.id.item_txtYear);
//        yearText.setText("" + currentCar.getYear());
//
//        // Condition:
//        TextView condionText = (TextView) itemView.findViewById(R.id.item_txtCondition);
//        condionText.setText(currentCar.getCondition());
//
//        return itemView;
//    }
}
