package finah_desktop_fx.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WwVergetenController {
	
	@FXML
	private Button stuurWachtwoordBtn;
	@FXML
	private Button annulerenBtn;
	
	public WwVergetenController(){
		
	}
	
	@FXML
	public void stuurWachtwoord(ActionEvent actionEvent) {
		//MOET NOG GEMAAKT WORDEN
	}
	
	@FXML
	public void annuleren(ActionEvent actionEvent) {
		Stage stage = (Stage) annulerenBtn.getScene().getWindow();
	    stage.close();
	}
	
}
