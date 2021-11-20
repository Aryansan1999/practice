package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<users> usersArrayList;
    myAdapter myAdapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    public int total = 0;
    public TextView payAmount;
    Button payNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Connecting to server.....");
        progressDialog.show();

        payAmount = findViewById(R.id.payAmount);
        payNow = findViewById(R.id.payNow);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        usersArrayList = new ArrayList<users>();
        myAdapter = new myAdapter(MainActivity.this, usersArrayList);
        recyclerView.setAdapter(myAdapter);
        eventChangeListener();
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                startActivity(intent);
            }
        });
    }

    private void eventChangeListener() {
        db.collection("fruits").orderBy("fruitPrice", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    Log.e("Database Error", error.getMessage());
                    return;
                }
                for (DocumentChange dc : value.getDocumentChanges()) {
                    if (dc.getType() == DocumentChange.Type.ADDED) {
                        usersArrayList.add(dc.getDocument().toObject(users.class));
                    }
                    if (dc.getType() == DocumentChange.Type.MODIFIED) {
                        usersArrayList.add(dc.getDocument().toObject(users.class));
                    }
                    if (dc.getType() == DocumentChange.Type.REMOVED) {
                        usersArrayList.add(dc.getDocument().toObject(users.class));
                    }
                }
                myAdapter.notifyDataSetChanged();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });

    }

//    public void paisaPlus(int amount) {
//        total = total + amount;
//        payAmount.setText(String.valueOf(total));
//    }
//
//
//    @Override
//    public void onClick() {
//
//    }
}