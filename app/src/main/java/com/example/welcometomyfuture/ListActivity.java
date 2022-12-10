package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ListActivity extends AppCompatActivity {

    String urladdress="http://"+MainActivity.ip +"/Android/customer.php";//rwta stelioooo
    String id;
    String[] customer;
    String[] name;
    String[] surname;
    String[] email;
    String[] address;
    String[] city;
    String[] country;
    String[] postalcode;
    String[] phone;
    String[] type;



    ListView listView;
    BufferedInputStream is;
    String line= null;
    String result = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView= findViewById(R.id.lview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        ListViewAdapter customLiseView=new ListViewAdapter(this, customer,name,surname, email, address, city, country, postalcode, phone, type);
        listView.setAdapter(customLiseView);


    }

    private void collectData()
    {//connection
        try
        {
            URL url = new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());


        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        // content
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line=br.readLine())!=null)
            {
                sb.append(line+"\n");
            }
            is.close();
            result = sb.toString();

        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //JSON
        try
        {
            JSONArray ja = new JSONArray(result);
            JSONObject jo=null;
            customer = new String[ja.length()];
            name = new String[ja.length()];
            surname = new String[ja.length()];
            email = new String[ja.length()];
            address = new String[ja.length()];
            city = new String[ja.length()];
            country = new String[ja.length()];
            postalcode = new String[ja.length()];
            phone = new String[ja.length()];
            type = new String[ja.length()];

           // imagepath = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                customer[i]=jo.getString("customerID");
                name[i]=jo.getString("customerName");
                surname[i]=jo.getString("customerSurname");
                email[i]=jo.getString("email");
                address[i]=jo.getString("address");
                city[i]=jo.getString("city");
                country[i]=jo.getString("country");
                postalcode[i]=jo.getString("postalcode");
                phone[i]=jo.getString("phone");
                type[i]=jo.getString("type");


                //imagepath[i]=jo.getString("photo");

            }



        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

}