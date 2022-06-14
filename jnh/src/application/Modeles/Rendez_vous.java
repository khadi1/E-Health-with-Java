package application.Modeles;

import java.time.LocalDate;


public class Rendez_vous {
private int  Code;
private int  IDPatient;
private int  IDMedecin;
private LocalDate date;



public Rendez_vous(int code, int iDPatient, int iDMedecin, LocalDate date) {
	Code = code;
	IDPatient = iDPatient;
	IDMedecin = iDMedecin;
	this.date = date;
}
public Rendez_vous(int idp ,int idm, LocalDate localDate) {
	IDPatient = idp;
	IDMedecin = idm;
	this.date = localDate;
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
public int getIDMedecin() {
	return IDMedecin;
}
public void setIDMedecin(int iDMedecin) {
	IDMedecin = iDMedecin;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}




}
