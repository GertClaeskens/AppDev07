package finah_desktop_fx.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.dao.ThemaDAO;
import finah_desktop_fx.model.Vraag;

public class DetailsDialog<T> {

	void showDialog(final TableView<T> table, double y, int id) {
		// initialize the dialog.
		final Stage dialog = new Stage();
		// dialog.initOwner(parent);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initStyle(StageStyle.UTILITY);
		dialog.setX(800);
		dialog.setY(y);

		// create a grid for the data entry.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		//final Label inhoudField = new Label("Vraag uit DB ophalen");
		// GridPane.setHgrow(txtVraagStelling, Priority.ALWAYS);
		// GridPane.setHgrow(lastNameField, Priority.ALWAYS);
		int index = table.getFocusModel().getFocusedIndex();
		switch(table.getId()){
		case "tblVragen":{
			dialog.setTitle("Details van vraag "+ id);
			grid.addRow(0, new Label("Vraag:"), new Label("Vraag uit DB ophalen"));
			grid.addRow(1, new Label("Aandoening:"), new Label("Eventueel bijhorende aandoening uit DB ophalen"));
			grid.addRow(2, new Label("Thema:"), new Label("Thema uit DB ophalen"));
			break;
			}
		case "tblVragenlijst":{
			dialog.setTitle("Details van vragenlijst " + id);
			grid.addRow(0, new Label("Naam vragenlijst:"), new Label("Naam vd vragenlijst uit DB ophalen"));
			grid.addRow(1, new Label("Aandoening:"), new Label("Aandoening uit DB ophalen"));
			grid.addRow(2, new Label("Aantal vragen in de lijst:"), new Label("Aantal vragen vd lijst uit DB ophalen"));
			break;
			}
		case "tblAandoening":{
			dialog.setTitle("Details van aandoening: "+ id);
			grid.addRow(0, new Label("Aandoening:"), new Label("Naam vd aandoening uit DB ophalen"));
			grid.addRow(1, new Label("Pathologie:"), new Label("eventueel naam vd bijhorende pathologie uit DB ophalen"));
			break;
			}
		case "tblPathologie":{
			dialog.setTitle("Details van pathologie "+ id);
			grid.addRow(0, new Label("Pathologie:"), new Label("Naam vd pathologie uit DB ophalen"));
			grid.addRow(1, new Label("Aandoening:"), new Label("eventueel naam vd bijhorende aandoening uit DB ophalen"));
			break;
			}
		case "tblLftdsCat":{
			dialog.setTitle("Details van leeftijdscategorie "+ id);
			grid.addRow(0, new Label("Van:"), new Label("start lftdscat uit DB ophalen"));
			grid.addRow(1, new Label("Tot:"), new Label("einde lftdscat uit DB ophalen"));
			break;
			}
		case "tblRelatie":{
			dialog.setTitle("Details van relatie "+ id);
			grid.addRow(0, new Label("Relatie:"), new Label("relatie uit DB ophalen"));
			break;
			}
		case "tblThema":{
			dialog.setTitle("Thema aanpassen "+ id);
			grid.addRow(0, new Label("Thema"), new Label("Thema uit DB ophalen"));
			break;
			}
		}
		
		
		// create action buttons for the dialog.
		Button ok = new Button("OK");
		ok.setDefaultButton(true);

		ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				dialog.close();
			}
		});

		// layout the dialog.
		HBox buttons = HBoxBuilder.create().spacing(10).children(ok)
				.alignment(Pos.CENTER_RIGHT).build();
		VBox layout = new VBox(10);
		layout.getChildren().addAll(grid, buttons);
		layout.setPadding(new Insets(5));
		layout.autosize();
		dialog.setScene(new Scene(layout));
		dialog.show();
	}

}
