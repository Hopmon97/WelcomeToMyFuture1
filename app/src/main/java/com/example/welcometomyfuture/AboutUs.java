package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {
    //initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view)
    {
        //open drawer
        MyNavDrawer.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view)
    {
        //close drawer
        MyNavDrawer.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view)
    {
        //redirect to home
        MyNavDrawer.redirectActivity(this, MainActivity.class);
    }
    public void ClickDashBoard(View view)
    {
        //Redirect activity to dashboard
        MyNavDrawer.redirectActivity(this,Dashboard.class);

    }
    public void ClickAboutUs(View view)
    {
        //Recreate activity
        recreate();

    }
    public void ClickLogout(View view)
    {
        //close app
        MyNavDrawer.Logout(this );
    }
    @Override
    protected  void onPause()
    {
        super.onPause();
        //Close drawer
        MyNavDrawer.closeDrawer(drawerLayout);
    }
}