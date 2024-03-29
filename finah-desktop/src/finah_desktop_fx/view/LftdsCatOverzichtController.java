package finah_desktop_fx.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.LeeftijdsCategorieDAO;
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
	private TableColumn<LeeftijdsCategorie, Boolean> colActie;
	@FXML
	private TextField txtTot;
	private MainApp mainApp;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    // Initialize the person table with the two columns.
		ObservableList<LeeftijdsCategorie> tblList = FXCollections.observableList(LeeftijdsCategorieDAO.GetLeeftijdsCategorieen());
        tblLftdsCat.setItems(tblList);
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colVan.setCellValueFactory(new PropertyValueFactory<>("Van"));
        colTot.setCellValueFactory(new PropertyValueFactory<>("Tot"));

		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		colActie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LeeftijdsCategorie, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(
							TableColumn.CellDataFeatures<LeeftijdsCategorie, Boolean> features) {
						return new SimpleBooleanProperty(
								features.getValue() != null);
					}
				});

		// create a cell value factory with an add button for each row in the
		// table.
		colActie.setCellFactory(new Callback<TableColumn<LeeftijdsCategorie, Boolean>, TableCell<LeeftijdsCategorie, Boolean>>() {
					@Override
					public TableCell<LeeftijdsCategorie, Boolean> call(
							TableColumn<LeeftijdsCategorie, Boolean> lftdCatBooleanTableColumn) {
						return new AddButtonsCell(tblLftdsCat,"Edit","Delete","Details");
					}
				});
		
		btnToevoegen.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
	          public void handle(MouseEvent arg0) {
	             
	        	  try {
	        		  LeeftijdsCategorie lftdsCat = new LeeftijdsCategorie();
	        		  lftdsCat.setVan(Integer.parseInt(txtVan.getText()));
	        		  lftdsCat.setTot(Integer.parseInt(txtTot.getText()));
	        		  lftdsCat.setId(LeeftijdsCategorieDAO.GetLeeftijdsCategorieen().size()+1);
	        		  SharedDAO.PostObject("http://finahbackend1920.azurewebsites.net/LeeftijdsCategorie/", lftdsCat);
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
