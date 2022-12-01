package com.example.welcometomyfuture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
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



    Bitmap bitmap;

    public ProductsListViewActivity(Activity context, String[] pID, String[] pName, String[] pPrice, String[] pSeller, String[] pDescription, String[] image) {
        super(context, R.layout.activity_products, pID);
        this.context = context;
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pSeller = pSeller;
        this.pDescription = pDescription;
        this.image = image;

    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
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

        Picasso
                .with(context)
                .load(image[position])
                .into(viewHolder.ivw);

        return r;
    }


    class ViewHolder {
        TextView tvIDD, tvName, tvPrice, tvSeller, tvpDescription;

         ImageView ivw;

        ViewHolder(View v) {
            tvIDD = v.findViewById(R.id.tvPID);
            tvName = v.findViewById(R.id.tvPName);
            tvPrice = v.findViewById(R.id.tvPrice);
            tvSeller = v.findViewById(R.id.tvSeller);
            tvpDescription = v.findViewById(R.id.tvDescription);
            ivw=(ImageView)v.findViewById(R.id.ivw);
        }
    }
    public void takeToCart(View view)
    {

    }
}




