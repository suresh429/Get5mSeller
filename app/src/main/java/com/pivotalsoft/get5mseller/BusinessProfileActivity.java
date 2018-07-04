package com.pivotalsoft.get5mseller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.pivotalsoft.get5mseller.Controllers.Utility;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.pivotalsoft.get5mseller.Controllers.FileUtils.getPath;

public class BusinessProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    String selectedImagePath;
    Uri selectedImageUri;
    ImageView imageView;
    RelativeLayout workinghourLayout,socialLayout,photosLayout,verificationLayout;
    private final int REQUEST_CODE_PLACEPICKER = 3;
    String latitude,longitude;
    TextView locateMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile);

       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Business Profile");

        workinghourLayout =(RelativeLayout)findViewById(R.id.workinghourLayout);
        socialLayout=(RelativeLayout)findViewById(R.id.socialLayout);
        photosLayout =(RelativeLayout)findViewById(R.id.photosLayout);
        verificationLayout =(RelativeLayout)findViewById(R.id.verificationLayout);
        locateMap=(TextView)findViewById(R.id.textViewLocate);
        imageView =(ImageView)findViewById(R.id.imgProfile);
        imageView.setOnClickListener(this);

        workinghourLayout.setOnClickListener(this);
        socialLayout.setOnClickListener(this);
        photosLayout.setOnClickListener(this);
        verificationLayout.setOnClickListener(this);
        locateMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.workinghourLayout:

                Intent intent =new Intent(this,BusinessHoursActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;

            case R.id.socialLayout:

                Intent intent1 =new Intent(this,SocialInformationActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);

                break;

            case R.id.photosLayout:

                Intent intent2 =new Intent(this,PhotosActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);

                break;

            case R.id.verificationLayout:

                Intent intent3 =new Intent(this,VerificationDocsActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);

                break;

            case R.id.textViewLocate:

                startPlacePickerActivity();

                break;

            case R.id.imgProfile:

                selectImage();

                break;
        }

    }

    // google place picker
    private void startPlacePickerActivity() {
        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        // this would only work if you have your Google Places API working

        try {
            Intent intent = intentBuilder.build(this);
            startActivityForResult(intent, REQUEST_CODE_PLACEPICKER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void displaySelectedPlaceFromPlacePicker(Intent data) {
        Place placeSelected = PlacePicker.getPlace(data, this);
        Log.e("placeSelected",""+placeSelected);

        String name = placeSelected.getName().toString();
        String address = placeSelected.getAddress().toString();
        Log.e("address",""+address);

        final TextView locationTxt =(TextView)findViewById(R.id.addClinic_location) ;
        locationTxt.setText(address);

        // places latitude
        LatLng qLoc = placeSelected.getLatLng();
        Double lat =qLoc.latitude;
        Log.e("lat", "Place: " + lat);
        latitude = String.valueOf(lat);

        // places longitude
        Double lon =qLoc.longitude;
        Log.e("lon", "Place: " + lon);
        longitude =String.valueOf(lon);


      /*  TextView enterCurrentLocation = (TextView) findViewById(R.id.textView9);
        enterCurrentLocation.setText(name + ", " + address);*/
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(BusinessProfileActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result= Utility.checkPermission(BusinessProfileActivity.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask ="Take Photo";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask ="Choose from Library";
                    if(result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        //intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, REQUEST_CAMERA);
    }


    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {


            if (requestCode == SELECT_FILE) {
                onSelectFromGalleryResult(data);
            }
            else if (requestCode == REQUEST_CAMERA) {
                onCaptureImageResult(data);
            }
            else if (requestCode == REQUEST_CODE_PLACEPICKER){
                displaySelectedPlaceFromPlacePicker(data);
            }
        }

    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageView.setImageBitmap(thumbnail);
        Log.e("image",""+imageView);

        selectedImageUri = Uri.fromFile(destination);
        selectedImagePath=getPath(getBaseContext(),selectedImageUri);

        // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
        // selectedImageUri = getImageUri(getApplicationContext(), thumbnail);
    }
    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        imageView.setImageBitmap(bm);
        Log.e("image123",""+imageView);

        selectedImageUri = data.getData();
        Log.e("pathuri",""+selectedImageUri);
        selectedImagePath = getPath(this, selectedImageUri);
        Log.e("path",""+selectedImagePath);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
