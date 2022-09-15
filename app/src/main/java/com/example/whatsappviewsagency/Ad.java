package com.example.whatsappviewsagency;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class Ad extends AppCompatActivity {
    private ImageView ad;
    private TextView post_ad;
    private Button download;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        // Get the application context
        mContext = getApplicationContext();

        // Get the widgets reference from XML layout
        Button download = findViewById(R.id.download);
        ImageView ad = findViewById(R.id.omo_ad);
        TextView post_ad = findViewById(R.id.post_ad);
        //mTvSaved = findViewById(R.id.tvSaved);

        download.setOnClickListener(v -> {
            // Get the image from drawable
            // resource as drawable object
            Drawable drawable = ContextCompat.getDrawable(
                    mContext,R.drawable.blue_band_ad
            );

            // Get the bitmap from drawable object
            //assert drawable != null;
            Bitmap bitmap = ((BitmapDrawable)drawable)
                    .getBitmap();

            // Save image to gallery
            String savedImageURL = MediaStore.Images.Media
                    .insertImage(
                            getContentResolver(),
                            bitmap,
                            "flower",
                            "Image of flower"
                    );

            // Parse the gallery image url to uri
            Uri savedImageURI = Uri.parse(savedImageURL);

            // Display the saved image to ImageView
            //mIvSaved.setImageURI(savedImageURI);

            // Display saved image url to TextView
            //mTvSaved.setText(
            //"Image saved to gallery.\n" + savedImageURL

            Toast.makeText(getApplicationContext(), "Ad downloaded to gallery!\n", Toast.LENGTH_SHORT).show();

            // );
        });
    }
}