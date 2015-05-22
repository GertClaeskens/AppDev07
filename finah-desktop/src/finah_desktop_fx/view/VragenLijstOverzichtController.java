package finah_desktop_fx.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.SharedDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.dao.VragenLijstDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.LeeftijdsCategorie;
import finah_desktop_fx.model.Vraag;
import finah_desktop_fx.model.VragenLijst;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
	@FXML
	private TableColumn<VragenLijst,Boolean> colActie;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
		//ObservableList<Aandoening> cboList = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<VragenLijst> tblList = FXCollections.observableList(VragenLijstDAO.GetVragenLijsten());
        tblVragenlijst.setItems(tblList);
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<>("Omschrijving"));
        colAandoening.setCellValueFactory(new PropertyValueFactory<>("Aandoe"));
        colAantal.setCellValueFactory(new PropertyValueFactory<>("AantalVragen"));

		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		colActie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VragenLijst, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(
							TableColumn.CellDataFeatures<VragenLijst, Boolean> features) {
						return new SimpleBooleanProperty(
								features.getValue() != null);
					}
				});

		// create a cell value factory with an add button for each row in the
		// table.
		colActie.setCellFactory(new Callback<TableColumn<VragenLijst, Boolean>, TableCell<VragenLijst, Boolean>>() {
					@Override
					public TableCell<VragenLijst, Boolean> call(
							TableColumn<VragenLijst, Boolean> vrgLijstBooleanTableColumn) {
						return new AddButtonsCell(tblVragenlijst,"Edit","Delete","Details");
					}
				});
		btnToevoegen.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
	          public void handle(MouseEvent arg0) {
	             
	        	  try {
	        		  VragenLijst vragenLijst = new VragenLijst();
	        		  vragenLijst.setOmschrijving(txtVragenLijst.getText());
	        		  vragenLijst.setId(VragenLijstDAO.GetVragenLijsten().size()+1);
	        		  SharedDAO.PostObject("http://finahbackend1920.azurewebsites.net/VragenLijst/", vragenLijst);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
		});
	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
