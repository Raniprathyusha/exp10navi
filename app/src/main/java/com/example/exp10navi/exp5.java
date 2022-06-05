package com.example.exp10navi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class exp5 extends AppCompatActivity {
    EditText var1;
    RadioButton r1,r2;
    CheckBox c1,c2;
    Button but;
    AlertDialog.Builder builder;
    AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp5);
        var1 = findViewById(R.id.name2);
        r1 = findViewById(R.id.male);
        r2 = findViewById(R.id.female);
        c1 = findViewById(R.id.english);
        but = findViewById(R.id.but);
        c2 = findViewById(R.id.telugu);
        but = findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meth();
            }
        });


    }

    private void meth() {
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder
                .setCancelable(false)
                .setView(inflater.inflate(R.layout.activity_demo, null))
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText var2 = alert.findViewById(R.id.name2);
                        var1.setText(var2.getText().toString());
                        RadioButton male, female;
                        male = alert.findViewById(R.id.male);
                        female = alert.findViewById(R.id.female);
                        CheckBox telugu, english;
                        telugu = alert.findViewById(R.id.telugu);
                        english = alert.findViewById(R.id.english);
                        if (female.isSelected())
                            r1.setChecked(true);
                        else
                            r2.setChecked(true);
                        if (telugu.isChecked())
                            c2.setChecked(true);
                        if (english.isChecked())
                            c1.setChecked(true);
                    }
                });
        alert = builder.create();
        alert.show();


    }
}
