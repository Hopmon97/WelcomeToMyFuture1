/*package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
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
    String[] productName;
    String[] productDescription;
    String[] productPicture;
    String[] productPrice;
    String[] code;

    ListView listView;
    BufferedInputStream is;
    String line = null;
    String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        ProductsListViewActivity customLiseView = new ProductsListViewActivity(this, productName, productDescription, productPicture, productPrice, code);
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
            productName = new String[ja.length()];
            productDescription = new String[ja.length()];
            productPicture = new String[ja.length()];
            productPrice = new String[ja.length()];
            code = new String[ja.length()];


             productPicture = new String[ja.length()];

            for (int i = 0; i <= ja.length(); i++) {
                jo = ja.getJSONObject(i);
                productName[i] = jo.getString("productName");
                productDescription[i] = jo.getString("productDescription");
                productPicture[i] = jo.getString("productPicture");
                productPrice[i] = jo.getString("productPrice");
                code[i] = jo.getString("code");


                productPicture[i]=jo.getString("photo");

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
 */
