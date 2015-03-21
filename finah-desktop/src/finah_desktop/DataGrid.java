package finah_desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

public class DataGrid extends JTable {
	public DataGrid(){
		
	}
    public DataGrid(List<Object[]> data, ArrayList<String> kolommen) throws ClientProtocolException, IOException {
        //DataGrid testJFrame = new DataGrid();
		
        List<String> columns = new ArrayList<String>();
        List<Object[]> values = new ArrayList<Object[]>();

        for (String s : kolommen){
        	columns.add(s);
        }

        TableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columns.toArray());
        setModel(tableModel);
        //TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), kolommen.toArray());
//        JTable table = new JTable(tableModel);
        
        try {
            // 1.6+
            setAutoCreateRowSorter(true);
        } catch(Exception continuewithNoSort) {
        }
        JScrollPane tableScroll = new JScrollPane(this);
        Dimension tablePreferred = tableScroll.getPreferredSize();
        tableScroll.setPreferredSize(
            new Dimension(tablePreferred.width, tablePreferred.height/3) );
        //setLayout(new BorderLayout());


        setVisible(true);
    }
}
