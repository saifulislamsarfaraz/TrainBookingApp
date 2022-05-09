package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SeatSelection extends AppCompatActivity {

    Button btnCardPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);
        btnCardPay = (Button) findViewById(R.id.btncardpay);

        btnCardPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SeatSelection.this, payment_activity.class);
                startActivity(i);
          }
        });

    }

}