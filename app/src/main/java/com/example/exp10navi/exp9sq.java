package com.example.exp10navi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class exp9sq extends AppCompatActivity {
    EditText id,vname,pname,type;
    Button adddet,upd,del,sea;
    dbhandler dbhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp9sq);
        id=findViewById(R.id.id);
        vname=findViewById(R.id.venname);
        pname=findViewById(R.id.prname);
        type=findViewById(R.id.type);
        adddet=findViewById(R.id.button);
        dbhandler=new dbhandler(exp9sq.this);
        adddet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid=id.getText().toString();
                String svname=vname.getText().toString();
                String spname=pname.getText().toString();
                String stype=type.getText().toString();
                if(sid.isEmpty() && svname.isEmpty() && spname.isEmpty() &&stype.isEmpty()){
                    Toast.makeText(exp9sq.this,"Please enter all details",Toast.LENGTH_SHORT).show();
                    return;
                }
                dbhandler.addnewdetails(sid,svname,spname,stype);
                Toast.makeText(exp9sq.this,"Course has been added",Toast.LENGTH_SHORT).show();
                id.setText("");
                vname.setText("");
                pname.setText("");
                type.setText("");
            }
        });
        upd=findViewById(R.id.upd);
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid=id.getText().toString();
                String svname=vname.getText().toString();
                String spname=pname.getText().toString();
                String stype=type.getText().toString();
                Boolean checkupdate=dbhandler.updatedata(sid,svname,spname,stype);
                if(checkupdate==true)
                {
                    Toast.makeText(getApplicationContext(),"Details Updated",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"OOPS!! There is a problem in updating",Toast.LENGTH_LONG).show();
                }
            }
        });
        sea=findViewById(R.id.sea);
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid=id.getText().toString();
                String svname=vname.getText().toString();
                String spname=pname.getText().toString();
                String stype=type.getText().toString();
                Boolean checkdelete=dbhandler.searchdata(sid,svname,spname,stype);
                if(checkdelete==true)
                {
                    Toast.makeText(getApplicationContext(),"Entry exists results found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Could not find that details",Toast.LENGTH_LONG).show();

                }
            }
        });
        del=findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid=id.getText().toString();
                Boolean checkdelete=dbhandler.delete(sid);
                if(checkdelete==true)
                {
                    Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data is not deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}