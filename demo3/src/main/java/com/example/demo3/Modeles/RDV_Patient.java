package com.example.demo3.Modeles;

import java.time.LocalDate;

public class RDV_Patient {
    private int Code;
    private LocalDate date;
    private int IDPatient;
    private String nom;
    private String prenom;

    public RDV_Patient(int iDPatient, String nom, String prenom, LocalDate date) {
        this.IDPatient = iDPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
    }

    public int getCode() {
        return Code;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getIDPatient() {
        return IDPatient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setCode(int code) {
        Code = code;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setIDPatient(int IDPatient) {
        this.IDPatient = IDPatient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
