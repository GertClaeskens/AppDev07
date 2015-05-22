package finah_desktop_fx.view;

import javax.swing.JOptionPane;

public class DeleteDialog<T> {

	void showDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want delete this item?","Delete item",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			//delete item
		}
		else{
			//venster sluit gewoon af
		}
	}
}
