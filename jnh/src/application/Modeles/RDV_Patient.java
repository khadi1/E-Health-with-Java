package application.Modeles;

import java.time.LocalDate;

public class RDV_Patient {
	
	private int  Code;
	private LocalDate date;
	private int  IDPatient;
    private String nom, prenom;
    
    
public RDV_Patient( int iDPatient, String nom, String prenom ,LocalDate date ) {
		
		IDPatient = iDPatient;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
	}


public int getCode() {
	return Code;
}


public void setCode(int code) {
	Code = code;
}


public int getIDPatient() {
	return IDPatient;
}


public void setIDPatient(int iDPatient) {
	IDPatient = iDPatient;
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


public LocalDate getDate() {
	return date;
}


public void setDate(LocalDate date) {
	this.date = date;
}


    
    
}
