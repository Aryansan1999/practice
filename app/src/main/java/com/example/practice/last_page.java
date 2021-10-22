package com.example.practice;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

public class last_page extends AppCompatActivity {


    private FirebaseAuth mAuth;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    // private GoogleSignInClient mGoogleSignInClient;
    //ActivityReadDataBinding binding;
    private TextView tv_name, tv_phone, tv_address, tv_status, tv_secretCode;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_status = (TextView) findViewById(R.id.tv_status);
        tv_secretCode = (TextView) findViewById(R.id.tv_secretCode);

        myRef = FirebaseDatabase.getInstance().getReference("customer");
        //DatabaseReference myRef = database.child("customer");

        //FirebaseUser user=mAuth.getCurrentUser();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {

                    String save=dataSnapshot1.getKey();
                    Log.d("id",save);
                    assert save != null;
                    if(save.equals(user.getUid()))
                    {
                        dataHolder use = new dataHolder();
                        use = dataSnapshot1.getValue(dataHolder.class);
                        assert use != null;
                        Log.d("idp",use.getPhone()+"abc");
                        tv_name.setText(use.getName());
                        tv_phone.setText(use.getPhone());
                        tv_address.setText(use.getAddress());
                        tv_status.setText(use.getStatus());



                    }

                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
//    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
//    DatabaseReference myRef = database.child("profiles/");
//
//myRef.child(phoneNo).addListenerForSingleValueEvent(new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            user = dataSnapshot.getValue(User.class);
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {}
//
//    });
//mPostReference.addValueEventListener(postListener);

}