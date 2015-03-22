package com.example.aga.listaobrazkow;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aga on 21.03.15.
 */
public class MyListAdapter extends BaseAdapter {
    ArrayList<Picture> data;
    Activity context;

    public MyListAdapter(Activity cxt, ArrayList<Picture> list){
        data = list;
        this.context = cxt;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Picture getItem(int position) {
        return data.get(position);
    }



    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int index, View row, ViewGroup parent) {

        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_view, parent,false);
        }

        TextView itemName = (TextView)row.findViewById(R.id.itemName);
        TextView itemDesc = (TextView)row.findViewById(R.id.itemDesc);
        ImageView imageView = (ImageView) row.findViewById(R.id.icon);

        Picture current = data.get(index);

        itemName.setText(current.getName());
        itemDesc.setText(current.getDescription());
        int getIconID = current.getIconID();
        imageView.setImageResource(getIconID);

        return row;
    }

    public Picture getCodeLearnChapter(int position)
    {
        return data.get(position);
    }
}
