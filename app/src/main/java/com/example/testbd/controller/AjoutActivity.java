package com.example.testbd.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.testbd.R;
import com.example.testbd.modele.Article;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AjoutActivity extends AppCompatActivity {

    Button btnAjout;
    ImageView imgAnnuler;
    EditText titreRecup, contenuRecup;
    Date date;
    SimpleDateFormat mFormat = new SimpleDateFormat("dd MMMM yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        btnAjout = findViewById(R.id.activity_ajout_btnAjouter);
        imgAnnuler = findViewById(R.id.activity_ajout_annuler);
        titreRecup = findViewById(R.id.activity_ajout_editTextAjoutTitre);
        contenuRecup = findViewById(R.id.activity_ajout_editTextAjoutContenu);
        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbOperation dbOperation = new DbOperation(AjoutActivity.this);
                if (titreRecup.getText().toString().isEmpty() || contenuRecup.getText().toString().isEmpty()){
                    Toast.makeText(AjoutActivity.this, "Veuillez saisir tout les champs", Toast.LENGTH_SHORT).show();
                }else {
                    Article article = new Article();
                    date = new Date();
                    article.setTitle(titreRecup.getText().toString());
                    article.setContenu(contenuRecup.getText().toString());
                    article.setDateDeCreation(mFormat.format(date));
                    dbOperation.ajouterArticle(article);
                    Toast.makeText(AjoutActivity.this, "Ajout réussi", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AjoutActivity.this, MainActivity.class));
                }
            }
        });
        imgAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}