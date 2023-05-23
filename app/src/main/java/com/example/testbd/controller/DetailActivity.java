package com.example.testbd.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testbd.R;

import java.text.SimpleDateFormat;

public class DetailActivity extends AppCompatActivity {

    TextView title, datePublication, contenu;
    ImageView imgRetour;

    SimpleDateFormat mFormat = new SimpleDateFormat("dd MMMM yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.activity_detail_title);
        datePublication = findViewById(R.id.activity_detail_datePublication);
        contenu = findViewById(R.id.activity_detail_contenu);
        imgRetour = findViewById(R.id.activity_detail_imgRetour);
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        datePublication.setText(intent.getStringExtra("date"));
        contenu.setText(intent.getStringExtra("contenu"));
        imgRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}