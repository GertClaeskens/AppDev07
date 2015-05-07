package finah_desktop_fx.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import finah_desktop_fx.MainApp;

public class RootController implements Initializable {

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
	private MenuItem MnuBeheerThemas;
	@FXML
	private Button btnResultaten;

	@FXML
	private ImageView ivAvatar;
	@FXML
	private Button btnUitloggen;
	@FXML
	private BorderPane contentArea;

	public RootController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// private void initialize() {

		rootLayout.setAlignment(bbTopMenu, Pos.CENTER_LEFT);
		Rectangle clip = new Rectangle(ivAvatar.getFitWidth(),
				ivAvatar.getFitHeight());
		clip.setArcWidth(ivAvatar.getFitWidth());
		clip.setArcHeight(ivAvatar.getFitHeight());
		ivAvatar.setClip(clip);

		// snapshot the rounded image.
		SnapshotParameters parameters = new SnapshotParameters();
		parameters.setFill(Color.TRANSPARENT);
		WritableImage image = ivAvatar.snapshot(parameters, null);

		// remove the rounding clip so that our effect can show through.
		ivAvatar.setClip(null);

		// store the rounded image in the imageView.
		ivAvatar.setImage(image);
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
	public void toonAccount(ActionEvent actionEvent) {
		Button gekliktItem = (Button) actionEvent.getSource();
		String sender = gekliktItem.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class
				.getResource("view/AccountAanpassenLayout.fxml"));
		AnchorPane accountLayout = null;
		try {
			accountLayout = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rootLayout.setCenter(accountLayout);
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
			case "Thema's":
				loader.setLocation(MainApp.class
						.getResource("view/ThemaOverzicht.fxml"));
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
