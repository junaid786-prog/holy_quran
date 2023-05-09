package com.example.assignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ContactusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button contactUs = findViewById(R.id.contact_us_action);
        Button visitGitHub = findViewById(R.id.go_to_github);
        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactusActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        visitGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("h");
                Intent visitLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(visitLink);
            }
        });
    }
}