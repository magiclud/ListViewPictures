package com.example.aga.listaobrazkow;


import android.content.Intent;

import android.net.Uri;

import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ListView;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class MainActivity extends ActionBarActivity {

    private static final int REQ_CODE =123 ;//request code
    static final int REQUEST_TAKE_PHOTO = 0;
    private  String imageFileName;
    private  String timeStamp;
    private  String mCurrentPhotoPath;
    private ArrayList<Picture> pictures = new ArrayList<>();
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("cyklZycia", "onCreate_MainActivity");
        setContentView(R.layout.activity_main);


        int[] itemDrawables = new int[] { R.drawable.jelen,R.drawable.kot,R.drawable.mysz,R.drawable.pies,R.drawable.sarna,R.drawable.tygrys,R.drawable.sowa1,R.drawable.zaba, };
        String [] itemNames = new String[]{ "jelen","kot","mysz","pies","sarna","tygrys","sowa","zaba" };
        String[] itemDescriptions =   getResources().getStringArray(R.array.animalDescriptions);

        setPicturesList(itemDrawables, itemNames, itemDescriptions);
        setListView();
    }

    private void setPicturesList(int[] drawables, String[] names, String[] description) {

        for (int i=0; i<drawables.length; i++){
            pictures.add(new Picture(names[i],drawables[i], description[i]));
        }
    }
    private void setListView( ) {
        MyListAdapter adapter = new MyListAdapter(this, pictures);
        list = (ListView) findViewById(R.id.androidList);
        list.setAdapter(adapter);
        list.deferNotifyDataSetChanged();
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
            dispatchTakePictureIntent();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//        Log.d("mia", String.valueOf(requestCode));

        if (requestCode == REQ_CODE && data != null) {

                int index = data.getIntExtra("indexChangedPicture", 0);
                float mark2 = data.getFloatExtra("newMark", 0);
                pictures.get(index).setMark(mark2);
                sortPictureList();
                list.invalidateViews();//aktualizacja
        }
        if ( requestCode == 0 && resultCode==RESULT_OK ) {
          if(mCurrentPhotoPath!=null){
              setPic();
            galleryAddPic();

          mCurrentPhotoPath=null;
          }
        }
    }

    private void setPic() {
        pictures.add(new Picture(timeStamp,timeStamp+" : "+ imageFileName, mCurrentPhotoPath));
        list.invalidateViews();//aktualizacja
    }
private void galleryAddPic() {
    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
    File f = new File(mCurrentPhotoPath);
    Uri contentUri = Uri.fromFile(f);
    mediaScanIntent.setData(contentUri);
    this.sendBroadcast(mediaScanIntent);
}

    private void sortPictureList() {
        Collections.sort(pictures, new Comparator<Picture>() {
            public int compare(Picture p1, Picture p2) {
                return Integer.valueOf((int)p2.getMark()).compareTo((int) p1.getMark());
            }
        });
    }

    @Override
    public  void onStart(){
        super.onStart();
        Log.d("cyklZycia", "onStart_MainActivity");
    }
    @Override
    public  void onResume(){
        super.onResume();
        Log.d("cyklZycia", "onResume_MainActivity");
    }
    @Override
    public  void onRestart(){
        super.onRestart();
        Log.d("cyklZycia", "onRestart_MainActivity");
    }
    @Override
    public  void onPause(){
        super.onPause();
        Log.d("cyklZycia", "onPause_MainActivity");
    }
    @Override
    public  void onStop(){
        super.onStop();
        Log.d("cyklZycia", "onStop_MainActivity");
    }
    @Override
    public  void onDestroy(){
        super.onDestroy();
        Log.d("cyklZycia", "onDestroy_MainActivity");
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile;
            try {
                photoFile = createImageFile();


            // Continue only if the File was successfully created
            if (photoFile != null) {
                Log.d("PHOTO", "phoyo File = "+photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                takePictureIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
            } catch (IOException ex) {
                ex.printStackTrace();
                mCurrentPhotoPath = null;

            }
        }
    }



    private File createImageFile() throws IOException {
        // Create an image file name
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
         imageFileName = "PNG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".png",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath =  image.getAbsolutePath();
        return image;
    }
   }
