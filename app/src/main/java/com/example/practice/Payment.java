package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class Payment extends AppCompatActivity implements PaymentResultListener {
    LottieAnimationView sp;
    EditText name, phone, address;
    Button place_order;
    RadioGroup radioGroup;
    RadioButton radiobutton;
    String STATUS;
    private final String TAG = " main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        radioGroup = findViewById(R.id.radiogroup);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);

        place_order = findViewById(R.id.place_order);
        sp = findViewById(R.id.animationView);
        new Handler().postDelayed(() -> {
        }, 5000);
        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radiobutton = findViewById(radioId);

                String cod = "Cash on delivery";
                if (radiobutton.getText().equals(cod)) {
                    STATUS = "unpaid";

                    if (name.getText().toString().equals("") || phone.getText().toString().equals("") || address.getText().toString().equals("")) {
                        Toast.makeText(Payment.this, "Please fill all your details", Toast.LENGTH_LONG).show();
                    } else {
                        process();
                    }
                    Intent intent = new Intent(getApplicationContext(), display_details.class);
                    startActivity(intent);
                } else {
                    startPayment();
                    STATUS = "paid";
                    if (name.getText().toString().equals("") || phone.getText().toString().equals("") || address.getText().toString().equals("")) {
                        Toast.makeText(Payment.this, "Please fill all your details", Toast.LENGTH_LONG).show();
                    } else {
                        process();
                    }
//
                }

            }
        });
    }

    private void process() {

        String NAME = name.getText().toString().trim();
        String PHONE = phone.getText().toString().trim();
        String ADDRESS = address.getText().toString().trim();
        String st = STATUS;


        dataHolder obj = new dataHolder(NAME, ADDRESS, PHONE, st);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("customer");
        myRef.child(user.getUid()).setValue(obj);

    }

    public void onRadioButtonClicked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radiobutton = findViewById(radioId);
    }

    public void startPayment() {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_lFrShc6cBXNBkZ");

        checkout.setImage(R.drawable.lemon);
        final Activity activity = this;
        final Checkout co = new Checkout();
        try {
            JSONObject options = new JSONObject();
            options.put("name", "Aryan vege store");
            options.put("description", "App Payment");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://rzp-mobile.s3.amazonaws.com/images/rzp.png");
            options.put("currency", "INR");
            String payment = "200";
            // amount is in paise so please multiple it by 100
            //Payment failed Invalid amount (should be passed in integer paise. Minimum value is 100 paise, i.e. ₹ 1)
            double total = Double.parseDouble(payment);
            total = total * 100;
            options.put("amount", total);
            JSONObject preFill = new JSONObject();
            preFill.put("email", "2005152@kiit.ac.in");
            options.put("theme.color", "#FFAB40");
            preFill.put("contact", "7665180930");
            options.put("prefill", preFill);
            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {

        Log.e(TAG, " payment successfull " + s.toString());
        Toast.makeText(this, "Payment successfully done! " + s, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), display_details.class);
        startActivity(intent);

    }

    @Override
    public void onPaymentError(int i, String s) {
        Log.e(TAG, "error code " + String.valueOf(i) + " -- Payment failed " + s.toString());
        try {
            Toast.makeText(this, "Payment error please try again", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("OnPaymentError", "Exception in onPaymentError", e);
        }
    }

}