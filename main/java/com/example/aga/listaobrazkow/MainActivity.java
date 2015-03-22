package com.example.aga.listaobrazkow;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<Picture> pictures = new ArrayList<Picture>();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] drawables = new int[] { R.drawable.jelen,R.drawable.kot,R.drawable.mysz,R.drawable.pies,R.drawable.sarna,R.drawable.tygrys,R.drawable.sowa1,R.drawable.zaba, };
        String [] names = new String[]{ "jelen","kot","mysz","pies","sarna","tygrys","sowa","zaba" };
        setPicturesList(drawables, names);
        setListView();
    }

    private void setPicturesList(int[] drawables, String[] names) {

        for (int i=0; i<drawables.length; i++){
            pictures.add(new Picture(names[i],0,drawables[i]));
        }
    }
    private void setListView() {
        ArrayAdapter<Picture> adapter = new MyListAdapter(this,R.layout.items_view, pictures );
        ListView list = (ListView) findViewById(R.id.picturesListView);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyListAdapter2 extends ArrayAdapter<Picture> {



        public MyListAdapter2() {
            super(MainActivity.this, R.layout.items_view,pictures);
        }

        @Override
        public View getView(int position, View row, ViewGroup parent) {
            View itemView = row;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.items_view, parent, false);
            }
            Picture currentPicture = pictures.get(position);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.icon);
            imageView.setImageResource(currentPicture.getIconID());

            return itemView;
            //return super.getView(position, convertView, parent);
        }
}
    }
