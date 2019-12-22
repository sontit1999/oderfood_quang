package com.example.a38_buivanquang_food_order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.Viewholder>{
    List<Contact> contacts;
    Icon icon;
    Context context;

    public AdapterContact(List<Contact> contacts,Context context){
        this.context=context;
        this.contacts=contacts;
        icon = (Icon) context;
    }
    @NonNull
    @Override
    public AdapterContact.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_contect,parent,false);
        Viewholder viewholder=new Viewholder(view);
        context=parent.getContext();
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.Viewholder holder, int position) {

        final Contact contact=contacts.get(position);

        holder.tvname.setText(contact.getName());
        holder.tvcost.setText(String.valueOf(contact.getCost()));
        holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon.onClickName(contact);
                icon.onClickNumber(1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tvname,tvcost;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            tvcost=itemView.findViewById(R.id.tvcost);
            tvname=itemView.findViewById(R.id.tvname);
        }
    }
}
