package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;

import com.example.welcometomyfuture.MainActivity;
import com.example.welcometomyfuture.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductsActivity extends AppCompatActivity {
    String urladdress = "http://" + MainActivity.ip + "/Android/get_products.php";//rwta stelioooo

    String[] code;
    String[] productName;
    String[] productPrice;
    String[] productSeller;
    String[] productDescription;
    String[] image;


    ListView listView;
    BufferedInputStream is;
    String line = null;
    String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list_view );

        listView= findViewById(R.id.llview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();

        for(int i=0; i<productName.length; i++)
        {
            System.out.println("i+ " + i + " " + productName[i]);

        }
        ProductsListViewActivity customLiseView = new ProductsListViewActivity(this, code,productName, productPrice,productSeller,productDescription, image);
        listView.setAdapter(customLiseView);
    }

    private void collectData() {//connection
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
            code = new String[ja.length()];
            productName = new String[ja.length()];
            productPrice = new String[ja.length()];
            productSeller = new String[ja.length()];
            productDescription = new String[ja.length()];
            image = new String[ja.length()];






            for (int i = 0; i<ja.length(); i++)
            {
                jo = ja.getJSONObject(i);
                code[i] = jo.getString("eventID");
                productName[i] = jo.getString("title");
                productPrice[i] = jo.getString("productPrice");
                productSeller[i] = jo.getString("customerID");
                productDescription[i] = jo.getString("description");
                image[i] = jo.getString("productPicture");



            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void takeToCart(View view)
    {

    }
}

