package com.example.loginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] icons;
    String[] districts;
    LayoutInflater inflater;
    public CustomAdapter(Context applicationContext, int[] icons, String[] name) {
        context=applicationContext;
        this.icons=icons;
        this.districts=name;
        inflater = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {

        return icons.length;
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
        VersionHolder holder= new VersionHolder();
        if (view==null) {
          int icons[] = {R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img4,R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img4};    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cus_list_layout, null);
            holder.checkBox = view.findViewById(R.id.checkBox);
            holder.imageView = view.findViewById(R.id.image_cus);
            holder.textView = view.findViewById(R.id.text_cus);
            holder.checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) context);
            view.setTag(holder);
        }
        else {
            holder=(VersionHolder)view.getTag();
        }

        return  view;
    }
public  static  class VersionHolder{
        public CheckBox checkBox;
        public  ImageView imageView;
        public  TextView textView;

}

}
