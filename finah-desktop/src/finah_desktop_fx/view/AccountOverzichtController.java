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
import finah_desktop_fx.dao.AccountDAO;
import finah_desktop_fx.dao.RelatieDAO;
import finah_desktop_fx.dao.SharedDAO;
import finah_desktop_fx.dao.ThemaDAO;
import finah_desktop_fx.model.Account;
import finah_desktop_fx.model.Relatie;
import finah_desktop_fx.model.Thema;

public class AccountOverzichtController implements Initializable{
	@FXML
	private Button btnToevoegen;
	@FXML
	private TableView<Account> tblAccAanvragen;
	@FXML
	private TableColumn<Account,String> colGebruikers;
	@FXML
	private TableColumn<Account,Boolean> colActies;
	@FXML
	private TableView<Account> tblBestaandeAcc;
	@FXML 
	private TableColumn<Account,String> colGebruikers2;
	@FXML
	private TableColumn<Account,Boolean> colActies2;
	private MainApp mainApp;

	public void initialize(URL location, ResourceBundle resources) {
	        // Initialize the person table with the two columns.
			ObservableList<Account> tblList = FXCollections.observableList(AccountDAO.GetAccounts());
			tblBestaandeAcc.setItems(tblList);
	        colGebruikers.setCellValueFactory(new PropertyValueFactory<>("Naam"));
			// define a simple boolean cell value for the action column so that the column will only be shown for non-empty rows.
			colActies.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, Boolean>, ObservableValue<Boolean>>() {
						@Override
						public ObservableValue<Boolean> call(
								TableColumn.CellDataFeatures<Account, Boolean> features) {
							return new SimpleBooleanProperty(
									features.getValue() != null);
						}
					});

			// create a cell value factory with an add button for each row in the table.
			colActies.setCellFactory(new Callback<TableColumn<Account, Boolean>, TableCell<Account, Boolean>>() {
						@Override
						public TableCell<Account, Boolean> call(
								TableColumn<Account, Boolean> relBooleanTableColumn) {
							return new AddButtonsCell(tblBestaandeAcc,"Edit","Delete","Details");
						}
					});
			}
	    
		public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;
	    }
	

	public void accountToevoegen(){
		
	}
}
