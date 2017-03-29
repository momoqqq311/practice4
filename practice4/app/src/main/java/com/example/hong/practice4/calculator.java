package com.example.hong.practice4;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.tabcontent;

public class calculator extends AppCompatActivity {
    TabHost tabhost;
    EditText e1,e2,e3;
    TextView t1,t2;
    FrameLayout f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tabhost = (TabHost)findViewById(R.id.tabhost);
        e1 = (EditText)findViewById(R.id.height);
        e2 = (EditText)findViewById(R.id.weight);
        t1 = (TextView) findViewById(R.id.bmi_result);
        e3= (EditText)findViewById(R.id.num);
        t2 = (TextView)findViewById(R.id.change_result);
        f1 = (FrameLayout)findViewById(tabcontent);
        setTitle("각종 계산기");
        init();
    }
    void init() {
        tabhost.setup();
        tabhost.addTab(tabhost.newTabSpec("A").setContent(R.id.bmi_tap).setIndicator("BMI 계산기"));
        tabhost.addTab(tabhost.newTabSpec("B").setContent(R.id.area_tap).setIndicator("면적 계산기"));
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("A")) {
                    f1.setBackgroundColor(Color.argb(255, 175, 250, 237));
                }else{
                    f1.setBackgroundColor(Color.argb(255, 241, 160, 98));
                }
            }});
    }

    public void onClick(View v){

        switch(v.getId()){
            case R.id.bmi_button:
                String str1,str2;
                str1 = e1.getText().toString();
                str2 = e2.getText().toString();
                if(str1.equals("")){
                    Toast.makeText(getApplicationContext(), "키를 입력해주세요", Toast.LENGTH_SHORT).show();
                }else if(str2.equals("")){
                    Toast.makeText(getApplicationContext(), "몸무게를 입력해주세요", Toast.LENGTH_SHORT).show();
                }else{
                    bmi_calculator(str1,str2);
                }
                break;
            case R.id.change_meter:
                String str = e3.getText().toString();
                if(str.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요", Toast.LENGTH_SHORT).show();
                }else{
                    change_meter(str);
                }
                break;
            case R.id.change_space:
                String str0 = e3.getText().toString();
                if(str0.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요", Toast.LENGTH_SHORT).show();
                }else{
                    change_space(str0);
                }
                break;
        }

    }
    void bmi_calculator(String str1, String str2){
        float height, weight;
        height = Integer.parseInt(str1);
        height = (float) (height * 0.01);
        weight = Integer.parseInt(str2);
        float bmi;
        bmi = weight / (height*height);
        t1.setTextColor(Color.RED);
        if(bmi>=25.0){
            t1.setText("비만입니다.");
        }else if(bmi>=23.0){
            t1.setText("과체중입니다.");
        }else if(bmi>=18.5){
            t1.setText("정상입니다.");
        }else{
            t1.setText("체중 부족입니다.");
        }
    }
    void change_meter(String str){
        int num;
        num = Integer.parseInt(str);
        float result;
        result = (float) ((float)num * 3.305785);
        t2.setText(result+"제곱미터");
    }
    void change_space(String str){
        int num;
        num = Integer.parseInt(str);
        float result;
        result = (float) ((float)num / 3.305785);
        t2.setText((int)result+"평");
    }
}
