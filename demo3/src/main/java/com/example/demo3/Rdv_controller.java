package com.example.demo3;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.demo3.DAOs.DAO;
import com.example.demo3.DAOs.RDVdao;
import com.example.demo3.Modeles.Patient;
import com.example.demo3.Modeles.Rendez_vous;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Rdv_controller implements Initializable {
    @FXML
    private TextField idp;
    @FXML
    private Button rdvBtn;
    @FXML
    private DatePicker rdvdate;
    @FXML
    private Button retour;
    @FXML
    private TableView<Patient> set_table;
    @FXML
    private TableColumn<Patient, String> nom_table;
    @FXML
    private TableColumn<Patient, String> prenom_table;
    @FXML
    private TableColumn<Patient, Integer> id_table;

    public Rdv_controller() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.id_table.setCellValueFactory(new PropertyValueFactory("ID"));
        this.nom_table.setCellValueFactory(new PropertyValueFactory("nom"));
        this.prenom_table.setCellValueFactory(new PropertyValueFactory("prenom"));

        try {
            this.set_table.setItems((new DAO()).getall());
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        this.set_table.setOnMouseClicked((event) -> {
            Patient p = (Patient)this.set_table.getSelectionModel().getSelectedItem();
            this.idp.setText(Integer.toString(p.getID()));
        });
    }

    @FXML
    void add(ActionEvent event) {
        Rendez_vous r = new Rendez_vous(Integer.parseInt(this.idp.getText()), Integer.parseInt(Login_controller.idm), (LocalDate)this.rdvdate.getValue());
        RDVdao D = new RDVdao();
        D.Ajouter(r);
        System.out.println("RDV ajouté avec success...");
    }

    public void retour(ActionEvent e) throws SQLException, IOException {
        this.retour.getScene().getWindow().hide();
        Stage view = new Stage();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("rechercher_RDV.fxml"));
        Scene scene = new Scene(root);
        view.setScene(scene);
        //view.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
        view.setTitle("Gestion des soins ");
        view.show();
    }
}
