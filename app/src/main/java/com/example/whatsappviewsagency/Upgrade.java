package com.example.whatsappviewsagency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Upgrade extends AppCompatActivity {
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);


        FloatingActionButton back = findViewById(R.id.back);
        Button platinum = findViewById(R.id.platinum);
        Button gold = findViewById(R.id.gold);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Upgrade.this, Dashboard.class);
                startActivity(i);
            }
        });

        platinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(Upgrade.this);
                builder.setTitle("VIP PLATINUM PACKAGE"); // set Title
                builder.setMessage("Purchase this package?");  // set message
                builder.setCancelable(true); //  Sets whether the dialog is cancelable or not
                //builder.setIcon(R.mipmap.app_icon_foreground);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Upgrade.this, Welcome.class);
                        startActivity(i);
                        // Replace your Own Action

                        // Cancel the AlertDialog
                        alertDialog.cancel();

                        Intent intent = new Intent(getApplicationContext(), Welcome.class);
                        startActivity(intent);
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // Replace your Own Action

                                // Cancel the AlertDialog
                                alertDialog.cancel();
                            }
                        });
                alertDialog = builder.create();
                alertDialog.show();
            }
        });

        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(Upgrade.this);
                builder.setTitle("VIP GOLD PACKAGE"); // set Title
                builder.setMessage("Purchase this package?");  // set message
                builder.setCancelable(true); //  Sets whether the dialog is cancelable or not
                //builder.setIcon(R.mipmap.app_icon_foreground);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(Upgrade.this, Welcome.class);
                                startActivity(i);
                                // Replace your Own Action

                                // Cancel the AlertDialog
                                alertDialog.cancel();

                                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // Replace your Own Action

                                // Cancel the AlertDialog
                                alertDialog.cancel();
                            }
                        });
                alertDialog = builder.create();
                alertDialog.show();
            }
        });




    }
}