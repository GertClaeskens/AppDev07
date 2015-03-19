package finah_desktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginGUI extends JFrame{
	
	private LoginPanel panel;
	private JLabel titel;
	private JLabel loginLabel;
	private JLabel naamLabel;
	private JLabel pwLabel;
	private JTextField naamVeld;
	private JPasswordField pwVeld;
	private JButton inlogKnop;
	private JButton nieuwAccountKnop;
	private JButton pwVergetenKnop;

	public LoginGUI(){
		panel = new LoginPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	
	private class LoginPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setPaint(new GradientPaint(375,100,new Color(2,154,204),375,300,new Color(102,204,204)));
			g2d.fillRoundRect(375, 100, 250, 300, 75, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(375, 100, 250, 300, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(400, 155, 600, 155);
			
			titel = new JLabel("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(440, 15, 120, 40);
			
			loginLabel = new JLabel("Gebruikerslogin");
			loginLabel.setFont(new Font("Default", Font.PLAIN, 17));
			loginLabel.setBounds(400,125,120,20);
			
			naamLabel = new JLabel("Gebruikersnaam");
			naamLabel.setFont(new Font("Default", Font.PLAIN, 17));
			naamLabel.setBounds(400,175,120,20);
			
			pwLabel = new JLabel("Wachtwoord");
			pwLabel.setFont(new Font("Default", Font.PLAIN, 17));
			pwLabel.setBounds(400,230,120,20);
			
			naamVeld = new JTextField();
			naamVeld.setBounds(400, 200, 200, 20);
			
			pwVeld = new JPasswordField();
			pwVeld.setBounds(400, 255, 200, 20);
			
			inlogKnop = new JButton("Inloggen");
			inlogKnop.setBounds(455, 295, 90, 20);
			
			nieuwAccountKnop = new JButton("Nieuw account aanmaken");
			nieuwAccountKnop.setForeground(Color.white);
			nieuwAccountKnop.setFont(new Font("Default", Font.PLAIN, 15));
			nieuwAccountKnop.setHorizontalAlignment(SwingConstants.LEFT);
			nieuwAccountKnop.setBounds(385, 335, 210, 17);
			nieuwAccountKnop.setOpaque(false);
			nieuwAccountKnop.setContentAreaFilled(false);
			nieuwAccountKnop.setBorderPainted(false);
			
			pwVergetenKnop = new JButton("Wachtwoord vergeten?");
			pwVergetenKnop.setForeground(Color.white);
			pwVergetenKnop.setFont(new Font("Default", Font.PLAIN, 15));
			pwVergetenKnop.setBounds(385, 365, 190, 17);
			pwVergetenKnop.setHorizontalAlignment(SwingConstants.LEFT);
			pwVergetenKnop.setOpaque(false);
			pwVergetenKnop.setContentAreaFilled(false);
			pwVergetenKnop.setBorderPainted(false);
			
			add(titel);
			add(loginLabel);
			add(naamLabel);
			add(pwLabel);
			add(naamVeld);
			add(pwVeld);
			add(inlogKnop);
			add(nieuwAccountKnop);
			add(pwVergetenKnop);
		}
	}
	
	public static void main(String[] args){
		LoginGUI test = new LoginGUI();
	}
	
}

