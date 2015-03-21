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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NieuwAccountGUI extends JFrame{
	
	private NieuwAccountPanel panel;
	private JLabel titel;
	private JLabel nieuwAccountLabel;
	private JTextField nieuwAccountVeld;
	private JLabel gebruikersNaamLabel;
	private JTextField gebruikersNaamVeld;
	private JLabel pwLabel;
	private JPasswordField pwVeld;
	private JLabel pwHerhLabel;
	private JPasswordField pwHerhVeld;
	private JLabel voornaamLabel;
	private JTextField voornaamVeld;
	private JLabel achternaamLabel;
	private JTextField achternaamVeld;
	private JLabel emailLabel;
	private JTextField emailVeld;
	private JButton aanmaakKnop;

	public NieuwAccountGUI(){
		panel = new NieuwAccountPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	
	private class NieuwAccountPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0, 0 ,new Color(2,154,204), 0, 75, new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setPaint(new GradientPaint(375, 100, new Color(2,154,204), 375, 400, new Color(102,204,204)));
			g2d.fillRoundRect(375, 100, 250, 400, 75, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(375, 100, 250, 400, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(400, 145, 600, 145);
			
			titel = new JLabel("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(440, 15, 120, 40);
			
			nieuwAccountLabel = new JLabel("Nieuw account aanmaken");
			nieuwAccountLabel.setFont(new Font("Default", Font.PLAIN, 17));
			nieuwAccountLabel.setBounds(400,115,200,20);
			
			gebruikersNaamLabel = new JLabel("Gebruikersnaam");
			gebruikersNaamLabel.setFont(new Font("Default", Font.PLAIN, 15));
			gebruikersNaamLabel.setBounds(400,160,120,20);
			
			gebruikersNaamVeld = new JTextField();
			gebruikersNaamVeld.setBounds(400, 180, 200, 20);
			
			pwLabel = new JLabel("Wachtwoord");
			pwLabel.setFont(new Font("Default", Font.PLAIN, 15));
			pwLabel.setBounds(400,205,120,20);
			
			pwVeld = new JPasswordField();
			pwVeld.setBounds(400, 225, 200, 20);
			
			pwHerhLabel = new JLabel("Herhaal wachtwoord");
			pwHerhLabel.setFont(new Font("Default", Font.PLAIN, 15));
			pwHerhLabel.setBounds(400,250,140,20);
			
			pwHerhVeld = new JPasswordField();
			pwHerhVeld.setBounds(400, 270, 200, 20);
			
			voornaamLabel = new JLabel("Voornaam");
			voornaamLabel.setFont(new Font("Default", Font.PLAIN, 15));
			voornaamLabel.setBounds(400,295,120,20);
			
			voornaamVeld = new JTextField();
			voornaamVeld.setBounds(400, 315, 200, 20);
			
			achternaamLabel = new JLabel("Achternaam");
			achternaamLabel.setFont(new Font("Default", Font.PLAIN, 15));
			achternaamLabel.setBounds(400,340,120,20);
			
			achternaamVeld = new JTextField();
			achternaamVeld.setBounds(400, 360, 200, 20);
			
			emailLabel = new JLabel("E-mail adres");
			emailLabel.setFont(new Font("Default", Font.PLAIN, 15));
			emailLabel.setBounds(400,385,120,20);
			
			emailVeld = new JTextField();
			emailVeld.setBounds(400, 405, 200, 20);
			
			aanmaakKnop = new JButton("Account aanmaken");
			aanmaakKnop.setBounds(425, 445, 150, 30);
			aanmaakKnop.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JFrame newFrame = new LoginGUI();
					NieuwAccountGUI.this.setVisible(false);
				}
			});
			
			add(titel);
			add(nieuwAccountLabel);
			add(gebruikersNaamLabel);
			add(gebruikersNaamVeld);
			add(pwLabel);
			add(pwVeld);
			add(pwHerhLabel);
			add(pwHerhVeld);
			add(voornaamLabel);
			add(voornaamVeld);
			add(achternaamLabel);
			add(achternaamVeld);
			add(emailLabel);
			add(emailVeld);
			add(aanmaakKnop);
			
		}
	}
	
	public static void main(String[] args){
		NieuwAccountGUI test = new NieuwAccountGUI();
	}
	
}

