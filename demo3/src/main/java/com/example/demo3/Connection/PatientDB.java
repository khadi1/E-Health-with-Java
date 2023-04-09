package com.example.demo3.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PatientDB {
    private static String url = "jdbc:mysql://localhost:3306/doctorp";
    private static String user = "root";
    private static String password = "";
    private static Connection cn = null;

    public PatientDB() {
        String nom_driver =  "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(nom_driver);
            System.out.println("driver found");
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found" + e.getMessage());
        }

        try {
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("connected...");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static Connection getConnection() {
        if (cn == null) {
            new PatientDB();
        }

        return cn;
    }

    public static void Fermer() {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException var1) {
                var1.printStackTrace();
            }
        }

    }
}

