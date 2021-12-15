package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity  {
    Button bt;
    EditText name,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.num);
        bt=(Button) findViewById(R.id.addContact);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()  && !phone.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME,name.getText().toString());
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE,phone.getText().toString());
                    startActivity(intent);


                }else{
                    Toast.makeText(AddContact.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}