package application.Controllers;

import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;


import application.DAOs.RDVdao;
import application.Modeles.RDV_Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RDV_Rechercher_Controller  implements Initializable {

	@FXML
    private TableView <RDV_Patient> set_table;
	
    @FXML
    private TableColumn<RDV_Patient, String> date_table;

    @FXML
    private TableColumn<RDV_Patient, String> nom_table;

    @FXML
    private TableColumn<RDV_Patient, Integer> id_table;

    @FXML
    private Label RDVnbr;

    @FXML
    private TableColumn<RDV_Patient, String> prenom_table;
    
    @FXML
    private Button fixer_rendez_vous;
    @FXML
    private Button retour;
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		date_table.setCellValueFactory(new PropertyValueFactory<>("date"));
		id_table.setCellValueFactory(new PropertyValueFactory<>("IDPatient"));
		
		nom_table.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 prenom_table.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    	try {
    		RDVdao RDVdao =new RDVdao() ;
			set_table.setItems( RDVdao.getall());
			RDVnbr.setText(Integer.toString(RDVdao.count()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
	}
	public void retour(ActionEvent e) throws SQLException, IOException {
		retour.getScene().getWindow().hide()	;
		Stage view=new Stage();
	    Parent root=FXMLLoader.load(getClass().getResource("../fxml/Home.fxml"));
	    Scene scene=new Scene(root);
	    view.setScene(scene);
view.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
		
		view.setTitle("Gestion des soins ");
	    view.show();}
	
	public void fixer(ActionEvent e) throws SQLException, IOException {
		fixer_rendez_vous.getScene().getWindow().hide()	;
		Stage view=new Stage();
	    Parent root=FXMLLoader.load(getClass().getResource("../fxml/rdv1.fxml"));
	    Scene scene=new Scene(root);
	    view.setScene(scene);
view.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
		
		view.setTitle("Gestion des soins ");
	    view.show();}
	
	
}