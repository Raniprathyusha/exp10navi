package com.example.exp10navi;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class exp4 extends AppCompatActivity implements blankfrag.Communication{
    TextView first,last;
    Button closebutton;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp4);
        String list[]=getResources().getStringArray(R.array.List);
        first=findViewById(R.id.first_tv);
        last=findViewById(R.id.last_tv);
        closebutton=findViewById(R.id.button);
        builder=new AlertDialog.Builder(this);
        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                builder.setMessage("Do you want to close this application")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                Toast.makeText(getApplicationContext(),"You choose yes action for alert box",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getApplicationContext(),"You choose no action for alertbox",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert =builder.create();
                alert.setTitle("Dialog Box");
                alert.show();
            }
        });

    }

    @Override
    public void sendData(Bundle bundle) {
        first.setText(bundle.getString("first"));
        last.setText(bundle.getString("last"));
    }
}