package application.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import application.Connection.PatientDB;
import application.Modeles.RDV_Patient;
import application.Modeles.Rendez_vous;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RDVdao {
	
	public void  Ajouter(Rendez_vous r) {
		Connection c = PatientDB.getConnection();
		if (c != null) {
		try { PreparedStatement ps = c.prepareStatement("INSERT INTO `rendez_vous` (`IDPatient`, `IDMedecin`, `date`) VALUES (?, ?, ?);");
		ps.setInt(1, r.getIDPatient());
		ps.setInt(2, r.getIDMedecin());
		ps.setString(3, r.getDate().toString());
				
		ps.executeUpdate();
		}
		 catch (Exception e) { e.printStackTrace(); }
		}}	
		
			
				public ObservableList<RDV_Patient>  getall() throws SQLException {
					
					Connection cn = PatientDB.getConnection();
					ResultSet rs;
					PreparedStatement pst=null;
					String sql="Select rendez_vous.IDPatient , rendez_vous.date , patient.nom , patient.prenom From rendez_vous , patient where(rendez_vous.IDPatient=patient.idPatient);";
					try {
						pst= cn.prepareStatement(sql);
						System.out.println("success d'executer la requette select all ");
					} catch (SQLException e) {
						System.out.println(e.getMessage());}
					
					 rs = pst.executeQuery() ;
					 ObservableList < RDV_Patient> listPr = FXCollections.observableArrayList();
						while(rs.next()) {
							listPr.add(new  RDV_Patient( rs.getInt("IDPatient"),rs.getString("nom"),rs.getString("prenom"),LocalDate.parse(rs.getString("date"))));
							
							
							
							
						}
							return listPr;
				}
				
				
				
				
				public int count() throws SQLException {
					int counter =  0  ; 
					Connection cn = PatientDB.getConnection();
					PreparedStatement pst = null;
					String sql="SELECT rendez_vous.date, DATE_FORMAT(rendez_vous.date, '%Y-%m-%d')  FROM database56.rendez_vous WHERE DATE(date) = CURDATE();";
					try {
						pst= cn.prepareStatement(sql);
						System.out.println("success d'executer la requette select date aujourd'hui ");
					} catch (SQLException e) {
						System.out.println(e.getMessage());}	
					
					ResultSet rs = pst.executeQuery() ;
					 while(rs.next()) {counter++;}
					 return counter ;
												
				}
	
				
				
				
				
				
				
}
