package com.example.whatsappviewsagency;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class AdminLogin extends AppCompatActivity {
    FirebaseFirestore firestore;
    EditText admiName, adminCode;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        firestore = FirebaseFirestore.getInstance();
        admiName = findViewById(R.id.admin);
        adminCode = findViewById(R.id.etPassword);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);
                //startActivity(intent);
                String username = admiName.getText().toString();
                String password = adminCode.getText().toString();

                //to change admin code
                if(username.equals("Admin") && password.equals("1234")){
                    //Intent i = new Intent(AdminLogin.this, AdminDashboard.class);
                    startActivity(intent);

                } else
                {
                    //Toast.makeText(getApplicationContext(), "For admins only!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Wrong code & name!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}

