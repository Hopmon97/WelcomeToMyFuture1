package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

public class productsRegister extends AppCompatActivity {
    private EditText etProductName,etSeller,etPrice,etDesc;
    private String title,sellerID,description,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_register);
        etProductName = findViewById(R.id.etProductsName);
        etSeller = findViewById(R.id.etSeller);
        etPrice = findViewById(R.id.etPrice);
        etDesc = findViewById(R.id.etDesc);





    }
    public void saveProduct(View view)
    {
        title=etProductName.getText().toString().trim();
        sellerID=etSeller.getText().toString().trim();
        description=etDesc.getText().toString().trim();
        price=etPrice.getText().toString().trim();

        RegisterProduct registerUser = new RegisterProduct(this);
        registerUser.execute(title,sellerID,description,price);
    }
    public class RegisterProduct extends AsyncTask<String,Void,String> {
        Context context;
        AlertDialog alertDialog;

        RegisterProduct(Context ctx) {
            context = ctx;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                String title = params[0];
                String sellerID = params[1];
                String description = params[2];
                String price = params[3];

                /*???? */
                URL url = new URL("http://" + MainActivity.ip + "/Android/registerProduct.php");

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

                String post_data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8") + "&"

                        + URLEncoder.encode("sellerID", "UTF-8") + "=" + URLEncoder.encode(sellerID, "UTF-8") + "&"

                        + URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(description, "UTF-8") + "&"

                        + URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8");


                //URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"....


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (
            IOException e) {
                e.printStackTrace();
            }

            return null;
    }@Override
        protected void onPreExecute() {
        }

        //on post execution of the worker, we print the message that we got from the php script
        @Override
        protected void onPostExecute(String result)
        {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Register Status:");
            alertDialog.setMessage(result);
            alertDialog.show();
        }

        }
    }