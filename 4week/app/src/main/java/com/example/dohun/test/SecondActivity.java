package com.example.dohun.test;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Intent gIntent;
    private Button btn1;
    private Intent bIntent;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        gIntent = getIntent();
        Toast.makeText(SecondActivity.this,gIntent.getStringExtra("name")
                + "/" + gIntent.getStringExtra("age"), Toast.LENGTH_LONG).show();

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                FrameLayout frame = (FrameLayout)findViewById(R.id.frame1);
                view = inflater.inflate(R.layout.image,null,false);
                frame.addView(view);
            }
        });
    }

    @Override
    public void onBackPressed() {
        bIntent = new Intent(SecondActivity.this,MainActivity.class);
        bIntent.putExtra("send","잘 받았습니다");
        setResult(RESULT_OK,bIntent);
        super.onBackPressed();
    }
}
