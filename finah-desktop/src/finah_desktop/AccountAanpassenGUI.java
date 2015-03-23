package finah_desktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountAanpassenGUI extends JFrame{
	
	private BeheerPanel panel;
	private JButton titel;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologieënKnop;
	private JButton accountsKnop;
	private JButton aanpassenKnop;
	private JTextField voornaamVeld;
	private JTextField achternaamVeld;
	private JTextField straatVeld;
	private JTextField gemeenteVeld;
	private JTextField landVeld;
	private JTextField emailVeld;
	private JTextField nummerVeld;
	private JTextField postcodeVeld;
	private JLabel aanpassenLabel;

	public AccountAanpassenGUI(){
		panel = new BeheerPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class BeheerPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setColor(new Color(239, 239, 239));
			g2d.fillRoundRect(200, 100, 600, 280, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(220, 0, 220, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(200, 100, 600, 280, 75, 75);

			
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
			
			pathologieënKnop = new JButton("Pathologieën");
			pathologieënKnop.setBounds(690, 25, 120, 30);
			
			accountsKnop = new JButton("Accounts");
			accountsKnop.setBounds(835, 25, 120, 30);
			
			aanpassenKnop = new JButton("Aanpassingen opslaan");
			aanpassenKnop.setBounds(250, 310, 170, 30);
			
			ButtonHandler handler = new ButtonHandler();
			titel.addActionListener(handler);
			aanpassenKnop.addActionListener(handler);
			vragenKnop.addActionListener(handler);
			vragenlijstenKnop.addActionListener(handler);
			aandoeningenKnop.addActionListener(handler);
			pathologieënKnop.addActionListener(handler);
			accountsKnop.addActionListener(handler);
			
			aanpassenLabel = new JLabel("Account aanpassen");
			aanpassenLabel.setFont(new Font("Default", Font.BOLD, 17));
			aanpassenLabel.setBounds(253, 120, 210, 20);
			
			voornaamVeld = new JTextField("Voornaam");
			voornaamVeld.setBounds(250, 161, 200, 25);
			
			achternaamVeld = new JTextField("Achternaam");
			achternaamVeld.setBounds(470, 161, 200, 25);
			
			straatVeld = new JTextField("Straat");
			straatVeld.setBounds(250, 191, 200, 25);
			
			nummerVeld = new JTextField("Nummer");
			nummerVeld.setBounds(470, 191, 90, 25);
			
			postcodeVeld = new JTextField("Postcode");
			postcodeVeld.setBounds(580, 191, 90, 25);
			
			gemeenteVeld = new JTextField("Gemeente");
			gemeenteVeld.setBounds(250, 221, 200, 25);
			
			landVeld = new JTextField("Land");
			landVeld.setBounds(470, 221, 200, 25);

			emailVeld = new JTextField("E-mail");
			emailVeld.setBounds(250, 251, 200, 25);
			
			add(titel);
			add(aanpassenLabel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologieënKnop);
			add(accountsKnop);
			add(aanpassenKnop);
			add(voornaamVeld);
			add(achternaamVeld);
			add(straatVeld);
			add(gemeenteVeld);
			add(landVeld);
			add(emailVeld);
			add(nummerVeld);
			add(postcodeVeld);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "FINAH":	newFrame = new AccountGUI();
							AccountAanpassenGUI.this.setVisible(false);
							break;
			case "Vragen":	newFrame = new VragenGUI();
							AccountAanpassenGUI.this.setVisible(false);
							break;
			case "Vragenlijsten":	newFrame = new VragenlijstenGUI();
									AccountAanpassenGUI.this.setVisible(false);
									break;
			case "Aandoeningen":	newFrame = new AandoeningenGUI();
									AccountAanpassenGUI.this.setVisible(false);
									break;
			case "Pathologieën":	newFrame = new PathologieënGUI();
									AccountAanpassenGUI.this.setVisible(false);
									break;
			case "Accounts":	newFrame = new AccountsOverzichtGUI();
								AccountAanpassenGUI.this.setVisible(false);
								break;
			}
		}		
	}
	
	public static void main(String[] args){
		AccountAanpassenGUI test = new AccountAanpassenGUI();
	}
	
}
