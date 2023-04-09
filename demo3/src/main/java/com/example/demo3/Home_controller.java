package com.example.demo3;

import com.example.demo3.Connection.PatientDB;
import javafx.fxml.Initializable;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Home_controller implements Initializable {
    @FXML
    private AnchorPane change_scene;
    @FXML
    private AnchorPane home_nav;
    @FXML
    private Button home_patient;
    @FXML
    private Button home_rendez_vous;
    @FXML
    private ImageView home_rendez_vous1;
    @FXML
    private ImageView home_rendez_vous2;
    @FXML
    private Button deconnection;
    @FXML
    private Label titleid;

    public Home_controller() {
    }

    public void action1(ActionEvent e) throws SQLException, IOException {
       this.home_patient.getScene().getWindow().hide();
        Stage view = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("recherche_patient.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        view.setScene(scene);
        //view.getIcons().add(new Image("images/dossiers_medicaux.png"));
        view.setTitle("Gestion des soins ");
        view.show();
    }

    public void action2(ActionEvent e) throws SQLException, IOException {
       this.home_rendez_vous.getScene().getWindow().hide();
        Stage view = new Stage();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("rdv1.fxml"));
        Scene scene = new Scene(root);
        view.setScene(scene);
       // view.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
        view.setTitle("Gestion des soins ");
        view.show();
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        Connection cn = PatientDB.getConnection();
        PreparedStatement ps = null;

        try {
            ps = cn.prepareStatement("SELECT nom FROM medecin where(idmedecin=?);");
            ps.setInt(1, Integer.parseInt(Login_controller.idm));
            System.out.println(" success");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                this.titleid.setText("Bienvenue Docteur " + rs.getString("nom").toUpperCase());
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }
}
