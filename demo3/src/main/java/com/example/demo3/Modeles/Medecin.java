package com.example.demo3.Modeles;

public class Medecin {private int ID_personnel;
    private String nom;
    private String prenom;
    private String tel;
    private String specialite;
    private String motdepasse;

    public Medecin(int iD_personnel, String nom, String prenom, String tel, String specialite, String motdepasse) {
        this.ID_personnel = iD_personnel;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.specialite = specialite;
        this.motdepasse = motdepasse;
    }

    public int getID_personnel() {
        return ID_personnel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setID_personnel(int ID_personnel) {
        this.ID_personnel = ID_personnel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
}
