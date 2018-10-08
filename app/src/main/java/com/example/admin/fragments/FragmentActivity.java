package com.example.admin.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;


public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        Fragment1 fragment1 = new Fragment1();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_one, fragment1);
        transaction.commit();


        Fragment2 fragment2 = new Fragment2();
        FragmentManager manager2 = getSupportFragmentManager();
        FragmentTransaction transaction2 = manager2.beginTransaction();
        transaction2.add(R.id.fragment_two, fragment2);
        transaction2.commit();


        Button call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermission()) {
                    Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    in.setData(Uri.parse("tel:8686863055"));
                    startActivityForResult(in, 200);
                } else {
                    requestPermission();
                    Toast.makeText(FragmentActivity.this, "not given", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void requestPermission() {


        ActivityCompat.requestPermissions(FragmentActivity.this, new String[]
                {Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA}, 100);
    }

    private boolean checkPermission() {
        int FirstPermissionResult = ContextCompat.checkSelfPermission(FragmentActivity.this, CALL_PHONE);
        int sec = ContextCompat.checkSelfPermission(FragmentActivity.this, CAMERA);
        if (FirstPermissionResult == PackageManager.PERMISSION_GRANTED
                && sec == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
        public void onRequestPermissionsResult ( int requestCode, String permissions[],
        int[] grantResults){
            switch (requestCode) {
                case 100:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        Log.e("value", "Permission Granted, Now you can use local drive .");
                    } else {
                        Log.e("value", "Permission Denied, You cannot use local drive .");
                    }
                    break;
            }
        }
    }
