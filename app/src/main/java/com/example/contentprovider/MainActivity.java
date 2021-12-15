package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button) findViewById(R.id.button);
        bt.setOnClickListener(this);
        bt=findViewById(R.id.add);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button){
            Intent i=new Intent(this,ListContact.class);
            startActivity(i);

        }
        if (v.getId()==R.id.add){
            Intent i=new Intent(this,AddContact.class);
            startActivity(i);

        }
    }

}