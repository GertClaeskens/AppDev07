package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.Pathologie;
import finah_desktop_fx.model.Vraag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class VragenOverzichtController implements Initializable {
	@FXML
	private TextField txtVraag;
	@FXML
	private ChoiceBox<Aandoening> cboAandoening;
	@FXML
	private ChoiceBox<Vraag> cboVraag;
	@FXML
	private Button btnToevoegen;
	@FXML
	private TableView<Vraag> tblVragen;
	@FXML
	private TableColumn<Vraag, Integer> colId;
	@FXML
	private TableColumn<Vraag, String> colOmschrijving;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
		ObservableList<Aandoening> cboList = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<Vraag> tblList = FXCollections.observableList(VraagDAO.GetVragen());
        tblVragen.setItems(tblList);
        System.out.println(tblList.get(0));
        cboAandoening.setItems(cboList);
        cboAandoening.setValue(cboList.get(0));
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<>("Vraagstelling"));

	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
//        ObservableList<Aandoening> cboList = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
//        ObservableList<Vraag> tblList = FXCollections.observableList(VraagDAO.GetVragen());
//        tblVragen.setItems(tblList);;        
//        cboAandoening.setItems(cboList);
        // Add observable list data to the table
        //personTable.setItems(mainApp.getPersonData());
    }
}
