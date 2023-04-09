package com.example.demo3.DAOs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.example.demo3.Connection.PatientDB;
import com.example.demo3.Modeles.RDV_Patient;
import com.example.demo3.Modeles.Rendez_vous;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RDVdao {
    public RDVdao() {
    }

    public void Ajouter(Rendez_vous r) {
        Connection c = PatientDB.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement("INSERT INTO `rendez_vous` (`IDPatient`, `IDMedecin`, `date`) VALUES (?, ?, ?);");
                ps.setInt(1, r.getIDPatient());
                ps.setInt(2, r.getIDMedecin());
                ps.setString(3, r.getDate().toString());
                ps.executeUpdate();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

    }

    public ObservableList<RDV_Patient> getall() throws SQLException {
        Connection cn = PatientDB.getConnection();
        PreparedStatement pst = null;
        String sql = "Select rendez_vous.IDPatient , rendez_vous.date , patient.nom , patient.prenom From rendez_vous , patient where(rendez_vous.IDPatient=patient.idPatient);";

        try {
            pst = cn.prepareStatement(sql);
            System.out.println("success d'executer la requette select all ");
        } catch (SQLException var6) {
            System.out.println(var6.getMessage());
        }

        ResultSet rs = pst.executeQuery();
        ObservableList<RDV_Patient> listPr = FXCollections.observableArrayList();

        while(rs.next()) {
            listPr.add(new RDV_Patient(rs.getInt("IDPatient"), rs.getString("nom"), rs.getString("prenom"), LocalDate.parse(rs.getString("date"))));
        }

        return listPr;
    }

    public int count() throws SQLException {
        int counter = 0;
        Connection cn = PatientDB.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT rendez_vous.date, DATE_FORMAT(rendez_vous.date, '%Y-%m-%d')  FROM rendez_vous WHERE DATE(date) = CURDATE();";

        try {
            pst = cn.prepareStatement(sql);
            System.out.println("success d'executer la requette select date aujourd'hui ");
        } catch (SQLException var6) {
            System.out.println(var6.getMessage());
        }

        for(ResultSet rs = pst.executeQuery(); rs.next(); ++counter) {
        }

        return counter;
    }
}
