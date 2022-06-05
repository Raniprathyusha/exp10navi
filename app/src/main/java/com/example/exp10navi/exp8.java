package com.example.exp10navi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class exp8 extends AppCompatActivity {
        EditText pid,pname,items,type,vendor;
        Button insert,delete,update,retrive;
        //retrive texts
        TextView vend,id,name,ritem,typ;
        FirebaseDatabase firebaseDatabase; //Instance
        DatabaseReference databaseReference;//Ref
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.exp8);
            //insert
            vendor=findViewById(R.id.vendor);
            pid=findViewById(R.id.pid);
            pname=findViewById(R.id.pname);
            items=findViewById(R.id.item);
            type=findViewById(R.id.type);
            //buttons-4
            insert=findViewById(R.id.button);
            delete=findViewById(R.id.delete);
            update=findViewById(R.id.update);
            retrive=findViewById(R.id.retrive);
            //retrieve
            id=findViewById(R.id.id);
            vend=findViewById(R.id.vend);
            name=findViewById(R.id.name);
            ritem=findViewById(R.id.ritem);
            typ=findViewById(R.id.typ);

            firebaseDatabase=FirebaseDatabase.getInstance();

            insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    databaseReference=firebaseDatabase.getReference( "database").child(pname.getText().toString());
                    users use=new users(vendor.getText().toString(),pid.getText().toString(),pname.getText().toString(),items.getText().toString(),type.getText().toString());
                    databaseReference.setValue(use);
                    Toast.makeText(exp8.this,"Inserted Successfully",Toast.LENGTH_SHORT).show();

                }
            });

            update.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    databaseReference=firebaseDatabase.getReference("database");
                    HashMap<String,Object> hm=new HashMap<>();
                    hm.put("vendor",vendor.getText().toString());
                    hm.put("pid",pid.getText().toString());
                    hm.put("pname",pname.getText().toString());
                    hm.put("items",items.getText().toString());
                    hm.put("type",type.getText().toString());
                    databaseReference.child(pname.getText().toString()).updateChildren(hm);
                    Toast.makeText(exp8.this,"Updated Data Successfully",Toast.LENGTH_SHORT).show();
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    databaseReference=firebaseDatabase.getReference("database");
                    databaseReference.child(pname.getText().toString()).removeValue();
                    Toast.makeText(exp8.this,"Deleted "+pname.getText().toString()+" data successfully",Toast.LENGTH_SHORT).show();

                }
            });

            retrive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    databaseReference=firebaseDatabase.getReference("database");
                    databaseReference.child(pname.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {

                            if(task.isSuccessful()){
                                DataSnapshot ds=task.getResult();
                                String vndor=String.valueOf(ds.child("vendor").getValue());
                                String pd=String.valueOf(ds.child("pid").getValue());
                                String pame=String.valueOf(ds.child("pname").getValue());
                                String iems=String.valueOf(ds.child("items").getValue());
                                String tpe=String.valueOf(ds.child("type").getValue());
                                vend.setText(vndor);
                                id.setText(pd);
                                name.setText(pame);
                                ritem.setText(iems);
                                typ.setText(tpe);
                                Toast.makeText(exp8.this,"User exists and Retrieved Successfully",Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Toast.makeText(exp8.this,"User does not exists",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            });
        }}


