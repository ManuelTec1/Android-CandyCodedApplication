package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ImageView mCandyImage = (ImageView) findViewById(R.id.image_view_candy);


        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    @Override
    public void onClick(View view) {
         final String locationAddress = "geo:0,0?q=618 E South St Orlando, FL 32801";
         final String tel = " 2125551212";
        //final String  tll = tel:(212) 555 1212;

        ImageView storeAddress = (ImageView) findViewById(R.id.image_view_map);
        ImageView phone = (ImageView) findViewById(R.id.image_view_phone);

// ***
        // TODO - Task 2 - Launch the Google Maps Activity
        // ***


        switch ( view.getId()) {
            case R.id.image_view_map:
                storeAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri data = Uri.parse(locationAddress);
                        Intent intent = new Intent( Intent.ACTION_VIEW, data    );
                        if (intent.resolveActivity(getPackageManager()) !=null) {
                            startActivity(intent);
                        }
                    }
                });

                // ***
                // TODO - Task 3 - Launch the Phone Activity
                // ***
            case R.id.image_view_phone:
                final Uri phoneNumber = Uri.parse("tel:" + tel);
                phone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
                        if (intent.resolveActivity( getPackageManager()) !=null){
                            startActivity(intent);
                        }

                    }
                });


        }
    }





}
