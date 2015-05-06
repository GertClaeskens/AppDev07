package finah_desktop_fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.model.Aandoening;
import finah_desktop_fx.model.Vraag;

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
	@FXML
	private TableColumn<Vraag, Boolean> colEdit;
	@FXML
	private TableColumn<Vraag, Boolean> colDel;
	@FXML
	private TableColumn<Vraag, Boolean> colDetails;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// public void initialize(){
		// Initialize the person table with the two columns.
		ObservableList<Aandoening> cboList = FXCollections
				.observableList(AandoeningDAO.GetAandoeningen());
		ObservableList<Vraag> tblList = FXCollections.observableList(VraagDAO
				.GetVragen());
		tblVragen.setItems(tblList);
		cboAandoening.setItems(cboList);
		cboAandoening.setValue(cboList.get(0));
		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colOmschrijving.setCellValueFactory(new PropertyValueFactory<>(
				"Vraagstelling"));
		colEdit.setSortable(false);
		colDel.setSortable(false);
		colDetails.setSortable(false);
		final Button btnEdit       = new Button("Edit");
	    final Button btnDel       = new Button("Delete");
	    final Button btnDetails       = new Button("Details");
		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		colEdit
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
		colEdit
				.setCellFactory(new Callback<TableColumn<Vraag, Boolean>, TableCell<Vraag, Boolean>>() {
					@Override
					public TableCell<Vraag, Boolean> call(
							TableColumn<Vraag, Boolean> personBooleanTableColumn) {
						return new AddVraagCell(tblVragen,"Edit");
					}
				});		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		colDel
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
		colDel
				.setCellFactory(new Callback<TableColumn<Vraag, Boolean>, TableCell<Vraag, Boolean>>() {
					@Override
					public TableCell<Vraag, Boolean> call(
							TableColumn<Vraag, Boolean> personBooleanTableColumn) {
						return new AddVraagCell(tblVragen,"Delete");
					}
				});		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		colDetails
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
		colDetails
				.setCellFactory(new Callback<TableColumn<Vraag, Boolean>, TableCell<Vraag, Boolean>>() {
					@Override
					public TableCell<Vraag, Boolean> call(
							TableColumn<Vraag, Boolean> personBooleanTableColumn) {
						return new AddVraagCell(tblVragen,"Details");
					}
				});

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
