package finah_desktop_fx.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.LeeftijdsCategorieDAO;
import finah_desktop_fx.dao.RelatieDAO;
import finah_desktop_fx.dao.SharedDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.model.LeeftijdsCategorie;
import finah_desktop_fx.model.Relatie;
import finah_desktop_fx.model.Thema;
import finah_desktop_fx.model.Vraag;
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
	@FXML
	private TableColumn<Relatie,Boolean> colActie;
	
	private MainApp mainApp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//public void initialize(){
        // Initialize the person table with the two columns.
		ObservableList<Relatie> tblList = FXCollections.observableList(RelatieDAO.GetRelaties());
        tblRelatie.setItems(tblList);
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNaam.setCellValueFactory(new PropertyValueFactory<>("Naam"));
		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		colActie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Relatie, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(
							TableColumn.CellDataFeatures<Relatie, Boolean> features) {
						return new SimpleBooleanProperty(
								features.getValue() != null);
					}
				});

		// create a cell value factory with an add button for each row in the
		// table.
		colActie.setCellFactory(new Callback<TableColumn<Relatie, Boolean>, TableCell<Relatie, Boolean>>() {
					@Override
					public TableCell<Relatie, Boolean> call(
							TableColumn<Relatie, Boolean> relBooleanTableColumn) {
						return new AddButtonsCell(tblRelatie,"Edit","Delete","Details");
					}
				});
		
		btnToevoegen.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
	          public void handle(MouseEvent arg0) {
	             
	        	  try {
	        		  Relatie relatie = new Relatie();
	        		  relatie.setNaam(txtRelatie.getText());
	        		  relatie.setId(RelatieDAO.GetRelaties().size()+1);
	        		 SharedDAO.PostObject("http://finahbackend1920.azurewebsites.net/Relatie/", relatie);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
		});
	}
    
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;}
}
