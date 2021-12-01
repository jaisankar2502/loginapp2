package com.example.loginapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class LIstAdapter extends BaseAdapter {
    Context context;
    String district[];
    int icon[];

    public LIstAdapter(Context CONTEXT, int icon[], String district[]) {
        this.context = CONTEXT;
        this.district = district;
        this.icon = icon;

    }

    @Override
    public int getCount() {
       return district.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyviewHolder holder=null;
        if (view==null){
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.custom_layout_list,null);
            holder= new MyviewHolder(view);
            view.setTag(holder);


        }
        else {
            holder= (MyviewHolder)view.getTag();

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), "haiii", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, LIst_display.class);
                intent.putExtra("name", district[i]);
                intent.putExtra("image", icon[i]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.imageView.setImageResource(icon[i]);
        holder.textView.setText(district[i]);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(context.getApplicationContext(), "District"+district[i], Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    class MyviewHolder{
        ImageView imageView;
        TextView textView;
        CheckBox checkBox;
        LinearLayout itemView;
        MyviewHolder(View view){
            itemView = (LinearLayout)view.findViewById(R.id.itemView);
            imageView= (ImageView)view.findViewById(R.id.imageView2);
            textView= (TextView) view.findViewById(R.id.textView5);
            checkBox= (CheckBox) view.findViewById(R.id.checkBox2);
        }
    }

}
