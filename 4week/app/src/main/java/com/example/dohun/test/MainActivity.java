package com.example.dohun.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private EditText editName,editAge;
    private Intent sIntent;
    private static final int RequestCode = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =  (Button)findViewById(R.id.btn);
        initView();
    }

    private void initView() {
        sIntent = new Intent(MainActivity.this,SecondActivity.class);
        editName = (EditText)findViewById(R.id.editName);
        editAge = (EditText)findViewById(R.id.editAge);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sIntent = new Intent(MainActivity.this,SecondActivity.class);
                sIntent.putExtra("name",editName.getText().toString());
                sIntent.putExtra("age",editAge.getText().toString());
                sIntent.putExtra("main", 123);
                startActivityForResult(sIntent,RequestCode);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1001:
                if(resultCode == RESULT_OK){
                    Toast.makeText(MainActivity.this,data.getStringExtra("send"),Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //case R.id.btn:
            //    Toast.makeText(MainActivity.this,"눌렀다",Toast.LENGTH_LONG).show();
            //    break;
        }
    }

    @Override
    protected void onRestart() {
        Log.i("name", "다시 시작했습니다");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i("name", "시작했습니다");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.i("name", "종료되었습니다");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i("name", "정지되었습니다");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.i("name", "일시정지 되었습니다");
        super.onPause();
    }


}
