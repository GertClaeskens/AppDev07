package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.LeeftijdsCategorieDAO;
import finah_desktop_fx.dao.RelatieDAO;
import finah_desktop_fx.model.LeeftijdsCategorie;
import finah_desktop_fx.model.Relatie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelatieOverzichtController implements Initializable{
	@FXML
	private TextField txtRelatie;
	@FXML
	private Button btnToevoegen;
	@FXML
	private TableView<Relatie> tblRelatie;
	@FXML
	private TableColumn<Relatie,Integer> colId;
	@FXML
	private TableColumn<Relatie,String> colNaam;
	private MainApp mainApp;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
		ObservableList<Relatie> tblList = FXCollections.observableList(RelatieDAO.GetRelaties());
        tblRelatie.setItems(tblList);
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNaam.setCellValueFactory(new PropertyValueFactory<>("Naam"));

	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;}
}
