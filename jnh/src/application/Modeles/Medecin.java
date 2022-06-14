package application.Modeles;

public class Medecin {

  

	private int ID_personnel;
    private String nom;
    private String prénom;
    private String tel;
    private String specialite; // medecin / infirmier / radiologue / chirurgien..
    private String motdepasse ;


    public Medecin(int iD_personnel, String nom, String prénom, String tel, String specialite, String motdepasse) {
  		ID_personnel = iD_personnel;
  		this.nom = nom;
  		this.prénom = prénom;
  		this.tel = tel;
  		this.specialite = specialite;
  		this.motdepasse  =motdepasse  ;
  		
  	}
    

    
    public int getID_personnel() {
        return ID_personnel;
    }

    
    public void setID_personnel(int ID_personnel) {
        this.ID_personnel = ID_personnel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



	public String getSpecialite() {
		return specialite;
	}



	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}



	public String getMotdepasse() {
		return motdepasse;
	}



	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

}