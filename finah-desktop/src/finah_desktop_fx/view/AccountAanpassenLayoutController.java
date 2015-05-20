package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AccountAanpassenLayoutController implements Initializable {
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtStraat;
	@FXML
	private TextField txtPostcode;
	@FXML
	private TextField txtLand;
	@FXML
	private TextField txtNr;
	@FXML
	private TextField txtGemeente;
	@FXML
	private TextField txtVoornaam;
	@FXML
	private TextField txtAchternaam;
	@FXML
	private ImageView ivFoto;
	@FXML
	private Button btnOphalen;

	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(System.getProperty("os.name"));
	}

	@FXML
	public void haalOp(ActionEvent actionEvent) {

	
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
        //personTable.setItems(mainApp.getPersonData());
    }
	
}
