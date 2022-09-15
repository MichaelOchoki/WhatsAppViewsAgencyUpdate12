package com.example.whatsappviewsagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.URLEncoder;

import de.hdodenhof.circleimageview.CircleImageView;

public class Dashboard extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser currentUser ;

    //SharedPreferences sharedPreferences;
    TextView welcome;

    /*public static final String fileName = "login";
    public static final String Username = "username";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView welcome = findViewById(R.id.welcome);
        // ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        userData();


        /*sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Username))
            welcome.setText("Welcome\n" + sharedPreferences.getString(Username, ""));*/

        Button ads = findViewById(R.id.ads);
        Button views = findViewById(R.id.views);
        Button referrals = findViewById(R.id.referrals);
        Button contact = findViewById(R.id.contact);
        TextView logout = findViewById(R.id.logout);
        TextView upgrade = findViewById(R.id.upgrade);

        ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Ad.class);
                startActivity(i);
            }
        });

        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Views.class);
                startActivity(i);
            }
        });

        referrals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Referrals.class);
                startActivity(i);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Contact.class);
                startActivity(i);
            }
        });

        ImageView share_icon = findViewById(R.id.share_icon);

        share_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setDataAndType(Uri.parse("email"), "message/rfc822");
                Intent chooser = Intent.createChooser(intent, "Launch E-mail");
                startActivity(chooser);

            }
        });

        //launch whatsapp and send message

        ImageView whatsapp_icon = findViewById(R.id.whatsapp_icon);

        whatsapp_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("whatsapp://send?phone=" + "+92300xxxxxxx" + "&text=" + URLEncoder.encode("Hello :) \n\n " +
                            "Make money by simply posting an ad on your WhatsApp! \n\n" +
                            "You earn for every ad you post to your WhatsApp status " +
                            "from the WhatsApp Views Agency app as long as you get" +
                            " at least 100 views on each status. The payment is made to your " +
                            "MPESA account based on view grade. All ads come as an image. " +
                            "You will be paid for posting the image." +
                            "\n\n\n\n Download app here:[play_store_link]\"", "UTF-8")));
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Whatsapp not installed!", Toast.LENGTH_LONG).show();
                }
            }
        });


        ImageView fb_icon = findViewById(R.id.fb_icon);

        fb_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("facebook://send?phone=" + "&text=" + URLEncoder.encode("Hello \n\n Make money by simply posting an ad on your WhatsApp! \n\n\n\n Download app here:[play_store_link]\"", "UTF-8")));
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Facebook not installed!", Toast.LENGTH_LONG).show();
                }

            }
        });


        ImageView email_icon = findViewById(R.id.email_icon);

        email_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setDataAndType(Uri.parse("email"), "message/rfc822");
                String[] email = {""};
                intent.putExtra(intent.EXTRA_EMAIL, email);
                intent.putExtra(intent.EXTRA_SUBJECT, "REF:WHATSAPP VIEWS AGENCY");
                intent.putExtra(intent.EXTRA_TEXT, "Hello [name]\n\n Make money by simply posting an ad on your WhatsApp! \n\n\n\n Download app here:[play_store_link]"
                );
                Intent chooser = Intent.createChooser(intent, "Launch E-mail");
                startActivity(chooser);


            }
        });

        //logout takes you to Login
        /*logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();

                Intent i = new Intent(Dashboard.this, Welcome.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Logged out!", Toast.LENGTH_LONG).show();
            }
        });*/

        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, Upgrade.class);
                startActivity(i);


            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();

            }


        });

    }

    public void userData () {
        CircleImageView userImage = findViewById(R.id.userImage);
        TextView userName = findViewById(R.id.userName);
        userName.setText(currentUser.getDisplayName());


        if (currentUser.getPhotoUrl() != null) {
            Glide.with(this).load(currentUser.getPhotoUrl()).into(userImage);
        } else {
            Glide.with(this).load(R.drawable.avatarr).into(userImage);
        }
    }
}