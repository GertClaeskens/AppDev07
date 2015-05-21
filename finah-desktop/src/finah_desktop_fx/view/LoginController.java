package finah_desktop_fx.view;

import java.io.IOException;

import javax.swing.JOptionPane;

import finah_desktop_fx.MainApp;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	 
	  
	  public void nieuwAccount(ActionEvent actionEvent){
		  try {
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(MainApp.class.getResource("view/NieuwAccountLayout.fxml"));
		                AnchorPane nieuwAccLayout = (AnchorPane) loader.load();
		                Stage stage = new Stage();
		                stage.setScene(new Scene(nieuwAccLayout));  
		                stage.show();
		        } catch(Exception e) {
		           e.printStackTrace();
		          }
		}
	  
	  
	  public void wwVergeten(ActionEvent actionEvent){
		  try {
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(MainApp.class.getResource("view/WachtwoordVergetenLayout.fxml"));
		                AnchorPane wwVergetenLayout = (AnchorPane) loader.load();
		                Stage stage = new Stage();
		                stage.setScene(new Scene(wwVergetenLayout));  
		                stage.show();
		        } catch(Exception e) {
		           e.printStackTrace();
		          }
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
