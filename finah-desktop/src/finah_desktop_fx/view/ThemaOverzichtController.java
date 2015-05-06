package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.ThemaDAO;
import finah_desktop_fx.model.Thema;

public class ThemaOverzichtController implements Initializable {
	@FXML
	private TextField txtThema;
	@FXML
	private Button btnToevoegen;
	@FXML
	private TableView<Thema> tblThema;
	@FXML
	private TableColumn<Thema, Integer> colId;
	@FXML
	private TableColumn<Thema, String> colNaam;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// public void initialize(){
		// Initialize the person table with the two columns.
		ObservableList<Thema> tblList = FXCollections.observableList(ThemaDAO
				.GetThemas());
		tblThema.setItems(tblList);
		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colNaam.setCellValueFactory(new PropertyValueFactory<>("Naam"));

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
