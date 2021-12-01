package com.example.loginapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CycleAdapter extends RecyclerView.Adapter<CycleAdapter.MyViewHolder>{
    ArrayList<String> name;
    ArrayList<Integer> photo;
    Context context;
    public  CycleAdapter(Context context, ArrayList<String> personName,ArrayList<Integer> photo){
        this.context=context;
        this.name= personName;
        this.photo=photo;
    }
    @NonNull
    @Override
    public CycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelayout,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CycleAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.personname.setText(name.get(position));
        holder.personphoto.setImageResource(photo.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context.getApplicationContext(), ""+ name.get(position), Toast.LENGTH_SHORT).show();
                }
            });

    }

    @Override
    public int getItemCount() {
        return photo.size();
    }
   public  class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView personname;
        ImageView personphoto;

       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           personname= itemView.findViewById(R.id.textView7);
           personphoto= itemView.findViewById(R.id.imageView3);
       }

   }
}
