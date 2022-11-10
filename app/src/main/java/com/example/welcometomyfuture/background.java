package com.example.welcometomyfuture;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

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
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        dialog.show();
        Intent intent = new Intent(context, ListActivity.class);
        context.startActivity(intent);

    //sinexizeis to :P endxrw ta asdasd sou
        /*
        encryption:
        apla px anti $password
        enna valeis md5($password)
        je eshis encrypted password.
        de
        to idio prama ena kameis stin php,
        otan kamnei register enna kataxwris encrypted to password,
        otan kamnei login enna xanakamneis encrypt me md5,
        je na sigkrineis me jino tis vasis noice
        en ekatalava pws enna t kamw alla pistefkw enan t evrw
        en eukolo
        enna t evries
        an den t evreis laleis m
        . btw gchia to
        btw gia to forgot password enna theleis na stelneis email
        theleis phpmailer, enna s to dixw p na ertei i wra
        kalos kalos
        kt teleuteo
        pe m oti en eshis pieromes mesa, exw paraggelies, pieromes en kserw akoma
        ok, an tha valeis exw sou etoimo kodika tis paypal enna valw XD
        ahahahhaah kaula
        ate efiaaa mlm fb
         */
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
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"Utf-8"));
            String data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+"&&" +
                    URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader= new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
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
