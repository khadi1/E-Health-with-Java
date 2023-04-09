package com.example.demo3.Modeles;

public class Patient {
    private String nom;
    private String prenom;
    private String sexe;
    private String description;
    private String Date_naissance;
    private int ID;
    private int num_cin;
    private int tel;
    private int idmedecin;


    public Patient(int ID, String nom, String prenom, int num_cin, String sexe, String Date_naissance, int tel, String description, int idmedecin) {
        this.ID = ID;
        this.num_cin = num_cin;
        this.nom = nom;
        this.prenom = prenom;
        this.Date_naissance = Date_naissance;
        this.sexe = sexe;
        this.tel = tel;
        this.description = description;
    }

    public Patient(String nom, String prenom, int num_cin, String sexe, String Date_naissance, int tel, String description, int idmedecin) {
        this.num_cin = num_cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.Date_naissance = Date_naissance;
        this.tel = tel;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_naissance() {
        return Date_naissance;
    }

    public int getID() {
        return ID;
    }

    public int getNum_cin() {
        return num_cin;
    }

    public int getTel() {
        return tel;
    }

    public int getIdmedecin() {
        return idmedecin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_naissance(String date_naissance) {
        Date_naissance = date_naissance;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNum_cin(int num_cin) {
        this.num_cin = num_cin;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setIdmedecin(int idmedecin) {
        this.idmedecin = idmedecin;
    }
}

