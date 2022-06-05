package com.example.exp10navi;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        if(item.getItemId()==R.id.expe8){
//            Toast.makeText(this,"Exp8",Toast.LENGTH_SHORT).show();
//            Intent i1=new Intent(this,exp8.class);
//            startActivity(i1);
//        }
        switch (item.getItemId()){
            case R.id.exp2:
                Toast.makeText(this,"Exp2",Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(this,exp2.class);
                startActivity(i1);
                break;
            case R.id.exp3:
                Toast.makeText(this,"Exp3",Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(this,exp3.class);
                startActivity(i2);
                break;
            case R.id.exp4:
                Toast.makeText(this,"Exp4",Toast.LENGTH_SHORT).show();
                Intent i4=new Intent(this,exp4.class);
                startActivity(i4);
                break;
            case R.id.exp5:
                Toast.makeText(this,"Exp5",Toast.LENGTH_SHORT).show();
                Intent i5=new Intent(this,exp5.class);
                startActivity(i5);
                break;
            case R.id.exp6:
                Toast.makeText(this,"Exp6",Toast.LENGTH_SHORT).show();
                Intent i6=new Intent(this,exp6.class);
                startActivity(i6);
                break;
            case R.id.exp7:
                Toast.makeText(this,"Exp7",Toast.LENGTH_SHORT).show();
                Intent i7=new Intent(this,exp7.class);
                startActivity(i7);
                break;
            case R.id.expe8:
                Toast.makeText(this,"Exp8",Toast.LENGTH_SHORT).show();
                Intent i8=new Intent(this,exp8.class);
                startActivity(i8);
                break;
            case R.id.exp9:
                Toast.makeText(this,"Exp9",Toast.LENGTH_SHORT).show();
                Intent i9=new Intent(this,exp9sq.class);
                startActivity(i9);
                break;
        }


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
//        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
