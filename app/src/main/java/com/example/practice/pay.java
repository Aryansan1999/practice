package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class pay extends AppCompatActivity implements PaymentResultListener {
    RadioGroup radioGroup;
    RadioButton radiobutton;
    Button final_pay;
    private final String TAG = " main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        radioGroup = findViewById(R.id.radiogroup);
        final_pay = findViewById(R.id.final_pay);
        final_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radiobutton = findViewById(radioId);

                String cod = "Cash on delivery";
                if (radiobutton.getText().equals(cod)) {
                    Intent intent = new Intent(getApplicationContext(), last_page.class);
                    startActivity(intent);
                } else {
                    startPayment();
                }
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radiobutton = findViewById(radioId);
    }

    public void startPayment() {
        /**
         * You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
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
        // payment successfull pay_DGU19rDsInjcF2
        Log.e(TAG, " payment successfull " + s.toString());
        Toast.makeText(this, "Payment successfully done! " + s, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), last_page.class);
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