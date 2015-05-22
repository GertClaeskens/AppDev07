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
import finah_desktop_fx.dao.LeeftijdsCategorieDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.dao.RelatieDAO;
import finah_desktop_fx.dao.ThemaDAO;
import finah_desktop_fx.dao.VraagDAO;
import finah_desktop_fx.dao.VragenLijstDAO;
import finah_desktop_fx.model.Vraag;

public class DetailsDialog<T> {

	void showDialog(final TableView<T> table, double y, int id) {
		// initialize the dialog.
		final Stage dialog = new Stage();
		// dialog.initOwner(parent);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initStyle(StageStyle.DECORATED);
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
			//dialog.setTitle("Details van vraag "+ id);
			grid.addRow(0, new Label("Vraag:"),  new Label(VraagDAO.GetVraag(id).getVraagstelling()));
			grid.addRow(1, new Label("Thema:"), new Label(VraagDAO.GetVraag(id).getThema().toString()));
			break;
			}
		case "tblVragenlijst":{
			//dialog.setTitle("Details van vragenlijst " + id);
			grid.addRow(0, new Label("Naam vragenlijst:"), new Label(VragenLijstDAO.GetVragenLijst(id).getOmschrijving()));
			grid.addRow(1, new Label("Aandoening:"), new Label(VragenLijstDAO.GetVragenLijst(id).getAandoe().getOmschrijving()));
			grid.addRow(2, new Label("Aantal vragen in de lijst:"), new Label(Integer.toString(VragenLijstDAO.GetVragenLijst(id).getAantalVragen())));
			break;
			}
		case "tblAandoening":{
			//dialog.setTitle("Details van aandoening: "+ id);
			grid.addRow(0, new Label("Aandoening:"), new Label(AandoeningDAO.GetAandoening(id).getOmschrijving()));
			grid.addRow(1, new Label("Pathologie:"), new Label(AandoeningDAO.GetAandoening(id).getBijhorende_pathologie().get(id).getOmschrijving()));
			break;
			}
		case "tblPathologie":{
			//dialog.setTitle("Details van pathologie "+ id);
			grid.addRow(0, new Label("Pathologie:"), new Label(PathologieDAO.GetPathologie(id).getOmschrijving()));
			break;
			}
		case "tblLftdsCat":{
			//dialog.setTitle("Details van leeftijdscategorie "+ id);
			grid.addRow(0, new Label("Van:"), new Label(Integer.toString(LeeftijdsCategorieDAO.GetLeeftijdsCategorie(id).getVan())));
			grid.addRow(1, new Label("Tot:"), new Label(Integer.toString(LeeftijdsCategorieDAO.GetLeeftijdsCategorie(id).getTot())));
			break;
			}
		case "tblRelatie":{
			//dialog.setTitle("Details van relatie "+ id);
			grid.addRow(0, new Label("Relatie:"), new Label(RelatieDAO.GetRelatie(id).getNaam()));
			break;
			}
		case "tblThema":{
			//dialog.setTitle("Thema aanpassen "+ id);
			grid.addRow(0, new Label("Thema"), new Label(ThemaDAO.GetThema(id).getNaam()));
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
		layout.setPadding(new Insets(20));
		
		layout.autosize();
		dialog.setScene(new Scene(layout));
		dialog.show();
	}

}
