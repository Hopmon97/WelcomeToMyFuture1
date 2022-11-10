package com.example.welcometomyfuture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //BottomNavigationView bottom_navigation;


    EditText pas, usr;

    public static String ip="192.168.178.21";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /*bottom_navigation=findViewById(R.id.bottom_navigation);

        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), activity.class));
                        return true;
                    case R.id.kx_cart:
                        startActivity(new Intent(getApplicationContext(), activity.class));
                        return true;
                }
                return false;
            }
        });*/


        usr = (EditText) findViewById(R.id.etUsername);
        pas = (EditText) findViewById(R.id.etPassword);

        /*MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginBtn);
*/


        }
    public void loginBtn(View view){
        String user= usr.getText().toString();
        String pass= pas.getText().toString();

    background bg = new background(this);
    bg.execute(user,pass);
    }

    public void registerBtn(View view)
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
        finish();
    }
}