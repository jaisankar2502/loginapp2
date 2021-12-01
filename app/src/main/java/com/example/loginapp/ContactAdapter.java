package com.example.loginapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ContactAdapter extends BaseAdapter {
    Context context;
    String[] contactname;
    int[]contactimage;
    String[]contactnumber;
    ContactAdapter(Context context,String[]name,int[]image,String[]number){
        this.context=context;
        this.contactname=name;
       this.contactimage= image;
       this.contactnumber=number;


    }
    @Override
    public int getCount() {
        return contactname.length;
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
        Holder holder;
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.contact,null);
            holder= new Holder(view,contactnumber,i,context,contactname);
            view.setTag(holder);

        }
        else {
            holder=(Holder) view.getTag();

        }
        holder.imageView.setImageResource(contactimage[i]);
        holder.textView.setText(contactname[i]);
        holder.number.setText(contactnumber[i]);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the object of
                // AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(context.getApplicationContext());

                // Set the message show for the Alert time
                builder.setMessage(" you want to call or message ?");
                // Set Alert Title
                builder.setTitle("Alert !");
                // Set Cancelable false
                // for when the user clicks on the outside
                // the Dialog Box then it will remain show
                builder.setCancelable(false);
                // Set the positive button with yes name
                // OnClickListener method is use of
                // DialogInterface interface.

                builder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        // When the user click yes button
                        // then app will close
                        holder.finish();
                    }
                });

                // Set the Negative button with No name
                // OnClickListener method is use
                // of DialogInterface interface.
                builder.setNegativeButton("Message", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // If user click no
                        // then dialog box is canceled.
                        dialog.cancel();
                    }
                });
                builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Create the Alert dialog
               AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
        return  view;
    }


    }

    class Holder extends AppCompatActivity {
        private static final int REQUEST_CALL = 1;
        ImageView imageView;
        TextView textView;
        TextView number;
        Button button1;
        Button button2;
        String[] contactnumber;
        String []name;
        Context phonecontext;
        ConstraintLayout layout;


        Holder(View view, String[] contactnumber, int i, Context context,String[]contactname) {
            imageView = view.findViewById(R.id.imageView);
            textView = view.findViewById(R.id.textView6);
            button1 = view.findViewById(R.id.button4);
            button2 = view.findViewById(R.id.button5);
            number = view.findViewById(R.id.number);
            layout= view.findViewById(R.id.layoutid);
            this.contactnumber = contactnumber;
            this.phonecontext = context;
            this.name=contactname;
//            button2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    makePhoneCall(contactnumber,context,i,contactname);
//
//                }
//
//            }
//            );


        }
        private void makePhoneCall(String[] num, Context context, int i, String[] name) {
            for(int j=0;j<=contactnumber.length;j++){
                if (contactnumber[j]==name[i])
                {
                    String number = contactnumber[j].toString();
                    if (number.trim().length() > 0) {

                        if (ContextCompat.checkSelfPermission(context.getApplicationContext(),
                                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions((Activity) context.getApplicationContext(),
                                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                        } else {
                            String dial = "tel:" + number;
                            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                        }

                    } else {
                        Toast.makeText(context.getApplicationContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    }
                }
                }
            }


    }