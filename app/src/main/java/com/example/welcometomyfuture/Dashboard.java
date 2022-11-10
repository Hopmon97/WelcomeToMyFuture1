package com.example.welcometomyfuture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    //initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
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
        //Recreate activity
        recreate();
    }
    public void ClickAboutUs(View view)
    {
        //Redirect activity to about us
        MyNavDrawer.redirectActivity(this,AboutUs.class);
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
