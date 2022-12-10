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

public class OrdersActivity extends AppCompatActivity {

    String urladdress="http://"+MainActivity.ip +"/Android/get_order_for_user.php";
    String[] pname;
    String[] price;
    String[] quantity;




    ListView listView;
    BufferedInputStream is;
    String line= null;
    String result = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        listView= findViewById(R.id.recview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        GetOrder getOrder = new GetOrder(OrdersActivity.this);
        getOrder.execute();
    }

    public class GetOrder extends AsyncTask<String,Void,String> {

        Context context;

        public GetOrder(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {

        }
        @Override
        protected void onPostExecute(String result) {

            System.out.println(result);

            try
            {
                JSONArray ja = new JSONArray(result);
                JSONObject jo=null;
                pname = new String[ja.length()];
                price = new String[ja.length()];
                quantity = new String[ja.length()];

                // imagepath = new String[ja.length()];

                for(int i=0;i<ja.length();i++)
                {
                    jo=ja.getJSONObject(i);
                    pname[i]=jo.getString("productID");
                    quantity[i]=jo.getString("quantity");
                    price[i]=jo.getString("price");

                    //imagepath[i]=jo.getString("photo");
                }

                OrdersAdabter customLiseView=new OrdersAdabter(OrdersActivity.this, pname,price, quantity);
                listView.setAdapter(customLiseView);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                Toast.makeText(OrdersActivity.this, "No Orders Here", Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        protected String doInBackground(String... voids) {

            String result = "";

            String connstr = urladdress;

            try {
                URL url = new URL(connstr);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                OutputStream ops = http.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, StandardCharsets.UTF_8));
                String data = URLEncoder.encode("customerID", "UTF-8") + "=" + URLEncoder.encode(background.customerID, "UTF-8");

                writer.write(data);
                writer.flush();
                writer.close();
                ops.close();

                InputStream ips = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ips, StandardCharsets.ISO_8859_1));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
                ips.close();
                http.disconnect();
                return result;


            } catch (MalformedURLException e) {
                result = e.getMessage();
            } catch (IOException e) {
                result = e.getMessage();
            }
            return result;
        }
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
            pname = new String[ja.length()];
            price = new String[ja.length()];
            quantity = new String[ja.length()];

            // imagepath = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                pname[i]=jo.getString("productID");
                quantity[i]=jo.getString("quantity");
                price[i]=jo.getString("price");


                //imagepath[i]=jo.getString("photo");

            }



        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

}