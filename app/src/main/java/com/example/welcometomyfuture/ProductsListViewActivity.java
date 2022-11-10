/*package com.example.welcometomyfuture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welcometomyfuture.ListViewAdapter;
import com.example.welcometomyfuture.R;
import com.squareup.picasso.Picasso;

public class ProductsListViewActivity extends ArrayAdapter<String> {
    private Activity context;

    Private String[]productName;
    Private String[] productDescription;
    Private String[] productPicture;
    Private String[] productPrice;
    Private String[] code;

    Bitmap bitmap;
    public ProductsListViewActivity(Activity context, String[] productName,String[]productDescription, String[]productPicture, String[]productPrice, String[]code)
    {
        super(context, R.layout.products_list_layout.product);
        this.context=context;
        this.productName=productName;
        this.productDescription = productDescription;
        this.productPicture=productPicture;
        this.productPrice=productPrice;
        this.code=code;

    }
    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View r=convertView;
        ListViewAdapter.ViewHolder viewHolder=null;
        if(r==null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.products_list_layout, null, true);
            viewHolder = new ProductsListViewActivity().ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ListViewAdapter.ViewHolder)r.getTag();
        }
        viewHolder.tvProduct.setText(productName[position]);
        viewHolder.tvDescription.setText(productDiscription[position]);
        viewHolder.tvPicture.setText(productPicture[position]);
        viewHolder.tvPrice.setText(productPrice[position]);
        viewHolder.tvCode.setText(code[position]);




        /*Picasso
                .with(context)
                .load(productPicture[position])
                .into(viewHolder.ivw);
        */
/*
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welcometomyfuture.R;return r;
    }
    class  ViewHolder
    {
        TextView tvName, tvSurname, tvEmail, tvAddress, tvCity, tvCountry, tvPostalcode, tvPhone, tvType;

         ImageView ivw;

        ViewHolder(View v)
        {
            tvName=(TextView)v.findViewById(R.id.tvName);
            tvSurname=(TextView)v.findViewById(R.id.tvSurname);
            tvEmail=(TextView)v.findViewById(R.id.tvEmail);
            tvAddress=(TextView)v.findViewById(R.id.tvAddress);
            tvCity=(TextView)v.findViewById(R.id.tvCity);
            tvCountry=(TextView)v.findViewById(R.id.tvCountry);
            tvPostalcode=(TextView)v.findViewById(R.id.tvPostalcode);
            tvPhone=(TextView)v.findViewById(R.id.tvPhone);
            tvType=(TextView)v.findViewById(R.id.tvType);

            // ivw=(ImageView)v.findViewById(R.id.iv);
        }
    }


}

*/