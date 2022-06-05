package com.example.exp10navi;

import static android.Manifest.permission.CALL_PHONE;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class exp3 extends AppCompatActivity {
    EditText user,course,branch,year;
    EditText email;
    EditText number;
    String num;
    Button login,dial,call,camera,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp3);
        user=findViewById(R.id.user);
        email=findViewById(R.id.email);
        number=findViewById(R.id.num);
        course=findViewById(R.id.course);
        branch=findViewById(R.id.branch);
        year=findViewById(R.id.year);

        login=findViewById(R.id.login);
        dial=findViewById(R.id.dial);
        call = findViewById(R.id.caller);
        camera=findViewById(R.id.camera);
        mail=findViewById(R.id.mail);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exp3.this,mail.class);
                startActivity(intent);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent3=new Intent(exp3.this,camera.class);
                startActivity(Intent3);
            }
        });

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = number.getText().toString().trim();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode(num)));
                startActivity(i);
            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                num=number.getText().toString().trim();
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+Uri.encode(num)));
                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i);
                }
                else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // if(user.getText().toString().equals("Name")&&pwd.getText().toString().equals("Name")){
                //Intent intent=new Intent(getApplicationContext(),sec.class);
                Intent intent=new Intent(exp3.this,regform.class);
                String user1=user.getText().toString();
                String pass1=email.getText().toString();
                String c1=course.getText().toString();
                String b1=branch.getText().toString();
                String y1=year.getText().toString();
                String ph=number.getText().toString();
                intent.putExtra("user",user1);
                intent.putExtra("email",pass1);
                intent.putExtra("number",ph);
                intent.putExtra("course",c1);
                intent.putExtra("branch",b1);
                intent.putExtra("year",y1);


                    /*int a[]={2,5,6,7,8};
                    intent.putExtra("arrays",a);*/
                startActivity(intent);
                //}
//                else{
//                    Toast.makeText(getApplicationContext(),"InvalidLogin",Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}