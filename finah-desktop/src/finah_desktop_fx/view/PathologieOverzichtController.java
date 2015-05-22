package finah_desktop_fx.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.dao.SharedDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.Pathologie;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
	@FXML
	private TableColumn<Pathologie, Boolean> colActie;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        // Initialize the person table with the two columns.
		ObservableList<Aandoening> cboList = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<Pathologie> tblList = FXCollections.observableList(PathologieDAO.GetPathologieen());
        tblPathologie.setItems(tblList);
        cboAandoening.setItems(cboList);
        cboAandoening.setValue(cboList.get(0));
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colPathologie.setCellValueFactory(new PropertyValueFactory<>("Omschrijving"));

		// define a simple boolean cell value for the action column so that the column will only be shown for non-empty rows.
		colActie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Pathologie, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(
							TableColumn.CellDataFeatures<Pathologie, Boolean> features) {
						return new SimpleBooleanProperty(
								features.getValue() != null);
					}
				});

		// create a cell value factory with an add button for each row in the table.
		colActie.setCellFactory(new Callback<TableColumn<Pathologie, Boolean>, TableCell<Pathologie, Boolean>>() {
					@Override
					public TableCell<Pathologie, Boolean> call(
							TableColumn<Pathologie, Boolean> pathoBooleanTableColumn) {
						return new AddButtonsCell(tblPathologie,"Edit","Delete","Details");
					}
				});
		
		btnToevoegen.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
	          public void handle(MouseEvent arg0) {
	             
	        	  try {
	        		  Pathologie pathologie = new Pathologie();
	        		  pathologie.setOmschrijving(txtPathologie.getText());
	        		  pathologie.setId(PathologieDAO.GetPathologieen().size()+1);
	        		  pathologie.voegAandoeningToe(cboAandoening.getValue());
	        		  SharedDAO.PostObject("http://finahbackend1920.azurewebsites.net/Pathologie/", pathologie);
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
