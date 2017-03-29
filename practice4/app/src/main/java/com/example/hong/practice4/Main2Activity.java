package com.example.hong.practice4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }public void init(View v){
        if(v.getId()==R.id.button){
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);//현재 activity , 이동할 activity
            startActivity(intent);
        }else{
            Intent intent = new Intent(Main2Activity.this, calculator.class);//현재 activity , 이동할 activity
            startActivity(intent);
        }
    }
}
