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

public class AddVraagCell extends TableCell<Vraag, Boolean> {
    // a button for adding a new person.
    final Button btnEdit       = new Button("Edit");
    final Button btnDel       = new Button("Delete");
    final Button btnDetails       = new Button("Details");
    // pads and centers the add button in the cell.
    final StackPane paddedButton = new StackPane();
    // records the y pos of the last button press so that the add person dialog can be shown next to the cell.
    final DoubleProperty buttonY = new SimpleDoubleProperty();

    /**
     * AddPersonCell constructor
     * @param stage the stage in which the table is placed.
     * @param table the table to which a new person can be added.
     */
    AddVraagCell(final TableView table,String naam) {
    	final Button btn = new Button(naam);
      paddedButton.setPadding(new Insets(3));
      paddedButton.getChildren().add(btn);
      btn.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent mouseEvent) {
          buttonY.set(mouseEvent.getScreenY());
        }
      });
      btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent actionEvent) {
          showAddVraagDialog(table, buttonY.get());
          table.getSelectionModel().select(getTableRow().getIndex());
        }
      });

    }

    /** places an add button in the row only if the row is not empty. */
    @Override protected void updateItem(Boolean item, boolean empty) {
      super.updateItem(item, empty);
      if (!empty) {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setGraphic(paddedButton);
      }
    }
  

  /**
   * shows a dialog which displays a UI for adding a person to a table.
   * @param parent a parent stage to which this dialog will be modal and placed next to.
   * @param table the table to which a person is to be added.
   * @param y the y position of the top left corner of the dialog.
   */
  private void showAddVraagDialog(final TableView<Vraag> table, double y) {
    // initialize the dialog.
    final Stage dialog = new Stage();
    dialog.setTitle("New Person");
    //dialog.initOwner(parent);
    dialog.initModality(Modality.WINDOW_MODAL);
    dialog.initStyle(StageStyle.UTILITY);
    dialog.setX(1000);
    dialog.setY(y);

    // create a grid for the data entry.
    GridPane grid = new GridPane();
    final TextField txtVraagStelling = new TextField();
    //final TextField lastNameField = new TextField();
    grid.addRow(0, new Label("Vraagstelling"), txtVraagStelling);
    //grid.addRow(1, new Label("Last Name"), lastNameField);
    grid.setHgap(10);
    grid.setVgap(10);
    GridPane.setHgrow(txtVraagStelling, Priority.ALWAYS);
    //GridPane.setHgrow(lastNameField, Priority.ALWAYS);

    // create action buttons for the dialog.
    Button ok = new Button("OK");
    ok.setDefaultButton(true);
    Button cancel = new Button("Cancel");
    cancel.setCancelButton(true);

    // only enable the ok button when there has been some text entered.
    ok.disableProperty().bind(txtVraagStelling.textProperty().isEqualTo(""));//.or(lastNameField.textProperty().isEqualTo("")));

    // add action handlers for the dialog buttons.
    ok.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent actionEvent) {
        int nextIndex = table.getSelectionModel().getSelectedIndex() + 1;
        table.getItems().add(nextIndex, new Vraag(txtVraagStelling.getText()));//, lastNameField.getText()));
        table.getSelectionModel().select(nextIndex);
        dialog.close();
      }
    });
    cancel.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent actionEvent) {
        dialog.close();
      }
    });

    // layout the dialog.
    HBox buttons = HBoxBuilder.create().spacing(10).children(ok, cancel).alignment(Pos.CENTER_RIGHT).build();
    VBox layout = new VBox(10);
    layout.getChildren().addAll(grid, buttons);
    layout.setPadding(new Insets(5));
    layout.autosize();
    dialog.setScene(new Scene(layout));
    dialog.show();
  }

}
