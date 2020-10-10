package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {
    final String locationAddress = "geo:0,0?q=618 E South St Orlando, FL 32801";
    final String tel = "tel: 2125551212";
    TextView storeAddress = (TextView) findViewById(R.id.text_view_address);
    TextView phone = (TextView) findViewById(R.id.text_view_phone);

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

    public void createMapIntent (View view) {
        Uri mapUri = Uri.parse(locationAddress);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) !=null){
            startActivity(mapIntent);
        }
    }


    public  void createPhoneintent (View view) {
        Uri phoneUri = Uri.parse(tel);
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(phoneUri);
        startActivity(phoneIntent);
    }



// ***
        // TODO - Task 2 - Launch the Google Maps Activity
        // ***




                // ***
                // TODO - Task 3 - Launch the Phone Activity
                // ***










}
