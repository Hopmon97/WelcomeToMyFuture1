package com.example.welcometomyfuture;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONObject;

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

public class background extends AsyncTask<String,Void,String> {

    AlertDialog dialog;
    Context context;
    public background(Context context)
    {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {

System.out.println(result);

        if(result.equals("loginfailed"))
        {
            dialog.setMessage(result);
            dialog.show();
        }
        else
        {
            try{
                JSONObject jo = new JSONObject(result);
                String type=jo.getString("type");

               if (type.equals("0"))
                {

                    Intent intent = new Intent(context, ListActivity.class);
                    context.startActivity(intent);

                }
                else if (type.equals("1"))
                {

                    Intent intent = new Intent(context, Geoponos.class);
                    context.startActivity(intent);

                }
                else if (type.equals("2"))
                {

                    Intent intent = new Intent(context, Product.class);
                    context.startActivity(intent);

                }
                else if (type.equals("3"))
                {

                    Intent intent = new Intent(context,SellerActivity.class);
                    context.startActivity(intent);

                }


            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        /*String gettype ="http://"+MainActivity.ip+"/Android/get_type.php";
        String[] type;



        BufferedInputStream is=null;
        String line= null;
        String result = null;

        try
        {
            URL url = new URL(gettype);
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

            System.out.println(ja);

            type = new String[ja.length()];

            // imagepath = new String[ja.length()];

            for(int i=0;i<=ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                type[i]=jo.getString("type");


                //imagepath[i]=jo.getString("photo");



                //Intent intent = new Intent(context, ListActivity.class);


            }



        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }*/

    }

    @Override
    protected String doInBackground(String... voids){
        String result = "";
        String user = voids[0];
        String pass = voids[1];


        String connstr ="http://"+MainActivity.ip+"/Android/login.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http= (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+"&&" +
                    URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader= new BufferedReader(new InputStreamReader(ips, StandardCharsets.ISO_8859_1));
            String line= "";
            while((line=reader.readLine())!=null)
            {
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;


        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e){
            result= e.getMessage();
        }


        return result;
    }
}


