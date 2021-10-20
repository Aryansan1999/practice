package com.example.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

public class last_page extends AppCompatActivity {

    private TextView tv_name,tv_phone,tv_address,tv_status,tv_secretCode;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_address= (TextView) findViewById(R.id.tv_address);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_status = (TextView) findViewById(R.id.tv_status);
        tv_secretCode = (TextView) findViewById(R.id.tv_secretCode);
        mRef = new Firebase("https://console.firebase.google.com/u/0/project/practice-57cf4/database/practice-57cf4-default-rtdb/data");


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Post post = dataSnapshot.getValue(Post.class);
                // ..
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        mPostReference.addValueEventListener(postListener);


//                mRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        String v = dataSnapshot.getValue(String.class);
//                        tv_name.setText(v);
//                    }
//                    @Override
//                    public void onCancelled(FirebaseError firebaseError) {
//
//                    }
//                });

    }
}