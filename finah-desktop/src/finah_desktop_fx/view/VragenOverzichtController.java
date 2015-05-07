package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.ThemaDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.Thema;
import finah_desktop_fx.model.Vraag;

public class VragenOverzichtController implements Initializable {
	@FXML
	private TextField txtVraag;
	@FXML
	private ChoiceBox<Aandoening> cboAandoening;
	@FXML
	private ChoiceBox<Thema> cboThema;
	@FXML
	private Button btnToevoegen;
	@FXML
	private TableView<Vraag> tblVragen;
	@FXML
	private TableColumn<Vraag, Integer> colId;
	@FXML
	private TableColumn<Vraag, String> colOmschrijving;
	@FXML
	private TableColumn<Vraag, String> colThema;
	@FXML
	private TableColumn<Vraag, Boolean> colActie;

	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tblVragen.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		ObservableList<Aandoening> aandoeningen = FXCollections
				.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<Thema> themas = FXCollections
				.observableList(ThemaDAO.GetThemas());
		ObservableList<Vraag> tblList = FXCollections.observableList(VraagDAO
				.GetVragen());
		tblVragen.setItems(tblList);
		cboAandoening.setItems(aandoeningen);
		cboAandoening.setValue(aandoeningen.get(0));
		cboThema.setItems(themas);
		cboThema.setValue(themas.get(0));
		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colOmschrijving.setCellValueFactory(new PropertyValueFactory<>(
				"Vraagstelling"));
		colThema.setCellValueFactory(new PropertyValueFactory<>(
				"Thema"));
				
		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		colActie
				.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vraag, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(
							TableColumn.CellDataFeatures<Vraag, Boolean> features) {
						return new SimpleBooleanProperty(
								features.getValue() != null);
					}
				});

		// create a cell value factory with an add button for each row in the
		// table.
		colActie
				.setCellFactory(new Callback<TableColumn<Vraag, Boolean>, TableCell<Vraag, Boolean>>() {
					@Override
					public TableCell<Vraag, Boolean> call(
							TableColumn<Vraag, Boolean> personBooleanTableColumn) {
						return new AddButtonsCell(tblVragen,"Edit","Delete","Details");
					}
				});	
		tblVragen.autosize();
	}

	@FXML
	private void handleDeletePerson() {
		int selectedIndex = tblVragen.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			tblVragen.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Niets geselecteerd");
			alert.setHeaderText("U heeft geen vraag geselecteerd");
			alert.setContentText("Gelieve een vraag te selecteren");

			alert.showAndWait();
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}