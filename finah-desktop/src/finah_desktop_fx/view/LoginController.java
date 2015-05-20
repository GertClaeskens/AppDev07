package finah_desktop_fx.view;

import java.io.IOException;

import javax.swing.JOptionPane;

import finah_desktop_fx.MainApp;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	
	private MainApp mainApp;
	  @FXML private TextField user;
	  @FXML private TextField password;
	  @FXML private Button loginButton;
	  
	  public void initialize() {}
	  
	  @FXML
	  public void toonMainApp(ActionEvent actionEvent) {
		  String test = authorize();
	      if (test != null) {
	      mainApp.authenticated();
	      }
	      else{
	    	  JOptionPane.showMessageDialog(null, "Wrong username or password.", "Login Failure", JOptionPane.ERROR_MESSAGE);
	      }
	  }
	  
	  @FXML
	  public void exitApp(ActionEvent actionEvent) {
		  mainApp.close();
	  }
	  
	  //Werkt nog niet volledig (zie MainApp -> nulpointer exception)
	  public void nieuwAccount(ActionEvent actionEvent){
		    Stage stage = mainApp.getPrimaryStage(); 
			stage.setWidth(400);
			stage.setHeight(550);
			mainApp.showNieuwAccount();
	    }
	    
	  //Werkt nog niet volledig (zie MainApp -> nulpointer exception)
	  public void wwVergeten(ActionEvent actionEvent){
		  	Stage stage = mainApp.getPrimaryStage(); 
			stage.setWidth(400);
			stage.setHeight(375);
			mainApp.showWwVergeten();
	    }
	  
	  private String authorize() {
	    return 
	      "test".equals(user.getText()) && "test".equals(password.getText()) 
	            ? ("test") 
	            : null;
	  }
	  
	  public void setMainApp(MainApp mainApp) {
			this.mainApp = mainApp;
		}
}
