package com.example.demo3.Modeles;

import java.time.LocalDate;

public class Rendez_vous {
    private int Code;
    private int IDPatient;
    private int IDMedecin;
    private LocalDate date;

    public Rendez_vous(int code, int iDPatient, int iDMedecin, LocalDate date) {
        this.Code = code;
        this.IDPatient = iDPatient;
        this.IDMedecin = iDMedecin;
        this.date = date;
    }

    public Rendez_vous(int idp, int idm, LocalDate localDate) {
        this.IDPatient = idp;
        this.IDMedecin = idm;
        this.date = localDate;
    }

    public int getCode() {
        return Code;
    }

    public int getIDPatient() {
        return IDPatient;
    }

    public int getIDMedecin() {
        return IDMedecin;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCode(int code) {
        Code = code;
    }

    public void setIDPatient(int IDPatient) {
        this.IDPatient = IDPatient;
    }

    public void setIDMedecin(int IDMedecin) {
        this.IDMedecin = IDMedecin;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
