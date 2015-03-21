package finah_desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BeheerGUIGert extends JFrame {

	private TopPanel panel;
	private JButton titel;
	private JLabel tekst;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologieënKnop;
	private JButton accountsKnop;

	public BeheerGUIGert() {
		GridLayout gl = new GridLayout(2,1);
		FlowLayout fl = new FlowLayout();
		BorderLayout bl = new BorderLayout();
		this.setLayout(gl);
		panel = new TopPanel();
		panel.setSize(200,600);
		add(panel, BorderLayout.NORTH);

		DataGrid dg;// = new DataGrid();
		try {
			dg = new DataGrid(HaalPostcodeGegevensUitDB(),
					Postcode.getKolommen());
			dg.setBounds(0, panel.getHeight(), this.getWidth(),
					(this.getHeight() - panel.getHeight()));
			add(dg.getTableHeader(),BorderLayout.CENTER);
			add(new JScrollPane(dg), BorderLayout.SOUTH);
			
			dg.setVisible(true);
			// add(dg);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//setBackground(new Color(188, 188, 188));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		//this.pack();
	}

	private List<Object[]> HaalVraagGegevensUitDB()
			throws ClientProtocolException, IOException {
		Gson gson = new GsonBuilder().serializeNulls().create();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://localhost:1695/Vragen/Overzicht");
		// HttpGet request = new
		// HttpGet("http://finahbackend1920.azurewebsites.net/Postcode/Overzicht");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		java.lang.reflect.Type collectionType = new TypeToken<Collection<Vraag>>() {
		}.getType();
		Collection<Vraag> vragen = gson.fromJson(rd, collectionType);
		List<Object[]> values = new ArrayList<Object[]>();
		for (Vraag v : vragen) {
			values.add(new Object[] { v.getId(), v.getVraagstelling(),
					v.getAfbeelding(), v.getGeluidsfragment() });
		}
		return values;
	}

	private List<Object[]> HaalPostcodeGegevensUitDB()
			throws ClientProtocolException, IOException {
		Gson gson = new GsonBuilder().serializeNulls().create();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:1695/Postcode/Overzicht");
		// HttpGet request = new
		// HttpGet("http://finahbackend1920.azurewebsites.net/Postcode/Overzicht");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		java.lang.reflect.Type collectionType = new TypeToken<Collection<Postcode>>() {
		}.getType();
		Collection<Postcode> vragen = gson.fromJson(rd, collectionType);
		List<Object[]> values = new ArrayList<Object[]>();
		for (Postcode v : vragen) {
			values.add(new Object[] { v.getId(), v.getPostnr(), v.getGemeente() });
		}
		return values;

	}

	private class TopPanel extends JPanel {
		public TopPanel() {
			setLayout(null);
			setSize(200, 600);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g;

			g2d.setPaint(new GradientPaint(0, 0, new Color(2, 154, 204), 0, 75,
					new Color(102, 204, 204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);

			titel = new JButton("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(0, 0, 220, 75);
			titel.setOpaque(false);
			titel.setContentAreaFilled(false);
			titel.setBorderPainted(false);

			vragenKnop = new JButton("Vragen");
			vragenKnop.setBounds(255, 25, 120, 25);

			vragenlijstenKnop = new JButton("Vragenlijsten");
			vragenlijstenKnop.setBounds(400, 25, 120, 25);

			aandoeningenKnop = new JButton("Aandoeningen");
			aandoeningenKnop.setBounds(545, 25, 120, 25);

			pathologieënKnop = new JButton("Pathologieën");
			pathologieënKnop.setBounds(690, 25, 120, 25);

			accountsKnop = new JButton("Accounts");
			accountsKnop.setBounds(835, 25, 120, 25);

			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologieënKnop);
			add(accountsKnop);

		}

	}

	public static void main(String[] args) {
		BeheerGUIGert test = new BeheerGUIGert();
	}

}
