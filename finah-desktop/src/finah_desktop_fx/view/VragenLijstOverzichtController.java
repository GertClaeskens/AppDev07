package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.dao.VragenLijstDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.Vraag;
import finah_desktop_fx.model.VragenLijst;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class VragenLijstOverzichtController implements Initializable {
	@FXML
	private TextField txtVragenLijst;
	@FXML
	private Button btnToevoegen;
	@FXML
	private Button btnToekennen;
	@FXML
	private TableView<VragenLijst> tblVragenlijst;
	@FXML
	private TableColumn<VragenLijst,Integer> colId;
	@FXML
	private TableColumn<VragenLijst,String> colOmschrijving;
	@FXML
	private TableColumn<VragenLijst,String> colAandoening;
	@FXML
	private TableColumn<VragenLijst,Integer> colAantal;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
		ObservableList<Aandoening> cboList = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<VragenLijst> tblList = FXCollections.observableList(VragenLijstDAO.GetVragenLijsten());
        tblVragenlijst.setItems(tblList);
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<>("Omschrijving"));
        colAandoening.setCellValueFactory(new PropertyValueFactory<>("Aandoe"));
        colAantal.setCellValueFactory(new PropertyValueFactory<>("AantalVragen"));

	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
