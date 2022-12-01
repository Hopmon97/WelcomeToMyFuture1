package com.example.welcometomyfuture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.BreakIterator;

public class Geoponos extends AppCompatActivity {
    String urladdress = "http://" + MainActivity.ip + "/Android/customer.php";//rwta stelioooo
    /*String[] id;
    String[] Name;
    String[] Surname;
    String[] Password;
    String[] Email;
    String[] Address;
    String[] City;
    String[] Country;
    String[] PostalCode;
    String[] Phone;
    String[] type;
*/

    BottomNavigationView bottom_navigation;


   /* BufferedInputStream is;
    String line = null;
    String result = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoponos);

       /*StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectDataa();

        private void collectDataa()
        {//connection
            try {
                URL url = new URL(urladdress);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                is = new BufferedInputStream(con.getInputStream());


            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // content
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //JSON
            try {
                JSONArray ja = new JSONArray(result);
                JSONObject jo = null;
                id = new String[ja.length()];
                Name = new String[ja.length()];
                Surname = new String[ja.length()];
                Password = new String[ja.length()];
                Email = new String[ja.length()];
                Address = new String[ja.length()];
                City = new String[ja.length()];
                Country = new String[ja.length()];
                PostalCode = new String[ja.length()];
                Phone = new String[ja.length()];
                type = new String[ja.length()];

                // imagepath = new String[ja.length()];

                for (int i = 0; i < ja.length(); i++) {
                    jo = ja.getJSONObject(i);
                    id[i] = jo.getString("customerID");
                    Name[i] = jo.getString("customerName");
                    Surname[i] = jo.getString("customerSurname");
                    Password[i] = jo.getString("password");
                    Email[i] = jo.getString("email");
                    Address[i] = jo.getString("address");
                    City[i] = jo.getString("city");
                    Country[i] = jo.getString("country");
                    PostalCode[i] = jo.getString("postalcode");
                    Phone[i] = jo.getString("phone");
                    type[i] = jo.getString("type");


                    //imagepath[i]=jo.getString("photo");

                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }

*/
            bottom_navigation = findViewById(R.id.bottom_navigation);

            bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            startActivity(new Intent(getApplicationContext(), Geoponos.class));
                            return true;
                        case R.id.nav_products:
                            startActivity(new Intent(getApplicationContext(), ProductsActivity.class));
                            return true;
                        case R.id.nav_cart:
                            startActivity(new Intent(getApplicationContext(), Cart.class));
                            return true;

                    }
                    return false;
                }
            });


        }
    }

