package application.Controllers;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Connection.PatientDB;
import application.DAOs.DAO;
import application.Modeles.Patient;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class recherche_patient_controller  implements Initializable{

	 @FXML
	    private TableView <Patient> set_table;
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

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	set_table.setOnMouseClicked((MouseEvent event) -> {
    		Patient p = set_table.getSelectionModel().getSelectedItem();
    		id =p.getID();  
    		 
    		
    	});
    	
		id_table.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	nom_table.setCellValueFactory(new PropertyValueFactory<>("nom"));
    	prenom_table.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    	num_cin_table.setCellValueFactory(new PropertyValueFactory<>("num_cin"));
    	sexe_table.setCellValueFactory(new PropertyValueFactory<>("sexe"));
    	date_naissance_table.setCellValueFactory(new PropertyValueFactory<>("Date_naissance"));
    	tel_table.setCellValueFactory(new PropertyValueFactory<>("tel"));
    	description_table.setCellValueFactory(new PropertyValueFactory<>("description"));
    	try {
			set_table.setItems( new DAO().getall());
		} catch (SQLException e) {
					e.printStackTrace();
		}
    	
    	
    	
    	
	}
   

    public void ajouter(ActionEvent e) throws SQLException, IOException {
		ajouter_patient.getScene().getWindow().hide()	;
		Stage view=new Stage();
	    Parent root=FXMLLoader.load(getClass().getResource("../fxml/ajout_patient.fxml"));
	    Scene scene=new Scene(root);
	    view.setScene(scene);
	    view.show();}
    
    public void retour(ActionEvent e) throws SQLException, IOException {
		retour.getScene().getWindow().hide()	;
		Stage view=new Stage();
	    Parent root=FXMLLoader.load(getClass().getResource("../fxml/Home.fxml"));
	    Scene scene=new Scene(root);
	    view.setScene(scene);
view.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
		
		view.setTitle("Gestion des soins ");
	    view.show();}

	

   @FXML
    void Supprimer(ActionEvent event) {
	    Connection c = PatientDB.getConnection();
		if (c != null) {
		try { PreparedStatement ps = c.prepareStatement("DELETE FROM `patient` WHERE (`idPatient` = ?);");
		ps.setInt(1,id);
		ps.executeUpdate();
		System.out.println("success d'executer la requette delete");
		update();
		}
		 catch (Exception e) { e.printStackTrace(); }
		}}	
		
   void update() {
	   try {
			set_table.setItems( new DAO().getall());
		} catch (SQLException e) {
					e.printStackTrace();
		}
   }

	
}




