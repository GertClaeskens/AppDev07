package finah_desktop_fx.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import finah_desktop_fx.MainApp;

public class NieuwAccountController {
	
	@FXML
	private Button accountAanmakenBtn;
	@FXML
	private Button annulerenBtn;
	
	public NieuwAccountController(){
		
	}
	
	@FXML
	public void accountAanmaken(ActionEvent actionEvent) {
		//MOET NOG GEMAAKT WORDEN
	}
	
	@FXML
	public void annuleren(ActionEvent actionEvent) {
		Stage stage = (Stage) annulerenBtn.getScene().getWindow();
	    stage.close();
	}
	
}
