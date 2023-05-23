package com.example.testbd.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.testbd.modele.Article;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DbOperation extends SQLiteOpenHelper {

    ArrayList<Article> arrayArticles  = new ArrayList<>();
    public DbOperation(@Nullable Context context) {
        super(context, "Blog.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db = getWritableDatabase();
        db.execSQL("Create TABLE blogs(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, dateDeCreation TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS blogs");
        onCreate(db);
    }

    public long ajouterArticle(Article article){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", article.getTitle());
        contentValues.put("content", article.getContenu());
        contentValues.put("dateDeCreation", article.getDateDeCreation().toString());
        long retourId = db.insert("blogs", null, contentValues);
        return retourId;
    }

    public ArrayList<Article> recupererArticle() throws ParseException {
        SQLiteDatabase db = getReadableDatabase();
        //Cursor curseur = db.query("blogs", champs, null, null, null,null, "ASC");
        Cursor curseur = db.rawQuery("SELECT * FROM blogs", null);
            while (curseur.moveToNext()){
                Article articles = new Article();
                articles.setId(curseur.getInt(curseur.getColumnIndexOrThrow("id")));
                articles.setTitle(curseur.getString(curseur.getColumnIndexOrThrow("title")));
                articles.setContenu(curseur.getString(curseur.getColumnIndexOrThrow("content")));
                articles.setDateDeCreation(curseur.getString(curseur.getColumnIndexOrThrow("dateDeCreation")));
                arrayArticles.add(articles);
            }
            curseur.close();
        return arrayArticles;
    }
    public Article recupererUnArticle(int id){
        //SQLiteDatabase db = getReadableDatabase();
        Article article = new Article();
        //String[] selectArgs = {String.valueOf(id)};
        //Cursor curseur = db.rawQuery("SELECT * FROM blogs where id=?", selectArgs);
        //curseur.moveToFirst();
        for (Article article2 : arrayArticles) {
            if (article2.getId() == id){
                article.setTitle(article2.getTitle());
                article.setContenu(article2.getContenu());
                article.setDateDeCreation(article2.getDateDeCreation());
            }
        }
        //article.setTitle(curseur.getString(curseur.getColumnIndexOrThrow("title")));
        //article.setContenu(curseur.getString(curseur.getColumnIndexOrThrow("content")));
        //article.setDateDeCreation(curseur.getString(curseur.getColumnIndexOrThrow("dateDeCreation")));
        //curseur.close();
        return article;
    }
}