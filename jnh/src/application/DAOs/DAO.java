package application.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import application.Connection.PatientDB;
import application.Controllers.login_controller;
import application.Modeles.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO {
	
			public void  Ajouter(Patient p) {
			Connection c = PatientDB.getConnection();
			if (c != null) {
			try { PreparedStatement ps = c.prepareStatement("insert into Patient (nom,prenom,num_cin,date_naissance,sexe,tel,description,idmedecin) values (?,?,?,?,?,?,?,?);");
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setInt(3, p.getNum_cin());
			ps.setString(4, p.getSexe());
			ps.setString(5, p.getDate_naissance());
			ps.setInt(6, p.getTel());
			ps.setString(7, p.getDescription());
			ps.setInt(8, Integer.parseInt(login_controller.idm));
			
			int res = ps.executeUpdate();
			}
			 catch (Exception e) { e.printStackTrace(); }
			}}	
			
			public ObservableList<Patient>  getall() throws SQLException {
				
				Connection cn = PatientDB.getConnection();
				ResultSet rs;
				PreparedStatement pst=null;
				
				try {
					String sql="Select * From Patient where (idmedecin=? )";
					pst= cn.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(login_controller.idm));
					System.out.println("success d'executer la requette select all ");
				} catch (SQLException e) {
					System.out.println(e.getMessage());}
				
				 rs = pst.executeQuery() ;
				 ObservableList <Patient> listPr = FXCollections.observableArrayList();
					while(rs.next()) {
						
						listPr.add(new Patient(rs.getInt("idpatient"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("num_cin"),rs.getString("sexe"),rs.getString("date_naissance"),rs.getInt("tel"),rs.getString("description"),Integer.parseInt(login_controller.idm)));}
						return listPr;
					
					}

			
			
			
}
