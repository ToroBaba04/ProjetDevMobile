package com.example.testbd.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testbd.R;
import com.example.testbd.modele.Article;
import com.example.testbd.modele.Layouts;

import java.text.ParseException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imgAjout;
    DbOperation dbOp;
    ArrayList<Article> listeArticle = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbOp = new DbOperation(MainActivity.this);
        try {
            listeArticle = dbOp.recupererArticle();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Layouts layout = new Layouts();
        LinearLayout linearLayout = findViewById(R.id.activity_main_contenair1);
        for (Article article : listeArticle) {
            CardView card = layout.getCardView(MainActivity.this);
            TextView text1 = layout.getTextView1(MainActivity.this);
            TextView text2 = layout.getTextView2(MainActivity.this);
            card.setId(article.getId());
            card.setOnClickListener(this);
            String contenu;
            if (article.getContenu().length() > 90){
                contenu = article.getContenu().substring(0,90);
            }else{
                contenu = article.getContenu();
            }
            text1.setText(article.getTitle());
            text2.setText(contenu+"...");
            card.addView(text1);
            card.addView(text2);
            linearLayout.addView(card);
        }
        imgAjout = findViewById(R.id.activity_main_btnAjouter);
        imgAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AjoutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Article article = new Article();
        article = dbOp.recupererUnArticle(id);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("title", article.getTitle());
        intent.putExtra("contenu", article.getContenu());
        intent.putExtra("date", article.getDateDeCreation());
        startActivity(intent);
    }
}