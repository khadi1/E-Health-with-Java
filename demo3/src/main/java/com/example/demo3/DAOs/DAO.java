package com.example.demo3.DAOs;

import com.example.demo3.Connection.PatientDB;
import com.example.demo3.Login_controller;
import com.example.demo3.Modeles.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    public DAO() {
    }

    public void Ajouter(Patient p) {
        Connection c = PatientDB.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement("insert into Patient (nom,prenom,num_cin,date_naissance,sexe,tel,description,idmedecin) values (?,?,?,?,?,?,?,?);");
                ps.setString(1, p.getNom());
                ps.setString(2, p.getPrenom());
                ps.setInt(3, p.getNum_cin());
                ps.setString(4, p.getSexe());
                ps.setString(5, p.getDate_naissance());
                ps.setInt(6, p.getTel());
                ps.setString(7, p.getDescription());
                ps.setInt(8, Integer.parseInt(Login_controller.idm));
                int var4 = ps.executeUpdate();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

    }

    public ObservableList<Patient> getall() throws SQLException {
        Connection cn = PatientDB.getConnection();
        PreparedStatement pst = null;

        try {
            String sql = "Select * From Patient where (idmedecin=? )";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(Login_controller.idm));
            System.out.println("success d'executer la requette select all ");
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        ResultSet rs = pst.executeQuery();
        ObservableList<Patient> listPr = FXCollections.observableArrayList();

        while(rs.next()) {
            listPr.add(new Patient(rs.getInt("idpatient"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("num_cin"), rs.getString("sexe"), rs.getString("date_naissance"), rs.getInt("tel"), rs.getString("description"), Integer.parseInt(Login_controller.idm)));
        }

        return listPr;
    }
}
