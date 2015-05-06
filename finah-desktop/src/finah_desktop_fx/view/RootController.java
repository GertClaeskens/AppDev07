package finah_desktop_fx.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import finah_desktop_fx.MainApp;

public class RootController{

	private MainApp mainApp;
	@FXML
	private BorderPane rootLayout;
	@FXML
	private ButtonBar bbTopMenu;
	@FXML
	private Button btnAccount;
	@FXML
	private Button btnNieuweBevraging;
	@FXML
	private MenuButton MnuBeheer;
	@FXML
	private MenuItem MnuBeheerVragen;
	@FXML
	private MenuItem MnuBeheerVragenLijsten;
	@FXML
	private MenuItem MnuBeheerAandoeningen;
	@FXML
	private MenuItem MnuBeheerPathologieen;
	@FXML
	private MenuItem MnuBeheerRelaties;
	@FXML
	private MenuItem MnuBeheerAccounts;	
	@FXML
	private MenuItem MnuBeheerLftCat;
	@FXML
	private Button btnResultaten;
	@FXML
	private Button btnUitloggen;
	@FXML
	private BorderPane contentArea;
	public RootController() {

	}

	private void initialize() {
		rootLayout.getStylesheets().add("../finah_desktop_fx.css/finah_desktop_fx.css");
	}

	

	@FXML
	public void nieuweBevraging(ActionEvent actionEvent) {		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("view/NieuweBevragingLayout.fxml"));
			AnchorPane accountLayout = (AnchorPane) loader.load();
			rootLayout.setCenter(accountLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void toonAandoeningen(ActionEvent actionEvent) {		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("view/AandoeningenLayout.fxml"));
			AnchorPane accountLayout = (AnchorPane) loader.load();
			rootLayout.setCenter(accountLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void toonPathologieen(ActionEvent actionEvent) {		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("view/PathologieOverzicht.fxml"));
			AnchorPane accountLayout = (AnchorPane) loader.load();
			rootLayout.setCenter(accountLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	@FXML
	public void toonVragen(ActionEvent actionEvent) {		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("view/VragenOverzicht.fxml"));
			AnchorPane accountLayout = (AnchorPane) loader.load();
			rootLayout.setCenter(accountLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void toonLeeftijdsCategorieen(ActionEvent actionEvent) {		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("view/LftdsCatOverzicht.fxml"));
			AnchorPane accountLayout = (AnchorPane) loader.load();
			rootLayout.setCenter(accountLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void toonRelaties(ActionEvent actionEvent) {		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("view/RelatieOverzicht.fxml"));
			AnchorPane accountLayout = (AnchorPane) loader.load();
			rootLayout.setCenter(accountLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
