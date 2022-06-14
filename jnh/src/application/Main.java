package application;
import java.io.File;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Stage st=primaryStage;
		
		try {
			Parent root=FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("file:C:\\Users\\Utilisateur\\wrplace\\jnh\\src\\application\\images\\dossiers-medicaux.png"));
			
			primaryStage.setTitle("Gestion des soins ");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
		

	
	
	
	public static void main(String[] args) {

		launch(args);


	
	}
}
