package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListContact extends AppCompatActivity {
    ListView list;
    ArrayList<String>listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        list=findViewById(R.id.list);
        listdata=new ArrayList<String>();
            getPhoneContacts();

    }
    private  void getPhoneContacts(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},0);
        }
        ContentResolver contentResolver=getContentResolver();
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor=contentResolver.query(uri,null,null,null,null);
       // Log.i("Contact","Total # of contact ::: "+Integer.toString(cursor.getCount()));
        if (cursor.getCount()>0){
            while(cursor.moveToNext()){
                @SuppressLint("Range")
                String contactName=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                @SuppressLint("Range")
                String contactNumber=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                //Log.i("Contact"," contact Name ::: "+contactName+"   PH ::: "+contactNumber );

                String mycontact=contactName+ "\n" + contactNumber;
                listdata.add(mycontact);

            }
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listdata);
        list.setAdapter(adapter);
    }
}