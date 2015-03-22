package com.example.aga.listaobrazkow;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<Picture> pictures = new ArrayList<Picture>();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] itemDrawables = new int[] { R.drawable.jelen,R.drawable.kot,R.drawable.mysz,R.drawable.pies,R.drawable.sarna,R.drawable.tygrys,R.drawable.sowa1,R.drawable.zaba, };
        String [] itemNames = new String[]{ "jelen","kot","mysz","pies","sarna","tygrys","sowa","zaba" };
        String[] itemDescriptions =   getResources().getStringArray(R.array.animalDescriptions);

        setPicturesList(itemDrawables, itemNames, itemDescriptions);
        setListView(itemDrawables);
    }

    private void setPicturesList(int[] drawables, String[] names, String[] description) {

        for (int i=0; i<drawables.length; i++){
            pictures.add(new Picture(names[i],0,drawables[i], description[i]));
        }
    }
    private void setListView( int [] itemNames) {
//        ArrayAdapter<Picture> adapter = new MyListAdapter(this,R.layout.list_view, pictures );
//        ListView list = (ListView) findViewById(R.id.android_list);
//        list.setAdapter(adapter);
        CodeLearnAdapter adapter = new CodeLearnAdapter(this, pictures);
   ListView list = (ListView) findViewById(R.id.androidList);
        list.setAdapter(adapter);
    }

//    public void onListItemClick(ListView lv ,View view,int position,int imgid) {
//
//        String Slecteditem= (String)getListAdapter().getItem(position);
//        Toast.makeText(this, Slecteditem, Toast.LENGTH_SHORT).show();
//    }

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

    public class CodeLearnAdapter extends BaseAdapter {

       ArrayList<Picture> codeLearnChapterList ;
Activity cxt;

        public CodeLearnAdapter(Activity cxt, ArrayList<Picture> list){
            codeLearnChapterList = list;
            this.cxt = cxt;
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return codeLearnChapterList.size();
        }

        @Override
        public Picture getItem(int position) {
            return codeLearnChapterList.get(position);
        }



        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            if(arg1==null)
            {
                LayoutInflater inflater = (LayoutInflater) cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                arg1 = inflater.inflate(R.layout.list_view, arg2,false);
            }

            TextView chapterName = (TextView)arg1.findViewById(R.id.textView1);
            TextView chapterDesc = (TextView)arg1.findViewById(R.id.textView2);
            ImageView imageView = (ImageView) arg1.findViewById(R.id.imageView1);

            Picture chapter = codeLearnChapterList.get(arg0);

            chapterName.setText(chapter.getName());
            chapterDesc.setText(chapter.getDescription());
            int getIconID = chapter.getIconID();
          imageView.setImageResource(getIconID);

            return arg1;
        }

        public Picture getCodeLearnChapter(int position)
        {
            return codeLearnChapterList.get(position);
        }
}
    }
