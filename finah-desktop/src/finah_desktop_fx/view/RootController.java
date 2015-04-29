package finah_desktop_fx.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import finah_desktop_fx.MainApp;

public class RootController {

	private MainApp mainApp;
	private BorderPane rootLayout;
	@FXML
	MenuItem mnuAandoening;
	public RootController(){
		
	}
	
	private void initialize(){
		mnuAandoening.setOnAction(this::toonAandoeningen);
		rootLayout = mainApp.getRootLayout();
	}
    public void toonAandoeningen(ActionEvent actionEvent){
        try {
            // Load account layout.
            FXMLLoader loader = new FXMLLoader();
            //loader.setLocation(MainApp.class.getResource("view/AccountLayout.fxml"));
//            loader.setLocation(MainApp.class.getResource("view/AandoeningenLayout.fxml"));
            loader.setLocation(MainApp.class.getResource("view/NieuweBevragingLayout.fxml"));
            AnchorPane accountLayout = (AnchorPane) loader.load();

            // Set account layout into the center of root layout.
            rootLayout.setCenter(accountLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //personTable.setItems(mainApp.getPersonData());
    }
    
}
