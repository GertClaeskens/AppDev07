package finah_desktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AandoeningenGUI extends JFrame{
	
	private AandoeningenPanel panel;
	private JButton titel;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologieŽnKnop;
	private JButton accountsKnop;
	private JButton toevoegKnop;
	private JButton aanpasKnop;
	private JLabel toevoegenLabel;
	private JLabel overzichtLabel;
	private JTextField nieuweAandoeningVeld;
	private JComboBox nieuweAandoeningVragenlijstCombo;
	private JComboBox nieuweAandoeningPathologieCombo;
	private List<Aandoening> aandoeningen;

	public AandoeningenGUI(){
		aandoeningen = new ArrayList<Aandoening>();
		//aandoeningen = AandoeningDAO.GetAandoeningen();
		
		for(int i=1; i<=10; i++){
			aandoeningen.add(new Aandoening());
		}
		
		
		panel = new AandoeningenPanel();		
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class AandoeningenPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setColor(Color.black);
			g2d.drawLine(220, 0, 220, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			
			//Dynamische tabel
			g2d.setPaint(Color.white);
			g2d.fillRect(100, 230, 800, 40);
			g2d.fillRect(100, 270, 800, 30*aandoeningen.size());
			
			g2d.setPaint(Color.black);
			g2d.drawRect(100, 230, 800, 40);
			g2d.drawRect(100, 270, 800, 30*aandoeningen.size());
			g2d.drawLine(670, 230, 670, 270+30*aandoeningen.size());
			g2d.drawLine(700, 230, 700, 270+30*aandoeningen.size());
			
			g2d.setFont(new Font("Arial", Font.BOLD, 17));
			g2d.drawString("Aandoeningen", 315, 255);
			g2d.drawString("Vragenlijst", 760, 255);
			g2d.setFont(new Font("Arial", Font.PLAIN, 15));
			int hoogte = 300;
			for(int i=0; i<aandoeningen.size(); i++){
				Aandoening ad = aandoeningen.get(i);
				g2d.drawLine(100, hoogte, 900, hoogte);
				g2d.drawString(" ", 120, hoogte-10);//ad.getOmschrijving()
				//TODO Combobox verwijderen en der de naam van de pathologieen zetten
				JComboBox vragenlijstCombo = new JComboBox();
				vragenlijstCombo.setBounds(702,hoogte-28,197,27);
				add(vragenlijstCombo);
				hoogte+=30;
			}
			
			titel = new JButton("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(0, 0, 220, 75);
			titel.setOpaque(false);
			titel.setContentAreaFilled(false);
			titel.setBorderPainted(false);
			
			vragenKnop = new JButton("Vragen");
			vragenKnop.setBounds(255, 25, 120, 30);
			
			vragenlijstenKnop = new JButton("Vragenlijsten");
			vragenlijstenKnop.setBounds(400, 25, 120, 30);
			
			aandoeningenKnop = new JButton("Aandoeningen");
			aandoeningenKnop.setBounds(545, 25, 120, 30);
			
			pathologieŽnKnop = new JButton("PathologieŽn");
			pathologieŽnKnop.setBounds(690, 25, 120, 30);
			
			accountsKnop = new JButton("Accounts");
			accountsKnop.setBounds(835, 25, 120, 30);
			
			toevoegenLabel = new JLabel("Aandoening toevoegen");
			toevoegenLabel.setFont(new Font("Default", Font.BOLD, 17));
			toevoegenLabel.setBounds(100, 100, 190, 20);
			overzichtLabel = new JLabel("Overzicht aandoeningen");
			overzichtLabel.setFont(new Font("Default", Font.BOLD, 17));
			overzichtLabel.setBounds(100, 200, 200, 20);
			
			nieuweAandoeningVeld = new JTextField();
			nieuweAandoeningVeld.setBounds(100, 130, 490, 25);
			nieuweAandoeningVragenlijstCombo = new JComboBox();
			nieuweAandoeningVragenlijstCombo.setBounds(600, 130, 190, 25);
			nieuweAandoeningPathologieCombo = new JComboBox();
			nieuweAandoeningPathologieCombo.setBounds(600, 160, 190, 25);
			
			toevoegKnop = new JButton("Toevoegen");
			toevoegKnop.setBounds(800, 130, 100, 25);
			
			aanpasKnop = new JButton("Aandoeningen aanpassen");
			aanpasKnop.setBounds(710, 200, 190, 25);
			
			ButtonHandler handler = new ButtonHandler();
			titel.addActionListener(handler);
			vragenKnop.addActionListener(handler);
			vragenlijstenKnop.addActionListener(handler);
			pathologieŽnKnop.addActionListener(handler);
			accountsKnop.addActionListener(handler);
			aanpasKnop.addActionListener(handler);
			
			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologieŽnKnop);
			add(accountsKnop);
			add(toevoegenLabel);
			add(overzichtLabel);
			add(nieuweAandoeningVeld);
			add(nieuweAandoeningVragenlijstCombo);
			add(nieuweAandoeningPathologieCombo);
			add(toevoegKnop);
			add(aanpasKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "FINAH":	newFrame = new AccountGUI();
							AandoeningenGUI.this.setVisible(false);
							break;
			case "Vragen":	newFrame = new VragenGUI();
							AandoeningenGUI.this.setVisible(false);
							break;
			case "Vragenlijsten":	newFrame = new VragenlijstenGUI();
									AandoeningenGUI.this.setVisible(false);
									break;
			case "PathologieŽn":	newFrame = new PathologieŽnGUI();
									AandoeningenGUI.this.setVisible(false);
									break;
			case "Accounts":	newFrame = new AccountsOverzichtGUI();
								AandoeningenGUI.this.setVisible(false);
								break;
			case "Aandoeningen aanpassen":	newFrame = new AandoeningenAanpassenGUI();
											AandoeningenGUI.this.setVisible(false);
											break;
			}
		}	
	}
	
	public static void main(String[] args){
		AandoeningenGUI test = new AandoeningenGUI();
	}
	
}
