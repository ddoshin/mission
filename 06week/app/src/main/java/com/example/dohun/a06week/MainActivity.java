package com.example.dohun.a06week;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Stu> stuList;
    private Adapter stuAdapter;
    private ListView StudentView;
    private Button btn;
    private TextView name;
    private TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =(Button)findViewById(R.id.btn);
        name = (TextView)findViewById(R.id.name);
        age = (TextView)findViewById(R.id.age);
        StudentView = (ListView) findViewById(R.id.StudentView);

        stuList = new ArrayList<>();
        stuList.add(new Stu("황도훈","13학번"));
        stuList.add(new Stu("정인기","  학번"));
        stuList.add(new Stu("이재은","13학번"));
        stuList.add(new Stu("최상아","14학번"));
        stuList.add(new Stu("김소현","15학번"));

        stuAdapter = new Adapter(stuList, MainActivity.this);

        StudentView.setAdapter(stuAdapter);

    }
}