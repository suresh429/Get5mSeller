package com.pivotalsoft.get5mseller.Fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pivotalsoft.get5mseller.Controllers.Utility;
import com.pivotalsoft.get5mseller.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.pivotalsoft.get5mseller.Controllers.FileUtils.getPath;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherInfoFragment extends Fragment implements View.OnClickListener {
    private String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    String selectedImagePath,selectedImagePathPant,selectedImagePathCheque;
    Uri selectedImageUri,selectedImageUriPan,selectedImageUriCheque;
    ImageView imageViewCst,imageViewPan,imageViewCheque;
    View rootView;
    public OtherInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_other_info, container, false);

        imageViewCst = (ImageView)rootView. findViewById(R.id.imageViewCst);
        imageViewCst.setOnClickListener(this);

        imageViewPan = (ImageView)rootView. findViewById(R.id.imageViewPan);
        imageViewPan.setOnClickListener(this);

        imageViewCheque = (ImageView)rootView. findViewById(R.id.imageViewCheque);
        imageViewCheque.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imageViewCst:

                selectImage();

                break;

            case R.id.imageViewPan:

                selectImage();

                break;
            case R.id.imageViewCheque:

                selectImage();

                break;

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if (userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }
    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = Utility.checkPermission(getContext());

                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    if (result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    if (result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, REQUEST_CAMERA);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        Log.e("data",""+data);

        if (resultCode == Activity.RESULT_OK) {


            if (requestCode == SELECT_FILE) {
                onSelectFromGalleryResult1(data);
            } else if (requestCode == REQUEST_CAMERA) {
                onCaptureImageResult(data);
            }
           /* else if (requestCode == REQUEST_CODE_PLACEPICKER){
                displaySelectedPlaceFromPlacePicker(data);
            }*/
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

        imageViewCst.setImageBitmap(thumbnail);
        Log.e("image", "" + imageViewCst);

        selectedImageUri = Uri.fromFile(destination);
        selectedImagePath = getPath(getContext(), selectedImageUri);

        // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
        // selectedImageUri = getImageUri(getApplicationContext(), thumbnail);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult1(Intent data) {

        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        imageViewCst.setImageBitmap(bm);
        Log.e("image123", "" + imageViewCst);

        selectedImageUri = data.getData();
        Log.e("pathuri", "" + selectedImageUri);
        selectedImagePath = getPath(getContext(), selectedImageUri);
        Log.e("path", "" + selectedImagePath);
    }



}
