package application.Modeles;

import java.time.LocalDate;

import application.Controllers.login_controller;

public class Patient {
    private String nom, prenom,sexe,description;
    private String  Date_naissance;
    private int ID,num_cin,tel ,idmedecin;
    public Patient(int ID,String nom, String prenom,int num_cin,String sexe,String Date_naissance,int tel,String description,int idmedecin){
        this.ID=ID;
        this.num_cin=num_cin;
        this.nom=nom;
        this.prenom=prenom;
        this.Date_naissance=Date_naissance;
        this.sexe=sexe;
        this.tel=tel;
        this.description=description;
    }
    
  public Patient(String nom, String prenom,int num_cin,String sexe,String Date_naissance,int tel,String description ,int idmedecin){

        this.num_cin=num_cin;
        this.nom=nom;
        this.prenom=prenom;
        this.sexe=sexe;
        this.Date_naissance=Date_naissance;
        this.tel=tel;
        this.description=description; 
    }
public int getID() {
    return ID;
}
public void setID(int iD) {
    ID = iD;
}

public int getNum_cin() {
    return num_cin;
}
public void setNum_cin(int num_cin) {
    this.num_cin = num_cin;
}

public String getNom() {
    return nom;
}
public void setNom(String nom) {
    this.nom = nom;
}

public String getPrenom() {
    return prenom;
}

public void setPrenom(String prenom) {
    this.prenom = prenom;
}

public String getSexe() {
    return sexe;
}

public void setSexe(String sexe) {
    this.sexe = sexe;
}

public int getTel() {
    return tel;
}
public void setTel(int tel) {
    this.tel = tel;
}
public String  getDate_naissance() {
    return Date_naissance;
}
public void setDate_naissance(String  date_naissance) {
    Date_naissance = date_naissance;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}

public int getIdmedecin() {
	return idmedecin;
}

public void setIdmedecin(int idmedecin) {
	this.idmedecin = idmedecin;
}




}
