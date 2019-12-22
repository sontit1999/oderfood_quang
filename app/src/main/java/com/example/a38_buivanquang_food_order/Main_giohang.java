package com.example.a38_buivanquang_food_order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main_giohang extends AppCompatActivity implements Icon {

    ImageView img;
    ArrayList<Contact> contacts;
    double tongtien=0;
    TextView tvtongtien;
    AdapterCart adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_giohang);
        Intent intent = getIntent();
        contacts = (ArrayList<Contact>) intent.getSerializableExtra("contact");
        anhxa();
        initRecyclervier();
        totalPrice();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initRecyclervier() {

        Iterator itr = contacts.iterator();
        while (itr.hasNext())
        {
            Contact x = (Contact) itr.next();
            if (x.getCount() == 0)
                itr.remove();
        }
        adapter = new AdapterCart(this,contacts);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void anhxa() {
        img=findViewById(R.id.imgview);
        tvtongtien=findViewById(R.id.tvtong);
        recyclerView=findViewById(R.id.recyclergiohang);
    }

    @Override
    public void onClickName(Contact contact) {

    }

    @Override
    public void onClickNumber(int a) {

    }
    public void totalPrice(){
        float tongtien = 0;
        for(Contact i : contacts){
            tongtien += i.getCount() * i.getCost() ;
        }
        tvtongtien.setText(tongtien + "$");
    }
}
