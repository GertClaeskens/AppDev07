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

public class VragenGUI extends JFrame{
	
	private VragenPanel panel;
	private JButton titel;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologie�nKnop;
	private JButton accountsKnop;
	private JButton toevoegKnop;
	private JLabel toevoegenLabel;
	private JLabel overzichtLabel;
	private JTextField nieuweVraagVeld;
	private JComboBox nieuweVraagCombo;
	private List<Vraag> vragen;

	public VragenGUI(){
		vragen = new ArrayList<Vraag>();
		for(int i=1; i<=10; i++){
			vragen.add(new Vraag());
		}
		
		
		panel = new VragenPanel();		
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class VragenPanel extends JPanel{
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
			g2d.fillRect(100, 210, 800, 40);
			g2d.fillRect(100, 250, 800, 30*vragen.size());
			
			g2d.setPaint(Color.black);
			g2d.drawRect(100, 210, 800, 40);
			g2d.drawLine(100, 210, 100, 250+30*vragen.size());
			g2d.drawLine(900, 210, 900, 250+30*vragen.size());
			g2d.drawLine(640, 210, 640, 250+30*vragen.size());
			g2d.drawLine(670, 210, 670, 250+30*vragen.size());
			g2d.drawLine(700, 210, 700, 250+30*vragen.size());
			
			g2d.setFont(new Font("Arial", Font.BOLD, 17));
			g2d.drawString("Vragen", 335, 235);
			g2d.drawString("Vragenlijst", 760, 235);
			g2d.setFont(new Font("Arial", Font.PLAIN, 15));
			int hoogte = 280;
			for(int i=1; i<=vragen.size(); i++){
				g2d.drawLine(100, hoogte, 900, hoogte);
				g2d.drawString("Vraag "+i, 120, hoogte-10);
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
			
			pathologie�nKnop = new JButton("Pathologie�n");
			pathologie�nKnop.setBounds(690, 25, 120, 30);
			
			accountsKnop = new JButton("Accounts");
			accountsKnop.setBounds(835, 25, 120, 30);
			
			toevoegenLabel = new JLabel("Vraag toevoegen");
			toevoegenLabel.setFont(new Font("Default", Font.BOLD, 17));
			toevoegenLabel.setBounds(100, 100, 190, 20);
			overzichtLabel = new JLabel("Overzicht vragen");
			overzichtLabel.setFont(new Font("Default", Font.BOLD, 17));
			overzichtLabel.setBounds(100, 180, 190, 20);
			
			nieuweVraagVeld = new JTextField();
			nieuweVraagVeld.setBounds(100, 130, 490, 25);
			nieuweVraagCombo = new JComboBox();
			nieuweVraagCombo.setBounds(600, 130, 190, 25);
			
			toevoegKnop = new JButton("Toevoegen");
			toevoegKnop.setBounds(800, 130, 100, 25);
			
			ButtonHandler handler = new ButtonHandler();
			titel.addActionListener(handler);
			vragenlijstenKnop.addActionListener(handler);
			aandoeningenKnop.addActionListener(handler);
			pathologie�nKnop.addActionListener(handler);

			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologie�nKnop);
			add(accountsKnop);
			add(toevoegenLabel);
			add(overzichtLabel);
			add(nieuweVraagVeld);
			add(nieuweVraagCombo);
			add(toevoegKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "FINAH":	newFrame = new AccountGUI();
							VragenGUI.this.setVisible(false);
							break;
			case "Vragenlijsten":	newFrame = new VragenlijstenGUI();
									VragenGUI.this.setVisible(false);
									break;
			case "Aandoeningen":	newFrame = new AandoeningenGUI();
									VragenGUI.this.setVisible(false);
									break;
			case "Pathologie�n":	newFrame = new Pathologie�nGUI();
									VragenGUI.this.setVisible(false);
									break;
			}
		}		
	}
	
	public static void main(String[] args){
		VragenGUI test = new VragenGUI();
	}
	
}