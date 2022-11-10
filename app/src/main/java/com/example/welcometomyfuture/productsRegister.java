package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class productsRegister extends AppCompatActivity {
    private EditText etProductName,etCompany,etSeller;
    private String name,company,seller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_register);
        etProductName = findViewById(R.id.etProductsName);
        etCompany = findViewById(R.id.etCountry);
        etSeller = findViewById(R.id.etSeller);


    }
    public void saveProduct(View view)
    {
        name=etProductName.getText().toString().trim();
        company=etCompany.getText().toString().trim();
        seller=etSeller.getText().toString().trim();
    }
}