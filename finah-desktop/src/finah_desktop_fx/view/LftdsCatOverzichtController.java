package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.LeeftijdsCategorieDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.LeeftijdsCategorie;
import finah_desktop_fx.model.Vraag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class LftdsCatOverzichtController implements Initializable{
	@FXML
	private TextField txtVan;
	@FXML
	private Button btnToevoegen;
	@FXML
	private TableView<LeeftijdsCategorie> tblLftdsCat;
	@FXML
	private TableColumn<LeeftijdsCategorie,Integer> colId;
	@FXML
	private TableColumn<LeeftijdsCategorie,Integer> colVan;
	@FXML
	private TableColumn<LeeftijdsCategorie,Integer> colTot;
	@FXML
	private TextField txtTot;
	private MainApp mainApp;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
		ObservableList<LeeftijdsCategorie> tblList = FXCollections.observableList(LeeftijdsCategorieDAO.GetLeeftijdsCategorieen());
        tblLftdsCat.setItems(tblList);
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colVan.setCellValueFactory(new PropertyValueFactory<>("Van"));
        colTot.setCellValueFactory(new PropertyValueFactory<>("Tot"));

	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;}
}
