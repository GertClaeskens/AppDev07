package finah_desktop_fx.view;

import javax.swing.JOptionPane;

import finah_desktop_fx.MainApp;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
//	  public void toonMainApp(final MainApp mainApp) {
//	    loginButton.setOnAction(new EventHandler<ActionEvent>() {
//	      @Override public void handle(ActionEvent event) {
//	        String test = authorize();
//	        if (test != null) {
//	          mainApp.authenticated();
//	        }
//	      }
//	    });
//	  }
	  
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
