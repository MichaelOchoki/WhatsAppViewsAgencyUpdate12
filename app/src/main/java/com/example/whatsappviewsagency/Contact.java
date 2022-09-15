package com.example.whatsappviewsagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.net.URLEncoder;

public class Contact extends AppCompatActivity {

    TextView question;
    EditText message;
    EditText client_names;
    EditText client_no;
    Button submit_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView question = findViewById(R.id.question);
        question.setText("Do you have an question?\n Feel free to contact our team!");

        message = findViewById(R.id.message);
        client_names = findViewById(R.id.client_names);
        client_no = findViewById(R.id.client_no);

        Button submit_question = findViewById(R.id.submit_question);
        submit_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Getting the text
                // from edit text
                String mes = message.getText().toString();
                String mes2 = client_names.getText().toString();
                String mes3 = client_no.getText().toString();
                // Calling the function
                // to send message
                sendMessage(mes2+"\n"+mes3+"\n\n"+mes);
            }
        });
    }

    private void sendMessage(String message)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.setPackage("com.whatsapp.w4b");
        if (i !=null){
            i.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(), "Application not found.", Toast.LENGTH_SHORT).show();
        }


    }








                /*Intent i = new Intent(Contact.this, Dashboard2.class); //will direct to implicit whatsapp or phone or sms
                startActivity(i);*//*
                String str = message.getText().toString();
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("whatsapp://send?phone="+ "+254790608001" +"&text=" + URLEncoder.encode("Hello \n WhatsApp Views Agency ", "UTF-8")));
                    i.putExtra("message_key", str);
                    startActivity(i);
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Whatsapp not installed!", Toast.LENGTH_LONG).show();
                }

                Toast.makeText(getApplicationContext(), "Sent successfully!", Toast.LENGTH_SHORT).show();
            }
        });
*/


        //Button upload = findViewById(R.id.upload);

}