package finah_desktop_fx.view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import finah_desktop_fx.model.Vraag;

public class AddButtonsCell<T> extends TableCell<T, Boolean> {
	// a button for adding a new person.
	// pads and centers the add button in the cell.
	// final StackPane paddedButton = new StackPane();
	final HBox paddedButton = new HBox();
	// records the y pos of the last button press so that the add person dialog
	// can be shown next to the cell.
	final DoubleProperty buttonY = new SimpleDoubleProperty();

	/**
	 * AddPersonCell constructor
	 * 
	 * @param stage
	 *            the stage in which the table is placed.
	 * @param table
	 *            the table to which a new person can be added.
	 */
	AddButtonsCell(final TableView table, String... namen) {

		for (String naam : namen) {
			final Button btn = new Button(naam);
			paddedButton.setPadding(new Insets(3));
			paddedButton.setMargin(btn, new Insets(5));
			paddedButton.getChildren().add(btn);
			btn.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					buttonY.set(mouseEvent.getScreenY());
				}
			});
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					table.getSelectionModel().select(getTableRow().getIndex());
					if(btn.getText().equals("Edit")){
						EditDialog editDialog = new EditDialog();
						editDialog.showDialog(table, buttonY.get(), table.getSelectionModel().getSelectedIndex()+1);
					}
					else if(btn.getText().equals("Delete")){
						DeleteDialog deleteDialog = new DeleteDialog();
						deleteDialog.showDialog(table, buttonY.get());
					}
					else if(btn.getText().equals("Details")){
						DetailsDialog detailsDialog = new DetailsDialog();
						detailsDialog.showDialog(table, buttonY.get(), table.getSelectionModel().getSelectedIndex()+1);
					}
				}
			});
		}
	}

	/** places an add button in the row only if the row is not empty. */
	@Override
	protected void updateItem(Boolean item, boolean empty) {
		super.updateItem(item, empty);
		if (!empty) {
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			setGraphic(paddedButton);
		}
	}

}
