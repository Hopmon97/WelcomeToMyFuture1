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

public class ListViewAdapter extends ArrayAdapter<String> {

    private Activity context;

    private String[] customer;
    private String[] name;
    private String[] surname;
    private String[] email;
    private String[] address;
    private String[] city;
    private String[] country;
    private String[] postalcode;
    private String[] phone;
    private String[] type;

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
        }else if(type[position].equals("0"))
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
        TextView tvIDD, tvName, tvSurname, tvEmail, tvAddress, tvCity, tvCountry, tvPostalcode, tvPhone, tvType;


       // ImageView ivw;

        ViewHolder(View v)
        {
            tvIDD=(TextView)v.findViewById(R.id.tvIDD);
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

