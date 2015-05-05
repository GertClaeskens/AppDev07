package finah_desktop_fx.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import finah_desktop_fx.MainApp;
import finah_desktop_fx.dao.*;
import finah_desktop_fx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;

public class NieuweBevragingController implements Initializable{
@FXML
ChoiceBox<Relatie> cboRelatie;
@FXML
ChoiceBox<Pathologie> cboPathologie;
@FXML
ChoiceBox<Aandoening> cboAandoening;
@FXML
ChoiceBox<LeeftijdsCategorie> cboLftdPat;
@FXML
ChoiceBox<LeeftijdsCategorie> cboLftdMan;
private MainApp mainApp;


	public NieuweBevragingController() {
	
}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Aandoening> aandoeningen = AandoeningDAO.GetAandoeningen();
        ArrayList<Pathologie> pathologieen = new ArrayList<>();

        	for (int j=0;j<aandoeningen.get(0).getBijhorende_pathologie().size();j++){
        		pathologieen.add(aandoeningen.get(0).getBijhorende_pathologie().get(j));
        	}
        
		ObservableList<Aandoening> aandoeningenLijst = FXCollections.observableList(AandoeningDAO.GetAandoeningen());
		//ObservableList<Pathologie> pathologieenLijst = FXCollections.observableList(PathologieDAO.GetPathologieen());
		ObservableList<Pathologie> pathologieenLijst = FXCollections.observableList(pathologieen);
		ObservableList<Relatie> relatieLijst = FXCollections.observableList(RelatieDAO.GetRelaties());
		ObservableList<LeeftijdsCategorie> leeftijdscategorieLijst = FXCollections.observableList(LeeftijdsCategorieDAO.GetLeeftijdsCategorieen());
        
        cboPathologie.setItems(pathologieenLijst);
        cboPathologie.setValue(pathologieenLijst.get(0));
        cboAandoening.setItems(aandoeningenLijst);
        cboAandoening.setValue(aandoeningenLijst.get(0));
        cboLftdMan.setItems(leeftijdscategorieLijst);
        cboLftdMan.setValue(leeftijdscategorieLijst.get(0));
        cboLftdPat.setItems(leeftijdscategorieLijst);
        cboLftdPat.setValue(leeftijdscategorieLijst.get(0));
        cboRelatie.setItems(relatieLijst);
        cboRelatie.setValue(relatieLijst.get(0));
		
	}
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //personTable.setItems(mainApp.getPersonData());
    }
}
