package com.example.loginapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public  ImageAdapter(Context c){
        context=c;

    }

    @Override
    public int getCount() {
        return  icons.length;
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
        ImageView imageView= new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(200,200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(icons[i]);
        return imageView;
    }
    int icons[] = {R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img4,R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img4};
}
