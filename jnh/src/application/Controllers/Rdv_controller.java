package application.Controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.DAOs.DAO;
import application.DAOs.RDVdao;
import application.Modeles.Patient;
import application.Modeles.Rendez_vous;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Rdv_controller implements Initializable{

    @FXML
    private TextField idp;

    @FXML
    private Button rdvBtn;

    @FXML
    private DatePicker rdvdate;

    @FXML
    private Button retour;
    
    
    
    
    @FXML
    private TableView <Patient> set_table;
@FXML
private TableColumn<Patient, String> nom_table;

@FXML
private TableColumn<Patient, String> prenom_table;

@FXML
private TableColumn<Patient, Integer> id_table;
    


@Override
public void initialize(URL location, ResourceBundle resources) {
	id_table.setCellValueFactory(new PropertyValueFactory<>("ID"));
	nom_table.setCellValueFactory(new PropertyValueFactory<>("nom"));
	prenom_table.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	try {
		set_table.setItems( new DAO().getall());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	set_table.setOnMouseClicked((MouseEvent event) -> {
		Patient p = set_table.getSelectionModel().getSelectedItem();
		 idp.setText(Integer.toString(p.getID()));  
		
	});

	
}


    
    @FXML
    void add(ActionEvent event) {
    	
    	
    	
  	  Rendez_vous r=new Rendez_vous(Integer.parseInt(idp.getText()),/* Integer.parseInt(login_controller.idm)*/15,rdvdate.getValue());
  	  RDVdao D=new RDVdao();
  	  D.Ajouter(r);
  	  System.out.println("RDV ajouté avec success...");
  	  
    	
    	
    	
    }

    public void retour(ActionEvent e) throws SQLException, IOException {
		retour.getScene().getWindow().hide()	;
		Stage view=new Stage();
	    Parent root=FXMLLoader.load(getClass().getResource("../fxml/rechercher_RDV.fxml"));
	    Scene scene=new Scene(root);
	    view.setScene(scene);
view.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
		
		view.setTitle("Gestion des soins ");
	    view.show();}
	

}
