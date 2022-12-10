package com.example.welcometomyfuture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.text.BreakIterator;
import com.example.welcometomyfuture.ListViewAdapter;
import com.example.welcometomyfuture.R;
import com.squareup.picasso.Picasso;

public class ProductsListViewActivity extends ArrayAdapter<String> {

    private final Activity context;


    private final String[] pID;
    private final String[] pName;
    private final String[] pPrice;
    private final String[] pSeller;
    private final String[] pDescription;
    private final String[] image;
    private final String[] pquantity;


    Bitmap bitmap;
    ViewHolder viewHolder;
    public ProductsListViewActivity(Activity context, String[] pID, String[] pName, String[] pPrice, String[] pSeller, String[] pDescription, String[] image,String[]pquantity) {
        super(context, R.layout.activity_products, pID);
        this.context = context;
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pSeller = pSeller;
        this.pDescription = pDescription;
        this.image = image;
        this.pquantity = pquantity;

    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.activity_products, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.tvIDD.setText(pID[position]);
        viewHolder.tvName.setText(pName[position]);
        viewHolder.tvPrice.setText(pPrice[position]);
        viewHolder.tvSeller.setText(pSeller[position]);
        viewHolder.tvpDescription.setText(pDescription[position]);
        System.out.println(image[position]);
        viewHolder.tvQuantity.setText(pquantity[position]);

        Picasso
                .with(context)
                .load(image[position])
                .into(viewHolder.ivw);



        return r;
    }


    class ViewHolder {
        TextView tvIDD, tvName, tvPrice, tvSeller, tvpDescription,tvQuantity;

         ImageView ivw;

        ViewHolder(View v) {
            tvIDD = v.findViewById(R.id.tvPID);
            tvName = v.findViewById(R.id.tvPName);
            tvPrice = v.findViewById(R.id.tvPrice);
            tvSeller = v.findViewById(R.id.tvSeller);
            tvpDescription = v.findViewById(R.id.tvDescription);
            ivw=(ImageView)v.findViewById(R.id.ivw);
            tvQuantity = v.findViewById(R.id.tvQuantity);
        }
    }



}




