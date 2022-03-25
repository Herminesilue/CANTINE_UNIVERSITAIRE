package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import javafx.event.ActionEvent;

public class acceuil1Controller {

	// Event Listener on Button.onAction
	@FXML
	public void inscription(ActionEvent event) {
		try {
			Parent root1 =FXMLLoader.load(getClass().getResource("/application/inscription.fxml"));
			Scene scene= new Scene(root1);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void connection(ActionEvent event) {
		try {
			Parent root2 =FXMLLoader.load(getClass().getResource("/application/connection.fxml"));
			Scene scene= new Scene(root2);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void load(String a) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource(a));
			Stage stage=new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
