package finah_desktop_fx.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.Pathologie;
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

public class PathologieOverzichtController implements Initializable {
	@FXML
	private TextField txtPathologie;
	@FXML
	private ChoiceBox<Aandoening> cboAandoening;
	@FXML
	private Button btnToevoegen;
	@FXML
	private TableView<Pathologie> tblPathologie;
	@FXML
	private TableColumn<Pathologie, Integer> colId;
	@FXML
	private TableColumn<Pathologie, String> colPathologie;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
		ObservableList<Aandoening> cboList = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<Pathologie> tblList = FXCollections.observableList(PathologieDAO.GetPathologieen());
        tblPathologie.setItems(tblList);
        cboAandoening.setItems(cboList);
        cboAandoening.setValue(cboList.get(0));
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colPathologie.setCellValueFactory(new PropertyValueFactory<>("Omschrijving"));

	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
