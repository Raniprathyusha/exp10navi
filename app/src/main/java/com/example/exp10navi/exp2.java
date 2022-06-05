package com.example.exp10navi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class exp2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp2);
        Log.d("Lifecycle","Oncreate invoked");
        Toast.makeText(this, "Oncreate invoked", Toast.LENGTH_SHORT).show();
    }
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
        Toast.makeText(this, "OnStart invoked", Toast.LENGTH_SHORT).show();

    }
    protected void onResume(){
        super.onResume();
        Log.d("Lifecycle","onResume invoked");
        Toast.makeText(this, "OnResume invoked", Toast.LENGTH_SHORT).show();

    }
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
        Toast.makeText(this, "OnPause invoked", Toast.LENGTH_SHORT).show();

    }
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
        Toast.makeText(this, "OnStop invoked", Toast.LENGTH_SHORT).show();

    }
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
        Toast.makeText(this, "OnRestart invoked", Toast.LENGTH_SHORT).show();

    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
        Toast.makeText(this, "OnDestroy invoked", Toast.LENGTH_SHORT).show();

    }
}


