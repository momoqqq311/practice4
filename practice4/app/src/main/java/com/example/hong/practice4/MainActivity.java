package com.example.hong.practice4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout L1;
    ImageView image;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L1 = (LinearLayout)findViewById(R.id.layout);
        image = (ImageView)findViewById(R.id.imageView);
        t1 = (TextView)findViewById(R.id.text);
        setTitle("메뉴를 눌러보세요");
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {//menu과 함께 구동
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu,menu);
             return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.red) {
            L1.setBackgroundColor(Color.RED);
        }else if(item.getItemId()==R.id.blue){
            L1.setBackgroundColor(Color.BLUE);
        }else if(item.getItemId()==R.id.yello){
            L1.setBackgroundColor(Color.YELLOW);
        }else if(item.getItemId()==R.id.rotate){
            if(image.getVisibility()==image.INVISIBLE){
                Toast.makeText(getApplicationContext(), "이미지가 없습니다", Toast.LENGTH_SHORT).show();
            }else{
                image.setRotation(30);
            }
        }else if(item.getItemId()==R.id.titleshow){
            if(item.isChecked()){
                t1.setVisibility(View.INVISIBLE);
                item.setChecked(false);
            }else{
                if(image.getVisibility()==image.VISIBLE){
                    t1.setVisibility(View.VISIBLE);
                    item.setChecked(true);
                }else{
                    Toast.makeText(getApplicationContext(), "이미지가 없습니다", Toast.LENGTH_SHORT).show();
                }
            }
        }else if(item.getItemId()==R.id.doubleshow){
            image.setScaleX(2*image.getScaleX());
            image.setScaleY(2*image.getScaleY());
        }else if(item.getItemId()==R.id.chicken){
            item.setChecked(true);
            image.setImageResource(R.drawable.chicken);
            image.setVisibility(View.VISIBLE);
            t1.setText("치킨");
        }else if(item.getItemId()==R.id.spagetti){
            item.setChecked(true);
            t1.setText("스파게티");
            image.setImageResource(R.drawable.spagetti);
            image.setVisibility(View.VISIBLE);
        }else{

        }
        return super.onOptionsItemSelected(item);
    }
}
