package com.example.aga.listaobrazkow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by aga on 21.03.15.
 */
public class MyListAdapter extends BaseAdapter {
    private static final int REQ_CODE =123 ;//request code
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

        final Picture current = data.get(index);

        itemName.setText(current.getName());
        itemDesc.setText(current.getDescription());
        final int getIconID = current.getIconID();
        imageView.setImageResource(getIconID);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToSecondActivity(getIconID);

            }
        });

        return row;
    }

    private void sendDataToSecondActivity(int getIconID) {
        Intent secondActivity = new Intent(context, DetailsAboutItem.class);
        secondActivity.putExtra("wysylamDane", false);  //TODO usun
        secondActivity.putExtra("picture",getIconID);
        context.startActivityForResult(secondActivity, REQ_CODE);
    }

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQ_CODE) {
//            // Make sure the request was successful
////            if (resultCode == context.RESULT_OK) {
//                if (data == null) {
//                    return;
//                }
//                String name = data.getStringExtra("test");
//                Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
//           // }
//        }
//    }



}
