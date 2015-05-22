package finah_desktop_fx.view;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import javax.swing.JOptionPane;

import finah_desktop_fx.dao.AandoeningDAO;
import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.dao.ThemaDAO;

public class DeleteDialog<T> {

	void showDialog(final TableView<T> table, double y) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want delete this item?","Delete item",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			int index = table.getFocusModel().getFocusedIndex();
			switch(table.getId()){
			case "tblVragen":{
				
				break;
				}
			case "tblVragenlijst":{
				
				break;
				}
			case "tblAandoening":{
				
				break;
				}
			case "tblPathologie":{
				
				break;
				}
			case "tblLftdsCat":{
				
				break;
				}
			case "tblRelatie":{
				
				break;
				}
			case "tblThema":{
				
				break;
				}
			}
		}
		else{
			//venster sluit gewoon af
		}
	}
}
