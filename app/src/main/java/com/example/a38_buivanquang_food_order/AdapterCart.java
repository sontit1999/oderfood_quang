package com.example.a38_buivanquang_food_order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.Viewholder> {
    Context context;
    ArrayList<Contact> arrayList;

    public AdapterCart(Context context, ArrayList<Contact> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    public void setList(ArrayList<Contact> list){
        this.arrayList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override

    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oder,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
         Contact contact = arrayList.get(position);
         holder.bindData(contact);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tvname;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.tvname= itemView.findViewById(R.id.tv_food);
        }
        public void bindData(Contact contact){
            this.tvname.setText(contact.getName() + "(" + contact.getCount() + ")");
        }
    }
}
