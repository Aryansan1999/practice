package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {
    LottieAnimationView sp;
    EditText name, phone, address;
    Button place_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        place_order = findViewById(R.id.place_order);
        sp = findViewById(R.id.animationView);
        //sp.animate().translationY(8000).setDuration(4000).setStartDelay(4000);
        new Handler().postDelayed(() -> {
            //Intent intent=new Intent(getApplicationContext(),StartupActivity.class);
            //startActivity(intent);
        }, 5000);
        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process();
            }
        });
    }

    private void process() {
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        if (name.getText().toString().equals("") || phone.getText().toString().equals("") || address.getText().toString().equals("")) {
            Toast.makeText(Payment.this, "Please fill all your details", Toast.LENGTH_LONG).show();
        }
        else {
            String NAME = name.getText().toString().trim();
            String PHONE = phone.getText().toString().trim();
            String ADDRESS = address.getText().toString().trim();

            dataHolder obj = new dataHolder(ADDRESS, PHONE);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("customer");

            myRef.child(NAME).setValue(obj);
            Intent intent = new Intent(getApplicationContext(), pay.class);
            startActivity(intent);

        }
    }


}