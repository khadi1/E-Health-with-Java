package com.example.demo3;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo3.Connection.PatientDB;
import com.example.demo3.DAOs.DAO;
import com.example.demo3.Main;
import com.example.demo3.Modeles.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class recherche_patient_controller implements   Initializable{


    @FXML
    private TableView<Patient> set_table;
    @FXML
    private TableColumn<Patient, String> nom_table;
    @FXML
    private TableColumn<Patient, Integer> id_table;
    @FXML
    private TableColumn<Patient, Integer> num_cin_table;
    @FXML
    private TableColumn<Patient, String> prenom_table;
    @FXML
    private TableColumn<Patient, String> sexe_table;
    @FXML
    private TableColumn<Patient, Integer> tel_table;
    @FXML
    private TableColumn<Patient, String> description_table;
    @FXML
    private TableColumn<Patient, String> date_naissance_table;
    @FXML
    private Button view_button;
    @FXML
    private Button ajouter_patient;
    @FXML
    private Button retour;
    @FXML
    private Button supprime;
    private int id;

    public recherche_patient_controller()  {
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        this.set_table.setOnMouseClicked((event) -> {
            Patient p = (Patient)this.set_table.getSelectionModel().getSelectedItem();
            this.id = p.getID();
        });
        this.id_table.setCellValueFactory(new PropertyValueFactory("ID"));
        this.nom_table.setCellValueFactory(new PropertyValueFactory("nom"));
        this.prenom_table.setCellValueFactory(new PropertyValueFactory("prenom"));
        this.num_cin_table.setCellValueFactory(new PropertyValueFactory("num_cin"));
        this.sexe_table.setCellValueFactory(new PropertyValueFactory("sexe"));
        this.date_naissance_table.setCellValueFactory(new PropertyValueFactory("Date_naissance"));
        this.tel_table.setCellValueFactory(new PropertyValueFactory("tel"));
        this.description_table.setCellValueFactory(new PropertyValueFactory("description"));

        try {
            this.set_table.setItems((new DAO()).getall());
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public void ajouter(ActionEvent e) throws SQLException, IOException {
        this.ajouter_patient.getScene().getWindow().hide();
        Stage view = new Stage();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("ajout_patient.fxml"));
        Scene scene = new Scene(root);
        view.setScene(scene);
        view.show();
    }

    public void retour(ActionEvent e) throws SQLException, IOException {
        this.retour.getScene().getWindow().hide();
        Stage view = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        view.setScene(scene);
        //view.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
        view.setTitle("Gestion des soins ");
        view.show();
    }

    @FXML
    void Supprimer(ActionEvent event) {
        Connection c = PatientDB.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement("DELETE FROM `patient` WHERE (`idPatient` = ?);");
                ps.setInt(1, this.id);
                ps.executeUpdate();
                System.out.println("success d'executer la requette delete");
                this.update();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

    }

    void update()  {
       try{
            this.set_table.setItems((new DAO()).getall());
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }
}


