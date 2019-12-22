package com.example.a38_buivanquang_food_order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main_order extends AppCompatActivity implements Icon{
    ViewFlipper viewFlipper;
    int[] arrayHinh={R.drawable.anh1,R.drawable.anh2,R.drawable.anh3,R.drawable.anh4,R.drawable.anh5};
    FrameLayout cart;
    RecyclerView recyclerView;
    ArrayList<Contact> contacts;
    AdapterContact adapterContact;

    Button btnorder;
    TextView tvprice;
    TextView tvname;
    TextView tvcount;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order);
        Log.d("test","on creat");
        anhxa();
        totalPrice();
        initViewlipper();
        initRecyclerview();

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_order.this,Main_giohang.class);
                intent.putExtra("contact", (Serializable) contacts);
                startActivity(intent);
            }
        });
        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test",contacts.get(0).getName() + " - " + contacts.get(0).getCount());
                Toast.makeText(getBaseContext(),"Thank you! your order sent to restaurant",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initRecyclerview() {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false);
        adapterContact = new AdapterContact(contacts,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterContact);

    }

    private void initViewlipper() {
        for(int i=0;i<arrayHinh.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(arrayHinh[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }

    private void anhxa() {
        cart = (FrameLayout) findViewById(R.id.cart) ;
        linearLayout=findViewById(R.id.linearlayout);
        recyclerView=findViewById(R.id.rvlist);
        btnorder=findViewById(R.id.btnorder);
        tvprice=findViewById(R.id.tvprice);
        tvname=findViewById(R.id.tvname);
        tvcount=findViewById(R.id.tvcount);
        viewFlipper=findViewById(R.id.viewlipper);
        recyclerView=findViewById(R.id.rvlist);
        contacts= new ArrayList<>();
        contacts.add(new Contact("pizaa",10,0));
        contacts.add(new Contact("KFC super",20,0));
        contacts.add(new Contact("Bread Eggs",30,0));
        contacts.add(new Contact("Coca Cola",40,0));
        contacts.add(new Contact("Chicken super",50,0));

    }

    @Override
    public void onClickName(Contact contact) {
       // Toast.makeText(this, "click " + contact.getName(), Toast.LENGTH_SHORT).show();
        int countnow = Integer.parseInt(tvcount.getText().toString()) + 1;
        tvcount.setText(countnow + "");
        Contact temp = contacts.get(contacts.indexOf(contact));
        temp.setCount(temp.getCount() + 1);
        contacts.set(contacts.indexOf(contact),temp);
        totalPrice();
//        Log.d("test","count của " + contacts.get(contacts.indexOf(contact)).getName() + " = " + contacts.get(contacts.indexOf(contact)).getCount());

    }

    @Override
    public void onClickNumber(int a) {

    }
    public void totalPrice(){
        float tongtien = 0;
        for(Contact i : contacts){
              tongtien += i.getCount() * i.getCost() ;
        }
        tvprice.setText(tongtien + "$");
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("contact", (Serializable) contacts);
        outState.putString("count",tvcount.getText().toString());
        Log.d("test","on save state");
        Log.d("test","size on save : " + contacts.size());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String count = savedInstanceState.getString("count");
        contacts = (ArrayList<Contact>) savedInstanceState.getSerializable("contact");
        tvcount.setText(count);
        Log.d("test","count on restore = " + count);
        Log.d("test","on restore state");
        Log.d("test","size on restore : " + contacts.size());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test","on reseum");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test","on restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","on destroy");
    }
}
