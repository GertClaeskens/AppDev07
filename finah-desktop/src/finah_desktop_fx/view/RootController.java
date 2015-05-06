package finah_desktop_fx.view;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import finah_desktop_fx.MainApp;

public class RootController {

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

		rootLayout.setAlignment(bbTopMenu, Pos.CENTER_LEFT);
		// bbTopMenu.autosize();

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
	public void uitLoggen(ActionEvent actionEvent) {
		Platform.exit();
	}

	@FXML
	public void toon(ActionEvent actionEvent) {
		try {
			MenuItem gekliktItem = (MenuItem) actionEvent.getSource();
			String sender = gekliktItem.getText();
			FXMLLoader loader = new FXMLLoader();
			switch (sender) {
			case "Pathologieen":
				loader.setLocation(MainApp.class
						.getResource("view/PathologieOverzicht.fxml"));
				break;
			case "Vragen":
				loader.setLocation(MainApp.class
						.getResource("view/VragenOverzicht.fxml"));
				break;
			case "Vragenlijsten":
				loader.setLocation(MainApp.class
						.getResource("view/VragenlijstOverzicht.fxml"));
				break;
			case "Relaties":
				loader.setLocation(MainApp.class
						.getResource("view/RelatieOverzicht.fxml"));
				break;
			case "Aandoeningen":
				loader.setLocation(MainApp.class
						.getResource("view/AandoeningenLayout.fxml"));
				break;
			case "LeeftijdsCategorieen":
				loader.setLocation(MainApp.class
						.getResource("view/LftdsCatOverzicht.fxml"));
				break;
			case "Accounts":
				loader.setLocation(MainApp.class
						.getResource("view/AccountsLayout.fxml"));
				break;
			default:
				break;
			}
			// loader.setLocation(MainApp.class.getResource("view/VragenOverzicht.fxml"));
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
