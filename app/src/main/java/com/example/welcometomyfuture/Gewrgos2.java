package com.example.welcometomyfuture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Gewrgos2 extends AppCompatActivity {

    BottomNavigationView bottom_navigation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gewrgos2);

        bottom_navigation2=findViewById(R.id.bottom_navigation);

        bottom_navigation2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),Geoponos.class));
                        return true;
                    case R.id.nav_products:
                        startActivity(new Intent(getApplicationContext(),ProductsActivity.class));
                        return true;
                    case R.id.nav_cart:
                        startActivity(new Intent(getApplicationContext(),Cart.class));
                        return true;
                    case R.id.nav_gew:
                        startActivity(new Intent(getApplicationContext(),Gewrgos2.class));
                        return true;
                }
                return false;
            }
        });
    }
}