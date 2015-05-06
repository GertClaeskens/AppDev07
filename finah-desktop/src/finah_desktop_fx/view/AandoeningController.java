package finah_desktop_fx.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.Pathologie;

public class AandoeningController implements Initializable{
    @FXML
    private TableView<Aandoening> tblAandoening;
    @FXML
    private TableColumn<Aandoening, Integer> colId;
    @FXML
    private TableColumn<Aandoening, String> colAandoening;
    @FXML
    private Button btnToevoegen;
    @FXML
    private ChoiceBox<Pathologie> cboPathologie;
    @FXML
    private TextField txtAandoening;
	private MainApp mainApp;
	
	public AandoeningController(){
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
        ArrayList<Aandoening> aandoeningen = AandoeningDAO.GetAandoeningen();
        ArrayList<Pathologie> pathologieen = PathologieDAO.GetPathologieen();
        for (int i=0;i<aandoeningen.size();i++){
        	for (int j=0;j<aandoeningen.get(i).getBijhorende_pathologie().size();j++){
        		aandoeningen.get(i).getBijhorende_pathologie().get(j);
        	}
        }
		ObservableList<Aandoening> tblList = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<Pathologie> cboList = FXCollections.observableList(PathologieDAO.GetPathologieen());
        tblAandoening.setItems(tblList);
        cboPathologie.setItems(cboList);
        cboPathologie.setValue(cboList.get(0));
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colAandoening.setCellValueFactory(new PropertyValueFactory<>("Omschrijving"));

	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
        //personTable.setItems(mainApp.getPersonData());
    }



}
