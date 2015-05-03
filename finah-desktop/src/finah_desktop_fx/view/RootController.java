package finah_desktop_fx.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import finah_desktop_fx.MainApp;

public class RootController {

	private MainApp mainApp;
	private BorderPane rootLayout;
	@FXML
	MenuItem MnuBeheerAandoeningen;
	@FXML
	Button btnNieuweBevraging;
	@FXML
	Menu mnuBeheerMenu;
	
	public RootController(){
		
	}
	
	private void initialize(){
		EventHandler<ActionEvent> action = menuItems();
//		for (MenuItem m : mnuBeheerMenu.getItems()){
//			m.setOnAction(action);
//		}
		MnuBeheerAandoeningen.setOnAction(action);
//		btnNieuweBevraging.setOnAction(this::nieuweBevraging);
		rootLayout = mainApp.getRootLayout();
	}
    
	@FXML
    private EventHandler<ActionEvent> menuItems() {
        return new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String side = mItem.getText();
                FXMLLoader loader = new FXMLLoader();
                if ("Aandoeningen".equalsIgnoreCase(side)) {
                    try {
                        // Load account layout.
                        
                        loader.setLocation(MainApp.class.getResource("view/AandoeningenLayout.fxml"));
                        AnchorPane accountLayout = (AnchorPane) loader.load();

                        // Set account layout into the center of root layout.
                        rootLayout.setCenter(accountLayout);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if ("Vragen".equalsIgnoreCase(side)) {
                    System.out.println("right");
                } else if ("VragenLijsten".equalsIgnoreCase(side)) {
                    System.out.println("top");
                } else if ("Pathologieen".equalsIgnoreCase(side)) {
                    try {
                        loader.setLocation(MainApp.class.getResource("view/PathologieLayout.fxml"));
                        AnchorPane accountLayout = (AnchorPane) loader.load();

                        // Set account layout into the center of root layout.
                        rootLayout.setCenter(accountLayout);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if ("Accounts".equalsIgnoreCase(side)) {
                    try {
                        // Load account layout.
                        loader.setLocation(MainApp.class.getResource("view/AccountLayout.fxml"));
                        AnchorPane accountLayout = (AnchorPane) loader.load();

                        // Set account layout into the center of root layout.
                        rootLayout.setCenter(accountLayout);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    
	@FXML
    public void nieuweBevraging(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader();
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
