package com.example.testbd.modele;

import java.util.Date;

public class Article {

    int id;
    String title;
    String contenu;
    String dateDeCreation;

    public String getTitle() {
        return title;
    }
    public String getContenu() {
        return contenu;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Article() {}

    public Article(int id, String title, String contenu, String dateDeCreation) {
        this.id = id;
        this.title = title;
        this.contenu = contenu;
        this.dateDeCreation = dateDeCreation;
    }


}
