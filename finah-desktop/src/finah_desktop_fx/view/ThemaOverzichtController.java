package finah_desktop_fx.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.SharedDAO;
import finah_desktop_fx.dao.ThemaDAO;
import finah_desktop_fx.dao.VragenLijstDAO;
import finah_desktop_fx.model.Pathologie;
import finah_desktop_fx.model.Thema;
import finah_desktop_fx.model.VragenLijst;

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
	@FXML
	private TableColumn<Thema, Boolean> colActie;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initialize the person table with the two columns.
		ObservableList<Thema> tblList = FXCollections.observableList(ThemaDAO
				.GetThemas());
		tblThema.setItems(tblList);
		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colNaam.setCellValueFactory(new PropertyValueFactory<>("Naam"));

		// define a simple boolean cell value for the action column so that the column will only be shown for non-empty rows.
		colActie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Thema, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(
							TableColumn.CellDataFeatures<Thema, Boolean> features) {
						return new SimpleBooleanProperty(
								features.getValue() != null);
					}
				});

		// create a cell value factory with an add button for each row in the table.
		colActie.setCellFactory(new Callback<TableColumn<Thema, Boolean>, TableCell<Thema, Boolean>>() {
					@Override
					public TableCell<Thema, Boolean> call(
							TableColumn<Thema, Boolean> pathoBooleanTableColumn) {
						return new AddButtonsCell(tblThema,"Edit","Delete","Details");
					}
				});
		
		btnToevoegen.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
	          public void handle(MouseEvent arg0) {
	             
	        	  try {
	        		  Thema thema = new Thema();
	        		  thema.setNaam(txtThema.getText());
	        		  thema.setId(ThemaDAO.GetThemas().size()+1);
	        		  SharedDAO.PostObject("http://finahbackend1920.azurewebsites.net/Thema/", thema);
				} catch (IOException e) {
					e.printStackTrace();
				}
	          }
		});
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
