package finah_desktop_fx.view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.JComboBox;

import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.dao.ThemaDAO;
import finah_desktop_fx.model.Vraag;

public class EditDialog<T> {
	
	/**
	 * shows a dialog which displays a UI for adding a person to a table.
	 * 
	 * @param parent
	 *            a parent stage to which this dialog will be modal and placed
	 *            next to.
	 * @param table
	 *            the table to which a person is to be added.
	 * @param y
	 *            the y position of the top left corner of the dialog.
	 */
	
	
	void showDialog(final TableView<T> table, double y) {
		// initialize the dialog.
		final Stage dialog = new Stage();
		dialog.setTitle(table.getId());
		// dialog.initOwner(parent);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initStyle(StageStyle.UTILITY);
		dialog.setX(800);
		dialog.setY(y);

		// create a grid for the data entry.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		final TextField inhoudField = new TextField();
		// GridPane.setHgrow(txtVraagStelling, Priority.ALWAYS);
		// GridPane.setHgrow(lastNameField, Priority.ALWAYS);
		
		switch(table.getId()){
		case "tblVragen":{
			grid.addRow(0, new Label("Vraag:"), inhoudField);
			final ComboBox aandoeningCombo = new ComboBox(FXCollections
					.observableList(AandoeningDAO.GetAandoeningen()));
			grid.addRow(1, new Label("Aandoening:"), aandoeningCombo);
			GridPane.setHgrow(aandoeningCombo, Priority.ALWAYS);
			final ComboBox themaCombo = new ComboBox(FXCollections
					.observableList(ThemaDAO.GetThemas()));
			grid.addRow(2, new Label("Thema:"), themaCombo);
			break;
			}
		case "tblVragenlijst":{
			grid.addRow(0, new Label("Naam vragenlijst:"), inhoudField);
			final ComboBox aandoeningCombo = new ComboBox(FXCollections
					.observableList(AandoeningDAO.GetAandoeningen()));
			grid.addRow(1, new Label("Aandoening:"), aandoeningCombo);
			break;
			}
		case "tblAandoening":{
			grid.addRow(0, new Label("Aandoening:"), inhoudField);
			final ComboBox pathologieCombo = new ComboBox(FXCollections
					.observableList(PathologieDAO.GetPathologieen()));
			grid.addRow(1, new Label("Pathologie:"), pathologieCombo);
			break;
			}
		case "tblPathologie":{
			grid.addRow(0, new Label("Pathologie:"), inhoudField);
			final ComboBox aandoeningCombo = new ComboBox(FXCollections
					.observableList(AandoeningDAO.GetAandoeningen()));
			grid.addRow(1, new Label("Aandoening:"), aandoeningCombo);
			break;
			}
		case "tblLftdsCat":{
			grid.addRow(0, new Label("Van:"), inhoudField);
			final TextField totField = new TextField();
			grid.addRow(1, new Label("Tot:"), totField);
			break;
			}
		case "tblRelatie":{
			grid.addRow(0, new Label("Relatie:"), inhoudField);
			break;
			}
		case "tblThema":{
			grid.addRow(0, new Label("Thema"), inhoudField);
			break;
			}
		}
		
		
		
		
		
		// create action buttons for the dialog.
		Button ok = new Button("OK");
		ok.setDefaultButton(true);
		Button cancel = new Button("Cancel");
		cancel.setCancelButton(true);

		// only enable the ok button when there has been some text entered.
		ok.disableProperty()
				.bind(inhoudField.textProperty().isEqualTo(""));// .or(lastNameField.textProperty().isEqualTo("")));

		// add action handlers for the dialog buttons.
		ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				int nextIndex = table.getSelectionModel().getSelectedIndex() + 1;
				table.getItems().add(nextIndex,
						(T) new Vraag(inhoudField.getText()));
				table.getSelectionModel().select(nextIndex);
				dialog.close();
			}
		});
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				dialog.close();
			}
		});

		// layout the dialog.
		HBox buttons = HBoxBuilder.create().spacing(10).children(ok, cancel)
				.alignment(Pos.CENTER_RIGHT).build();
		VBox layout = new VBox(10);
		layout.getChildren().addAll(grid, buttons);
		layout.setPadding(new Insets(5));
		layout.autosize();
		dialog.setScene(new Scene(layout));
		dialog.show();
	}

}
