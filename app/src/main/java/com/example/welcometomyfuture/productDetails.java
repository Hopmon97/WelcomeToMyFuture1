package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class productDetails extends AppCompatActivity {

    String productID;
    String price;

    TextView tvID;
    EditText etQuantity;
    Button btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        tvID=findViewById(R.id.tvID);
        btnCart=findViewById(R.id.btnAddtocart);
        //men xiaseis ta findviewbyid

        Bundle data = getIntent().getExtras();

        productID=data.getString("ID");

        tvID.setText(productID);



        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCart addCart = new AddCart(productDetails.this);
                addCart.execute();
            }
        });

    }



    public class AddCart extends AsyncTask<String,Void,String>
    {
        Context context;
        String result = "";

        public AddCart(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {

        }
        @Override
        protected void onPostExecute(String result) {

            System.out.println(result);

            try {
                if (result.equals("success")) {
                    Toast.makeText(context, "Product has been added to the cart sucesfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(context, "Error adding product to cart", Toast.LENGTH_LONG).show();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        @Override
        protected String doInBackground(String... voids) {
            String connstr = "http://" + MainActivity.ip + "/Android/add_to_cart.php";

            //UPDATE customer set customerName = '$customerName', customerSurname= '$customerSurname'.... WHERE customerID = '$customerID'
            try {
                URL url = new URL(connstr);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                OutputStream ops = http.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, StandardCharsets.UTF_8));
                String data = URLEncoder.encode("customerID", "UTF-8") + "=" + URLEncoder.encode(background.customerID, "UTF-8")+ "&&" +
                        URLEncoder.encode("productID", "UTF-8") + "=" + URLEncoder.encode(productID, "UTF-8") + "&&" +
                        URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8") + "&&" +
                        URLEncoder.encode("quantity", "UTF-8") + "=" + URLEncoder.encode(etQuantity.getText().toString(), "UTF-8");



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
}