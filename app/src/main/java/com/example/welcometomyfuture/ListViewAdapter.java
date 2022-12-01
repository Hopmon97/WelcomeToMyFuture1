package com.example.welcometomyfuture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.BreakIterator;

public class ListViewAdapter extends ArrayAdapter<String> {

    private final Activity context;

    private final String[] customer;
    private final String[] name;
    private final String[] surname;
    private final String[] email;
    private final String[] address;
    private final String[] city;
    private final String[] country;
    private final String[] postalcode;
    private final String[] phone;
    private final String[] type;

    Bitmap bitmap;
    public ListViewAdapter(Activity context, String[] customer, String[] name,String[]surname, String[]email, String[]address, String[]city, String[]country, String[]postalcode, String[]phone, String[]type)
    {
        super(context, R.layout.layout,name);
        this.context=context;
        this.customer=customer;
        this.name=name;
        this.surname = surname;
        this.email=email;
        this.address=address;
        this.city=city;
        this.country=country;
        this.postalcode=postalcode;
        this.phone=phone;
        this.type=type;
    }
    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder)r.getTag();
        }
        viewHolder.tvIDD.setText(customer[position]);
        viewHolder.tvName.setText(name[position]);
        viewHolder.tvSurname.setText(surname[position]);
        viewHolder.tvEmail.setText(email[position]);
        viewHolder.tvAddress.setText(address[position]);
        viewHolder.tvCity.setText(city[position]);
        viewHolder.tvCountry.setText(country[position]);
        viewHolder.tvPostalcode.setText(postalcode[position]);
        viewHolder.tvPhone.setText(phone[position]);




        if(type[position].equals("0"))
        {
            viewHolder.tvType.setText("Admin");
        }
        else if(type[position].equals("1"))
        {
            viewHolder.tvType.setText("Gewrgos");
        }
        else if(type[position].equals("2"))
        {
            viewHolder.tvType.setText("Geoponos");
        }else if(type[position].equals("3"))
        {
            viewHolder.tvType.setText("Promitheftis");
        }




        /*Picasso
                .with(context)
                .load(imagepath[position])
                .into(viewHolder.ivw);
        */

        return r;
    }




    class  ViewHolder
    {
        public BreakIterator tvPrice;
        TextView tvIDD, tvName, tvSurname, tvEmail, tvAddress, tvCity, tvCountry, tvPostalcode, tvPhone, tvType;


       // ImageView ivw;

        ViewHolder(View v)
        {
            tvIDD= v.findViewById(R.id.tvPID);
            tvName= v.findViewById(R.id.tvPName);
            tvSurname= v.findViewById(R.id.tvPrice);
            tvEmail= v.findViewById(R.id.tvSeller);
            tvAddress= v.findViewById(R.id.tvDescription);
            tvCity= v.findViewById(R.id.tvCity);
            tvCountry= v.findViewById(R.id.tvCountry);
            tvPostalcode= v.findViewById(R.id.tvPostalcode);
            tvPhone= v.findViewById(R.id.tvPhone);
            tvType= v.findViewById(R.id.tvType);

            // ivw=(ImageView)v.findViewById(R.id.iv);
        }
    }


}

