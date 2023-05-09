package com.example.assignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        } catch (Exception e){
            System.out.println("j");
        }

        Button sendEmailBtn = findViewById(R.id.send_btn);
        ImageView goBackBtn = findViewById(R.id.arrow_back);

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactusActivity.class);
                startActivity(intent);
            }
        });
        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView subject = findViewById(R.id.editTextTextPersonName2);
                String subjectStr = subject.getText().toString();

                TextView body = findViewById(R.id.text_area);
                String bodyStr = subject.getText().toString();

                sendEmail(subjectStr, bodyStr, "bsef20a511@pucit.edu.pk");
            }
        });
    }

    public void sendEmail(String subject, String body, String target){
        String [] to = {"a@a.com", target};
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto: "));
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, to);
        email.putExtra(Intent.EXTRA_SUBJECT,subject );
        email.putExtra(Intent.EXTRA_TEXT, body);

        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose email"));
    }

    public void goWhatsapp(){
        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
        String number = "+923495653099";
        whatsapp.setData(Uri.parse("https://api.whatsapp.com/send?phone = " + number));
        startActivity(whatsapp);
    }
}