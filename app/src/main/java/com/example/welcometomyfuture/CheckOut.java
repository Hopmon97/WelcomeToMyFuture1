package com.example.welcometomyfuture;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckOut extends AppCompatActivity {
    String urladdress = "http://" + MainActivity.ip + "/Android/customer.php";//rwta stelioooo
    String name;
    String phone;
    String Date;
    String email;
    String address;
    String postal;
    String card;
    String exp;
    String cvc;
    String total;
    EditText etUsername, etPhone,date,etEmail,etAddress,postalcode,cardno,exdate,etcvc;
    TextView priceTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        Bundle data = getIntent().getExtras();

        priceTotal=findViewById(R.id.price);


        priceTotal.setText(data.getString("total"));



        etUsername = findViewById(R.id.etUsername);
        etPhone= findViewById(R.id.phone);
        date = findViewById(R.id.date);
        etEmail = findViewById(R.id.email);
        etAddress = findViewById(R.id.Address);
        postalcode = findViewById(R.id.postalcode);
        cardno = findViewById(R.id.cardno);
        exdate = findViewById(R.id.exdate);
        etcvc = findViewById(R.id.cvc);




        etUsername.setText(background.customerName);
        etPhone.setText(background.phone);
        etEmail.setText(background.email);
        etAddress.setText(background.address);
        postalcode.setText(background.postalcode);


    }

    public void Payment (View view)
    {
        name = etUsername.getText().toString();
        background.customerName = name;
        phone = etPhone.getText().toString();
        background.phone = phone;
        email = etEmail.getText().toString();
        background.email = email;
        address = etAddress.getText().toString();
        background.address = address;
        postal = postalcode.getText().toString();
        background.postalcode = postal;
        card = cardno.getText().toString();
        exp = exdate.getText().toString();
        cvc = etcvc.getText().toString();
        total = priceTotal.getText().toString();
        Date = date.getText().toString();



    }
}
