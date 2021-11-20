package com.example.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder> {
  //  OnClickHanler handler;
    Context context;
    ArrayList<users> usersArrayList;

    public MainActivity obj;

    public myAdapter(Context context, ArrayList<users> usersArrayList) {

        this.context = context;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public myAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new viewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHolder holder, int position) {
        users user = usersArrayList.get(position);
        holder.fruitName.setText(user.fruitName);
        holder.fruitUnit.setText(user.fruitUnit);
        holder.unit.setText(user.unit);
        holder.fruitPrice.setText(String.valueOf(user.fruitPrice));
        //viewHolder obj2 = new viewHolder();
        //obj.paisaPlus(obj2.getA()* Objects.requireNonNull(holder).fruitPrice);
        //obj.paisaPlus(Integer.parseInt(holder.fruitPrice.getText().toString()));
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView fruitName;
        TextView fruitPrice;
        TextView unit;
        TextView fruitUnit;
        TextView quantity;


        public viewHolder obj2;
        public int a = 0;
        Button plus, minus;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fruitName = itemView.findViewById(R.id.fruitName);
            fruitPrice = itemView.findViewById(R.id.fruitPrice);
            unit = itemView.findViewById(R.id.unit);
            fruitUnit = itemView.findViewById(R.id.fruitUnit);
            quantity = itemView.findViewById(R.id.quantity);

            a = Integer.parseInt(quantity.getText().toString());

            itemView.findViewById(R.id.btn_plus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ++a;
                    quantity.setText(String.valueOf(a));
                }

            });

            itemView.findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (a > 0) {
                        --a;
                    }
                    quantity.setText(String.valueOf(a));



                }


            });


        }

    }
}

