package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<editTextview> extends AppCompatActivity {
    
    EditText et1;
    Button bt1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        et1 = (EditText)findViewById(R.id.editTextPhone2);
        bt1 = (Button)findViewById(R.id.button2);
        
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Business logic 
                String number = et1.getText().toString();
               Intent callintent = new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:"+number));
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(getApplicationContext(), "Please Allow me to CALL!", Toast.LENGTH_SHORT).show();
                    return; 

                }
                startActivity(callintent);

            }
        });

    }
}

