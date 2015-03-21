package finah_desktop_testfiles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop.Postcode;

public class TestJFrame extends JFrame {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        TestJFrame testJFrame = new TestJFrame();
		Gson gson = new GsonBuilder().serializeNulls().create();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:1695/Postcode/Overzicht");
		// HttpGet request = new HttpGet("http://finahbackend1920.azurewebsites.net/Postcode/Overzicht");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line;
		java.lang.reflect.Type collectionType = new TypeToken<Collection<Postcode>>() {}.getType();
		Collection<Postcode> pc = gson.fromJson(rd, collectionType);
        List<String> columns = new ArrayList<String>();
        List<Object[]> values = new ArrayList<Object[]>();

        columns.add("Postcode");
        columns.add("Gemeente");

        for (Postcode p: pc) {
            values.add(new Object[] {p.getPostnr(),p.getGemeente()});
        }

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        JTable table = new JTable(tableModel);
        
        try {
            // 1.6+
            table.setAutoCreateRowSorter(true);
        } catch(Exception continuewithNoSort) {
        }
        JScrollPane tableScroll = new JScrollPane(table);
        Dimension tablePreferred = tableScroll.getPreferredSize();
        tableScroll.setPreferredSize(
            new Dimension(tablePreferred.width, tablePreferred.height/2) );
        testJFrame.setLayout(new BorderLayout());
        testJFrame.add(new JScrollPane(table), BorderLayout.CENTER);

        testJFrame.add(table.getTableHeader(), BorderLayout.NORTH);

        testJFrame.setVisible(true);
        testJFrame.setSize(750,500);
    }
}
