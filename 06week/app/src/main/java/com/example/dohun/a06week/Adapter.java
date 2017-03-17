package com.example.dohun.a06week;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private ArrayList<Stu> StuList;
    private Context context;
    private ListView sList;
    private Button btn;
    private TextView text1;
    private TextView text2;
    int position;

    public Adapter(ArrayList<Stu> stuList, Context context) {
        this.StuList = stuList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return StuList.size();
    }

    @Override
    public Object getItem(int position) {
        return StuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    // 버튼을 누르면 토스트 메세지가 출력되는 메소드
    // 버튼을 눌렀을때 해당 아이템의 이름과 학번을 가져오는 메소드
    private void selectButton(Button btn1, int position) {
        btn1.setOnClickListener(new btnListener(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        sList = (ListView) itemView.findViewById(R.id.StudentView);
        btn = (Button) itemView.findViewById(R.id.btn);
        text1 = (TextView) itemView.findViewById(R.id.name);
        text2 = (TextView) itemView.findViewById(R.id.age);
        this.position = position;
        fillViews(sList, position);
        return itemView;
    }
    // 리스트 뷰에 아이템 목록을 띄우는 메소드
    private void fillViews(ListView sList, int position) {
        text1.setText(StuList.get(position).getStuname());
        text2.setText(StuList.get(position).getStuage());

        selectButton(btn, position);
    }


    private class btnListener implements View.OnClickListener {
        int position;
        public btnListener(int position) {
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(context, StuList.get(position).getStuname() + " / " + StuList.get(position).getStuage() , Toast.LENGTH_LONG).show();
        }

    }
}