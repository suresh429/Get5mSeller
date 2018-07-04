package com.pivotalsoft.get5mseller;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pivotalsoft.get5mseller.Adapters.GridView_Adapter;
import com.pivotalsoft.get5mseller.CustomJava.CustomGallery_Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class VerificationDocsActivity extends AppCompatActivity implements View.OnClickListener {
    // Request code for camera
    private final int CAMERA_REQUEST_CODE = 100;

    // Request code for runtime permissions
    private final int REQUEST_CODE_STORAGE_PERMS = 321;

    private static LinearLayout openCustomGallery,openCustomGallery1,openCustomGallery2,openCustomGallery3;

    private static GridView selectedImageGridView;
    private static GridView selectedImageGridView1;
    private static GridView selectedImageGridView2;
    private static GridView selectedImageGridView3;

    private static ImageView imgone,imgtwo,imgthree,imgfour;


    private static final int CustomGallerySelectId = 1;//Set Intent Id
    private static final int CustomGallerySelectId1 = 2;//Set Intent Id
    private static final int CustomGallerySelectId2 = 3;//Set Intent Id
    private static final int CustomGallerySelectId3 = 4;//Set Intent Id



    public static final String CustomGalleryIntentKey = "ImageArray";//Set Intent Key Value
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_docs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Verification documents");

        initViews();
        setListeners();
        getSharedImages();
    }

    //Init all views
    private void initViews() {
         openCustomGallery = (LinearLayout) findViewById(R.id.openCustomGallery);
         selectedImageGridView = (GridView) findViewById(R.id.selectedImagesGridView);

        openCustomGallery1 = (LinearLayout) findViewById(R.id.openCustomGallery1);
        selectedImageGridView1 = (GridView) findViewById(R.id.selectedImagesGridView1);

        openCustomGallery2 = (LinearLayout) findViewById(R.id.openCustomGallery2);
        selectedImageGridView2 = (GridView) findViewById(R.id.selectedImagesGridView2);

        openCustomGallery3 = (LinearLayout) findViewById(R.id.openCustomGallery3);
        selectedImageGridView3 = (GridView) findViewById(R.id.selectedImagesGridView3);

        imgone=(ImageView)findViewById(R.id.addone);
        imgtwo=(ImageView)findViewById(R.id.addtwo);
        imgthree=(ImageView)findViewById(R.id.addthree);
        imgfour=(ImageView)findViewById(R.id.addfour);



    }

    //set Listeners
    private void setListeners() {
        openCustomGallery.setOnClickListener(this);
        openCustomGallery1.setOnClickListener(this);
        openCustomGallery2.setOnClickListener(this);
        openCustomGallery3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (hasPermissions()){

            switch (view.getId()) {
            case R.id.openCustomGallery:
                //Start Custom Gallery Activity by passing intent id
                startActivityForResult(new Intent(VerificationDocsActivity.this, CustomGallery_Activity.class), CustomGallerySelectId);
                break;

            case R.id.openCustomGallery1:
                //Start Custom Gallery Activity by passing intent id
                startActivityForResult(new Intent(VerificationDocsActivity.this, CustomGallery_Activity.class), CustomGallerySelectId1);
                break;

            case R.id.openCustomGallery2:
                //Start Custom Gallery Activity by passing intent id
                startActivityForResult(new Intent(VerificationDocsActivity.this, CustomGallery_Activity.class), CustomGallerySelectId2);
                break;

            case R.id.openCustomGallery3:
                //Start Custom Gallery Activity by passing intent id
                startActivityForResult(new Intent(VerificationDocsActivity.this, CustomGallery_Activity.class), CustomGallerySelectId3);
                break;
        }

        }else {

            requestNecessaryPermissions();
        }

    }

// permisions
    @SuppressLint("WrongConstant")
    private boolean hasPermissions() {
        int res = 0;
        // list all permissions which you want to check are granted or not.
        String[] permissions = new String[] {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        for (String perms : permissions){
            res = checkCallingOrSelfPermission(perms);
            if (!(res == PackageManager.PERMISSION_GRANTED)){
                // it return false because your app dosen't have permissions.
                return false;
            }

        }
        // it return true, your app has permissions.
        return true;
    }
// permissions
    private void requestNecessaryPermissions() {
        // make array of permissions which you want to ask from user.
        String[] permissions = new String[] {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // have arry for permissions to requestPermissions method.
            // and also send unique Request code.
            requestPermissions(permissions, REQUEST_CODE_STORAGE_PERMS);
        }
    }

    protected void onActivityResult(int requestcode, int resultcode, Intent imagereturnintent) {
        super.onActivityResult(requestcode, resultcode, imagereturnintent);
        switch (requestcode) {
            case CustomGallerySelectId:
                if (resultcode == RESULT_OK) {
                    String imagesArray = imagereturnintent.getStringExtra(CustomGalleryIntentKey);//get Intent data
                    //Convert string array into List by splitting by ',' and substring after '[' and before ']'
                    List<String> selectedImages = Arrays.asList(imagesArray.substring(1, imagesArray.length() - 1).split(", "));
                    loadGridView(new ArrayList<String>(selectedImages));//call load gridview method by passing converted list into arrayList

                }
                break;

            case CustomGallerySelectId1:
                if (resultcode == RESULT_OK) {

                    String imagesArray1 = imagereturnintent.getStringExtra(CustomGalleryIntentKey);//get Intent data
                    //Convert string array into List by splitting by ',' and substring after '[' and before ']'
                    List<String> selectedImages1 = Arrays.asList(imagesArray1.substring(1, imagesArray1.length() - 1).split(", "));
                    loadGridView1(new ArrayList<String>(selectedImages1));//call load gridview method by passing converted list into arrayList
                }
                break;

            case CustomGallerySelectId2:
                if (resultcode == RESULT_OK) {

                    String imagesArray2 = imagereturnintent.getStringExtra(CustomGalleryIntentKey);//get Intent data
                    //Convert string array into List by splitting by ',' and substring after '[' and before ']'
                    List<String> selectedImages2 = Arrays.asList(imagesArray2.substring(1, imagesArray2.length() - 1).split(", "));
                    loadGridView2(new ArrayList<String>(selectedImages2));//call load gridview method by passing converted list into arrayList
                }
                break;

            case CustomGallerySelectId3:
                if (resultcode == RESULT_OK) {

                    String imagesArray3 = imagereturnintent.getStringExtra(CustomGalleryIntentKey);//get Intent data
                    //Convert string array into List by splitting by ',' and substring after '[' and before ']'
                    List<String> selectedImages3 = Arrays.asList(imagesArray3.substring(1, imagesArray3.length() - 1).split(", "));
                    loadGridView3(new ArrayList<String>(selectedImages3));//call load gridview method by passing converted list into arrayList
                }
                break;


        }
    }

    //Load GridView
    private void loadGridView(ArrayList<String> imagesArray ) {
        GridView_Adapter adapter = new GridView_Adapter(VerificationDocsActivity.this, imagesArray, false);
        selectedImageGridView.setAdapter(adapter);

        selectedImageGridView.setVisibility(View.VISIBLE);
    }

    //Load GridView1
    private void loadGridView1(ArrayList<String> imagesArray1 ) {
        GridView_Adapter adapter1 = new GridView_Adapter(VerificationDocsActivity.this, imagesArray1, false);
        selectedImageGridView1.setAdapter(adapter1);

        selectedImageGridView1.setVisibility(View.VISIBLE);
    }

    //Load GridView2
    private void loadGridView2(ArrayList<String> imagesArray2 ) {
        GridView_Adapter adapter2 = new GridView_Adapter(VerificationDocsActivity.this, imagesArray2, false);
        selectedImageGridView2.setAdapter(adapter2);

        selectedImageGridView2.setVisibility(View.VISIBLE);
    }


    //Load GridView3
    private void loadGridView3(ArrayList<String> imagesArray3 ) {
        GridView_Adapter adapter3 = new GridView_Adapter(VerificationDocsActivity.this, imagesArray3, false);
        selectedImageGridView3.setAdapter(adapter3);

        selectedImageGridView3.setVisibility(View.VISIBLE);
    }



    //Read Shared Images
    private void getSharedImages() {

        //If Intent Action equals then proceed
        if (Intent.ACTION_SEND_MULTIPLE.equals(getIntent().getAction())
                && getIntent().hasExtra(Intent.EXTRA_STREAM)) {
            ArrayList<Parcelable> list = getIntent().getParcelableArrayListExtra(Intent.EXTRA_STREAM);//get Parcelabe list

            ArrayList<String> selectedImages = new ArrayList<>();
            ArrayList<String> selectedImages1 = new ArrayList<>();
            ArrayList<String> selectedImages2 = new ArrayList<>();
            ArrayList<String> selectedImages3 = new ArrayList<>();

            //Loop to all parcelable list
            for (Parcelable parcel : list) {
                Uri uri = (Uri) parcel;//get URI
                String sourcepath = getPath(uri);//Get Path of URI

                selectedImages.add(sourcepath);//add images to arraylist
                selectedImages1.add(sourcepath);
                selectedImages2.add(sourcepath);//add images to arraylist
                selectedImages3.add(sourcepath);

            }
            loadGridView(selectedImages);//call load gridview
            loadGridView1(selectedImages1);
            loadGridView2(selectedImages2);//call load gridview
            loadGridView3(selectedImages3);
        }
    }


    //get actual path of uri
    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        startManagingCursor(cursor);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_socilainform, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_done:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
