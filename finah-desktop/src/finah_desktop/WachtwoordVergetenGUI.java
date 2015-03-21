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

public class WachtwoordVergetenGUI extends JFrame{
	
	private WachtwoordVergetenPanel panel;
	private JLabel titel;
	private JLabel pwVergetenLabel;
	private JLabel naamLabel;
	private JLabel emailLabel;
	private JTextField naamVeld;
	private JTextField emailVeld;
	private JButton stuurKnop;

	public WachtwoordVergetenGUI(){
		panel = new WachtwoordVergetenPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class WachtwoordVergetenPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setPaint(new GradientPaint(375,100,new Color(2,154,204),375,300,new Color(102,204,204)));
			g2d.fillRoundRect(375, 100, 250, 270, 75, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(375, 100, 250, 270, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(400, 155, 600, 155);
			
			titel = new JLabel("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(440, 15, 120, 40);
			
			pwVergetenLabel = new JLabel("Wachtwoord vergeten");
			pwVergetenLabel.setFont(new Font("Default", Font.PLAIN, 17));
			pwVergetenLabel.setBounds(400,125,160,20);
			
			naamLabel = new JLabel("Gebruikersnaam");
			naamLabel.setFont(new Font("Default", Font.PLAIN, 17));
			naamLabel.setBounds(400,175,120,20);
			
			emailLabel = new JLabel("E-mail adres");
			emailLabel.setFont(new Font("Default", Font.PLAIN, 17));
			emailLabel.setBounds(400,230,120,20);
			
			naamVeld = new JTextField();
			naamVeld.setBounds(400, 200, 200, 20);
			
			emailVeld = new JPasswordField();
			emailVeld.setBounds(400, 255, 200, 20);
			
			stuurKnop = new JButton("Stuur wachtwoord");
			stuurKnop.setBounds(430, 305, 140, 30);
			stuurKnop.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JFrame newFrame = new LoginGUI();
					WachtwoordVergetenGUI.this.setVisible(false);
				}
			});
			
			add(titel);
			add(pwVergetenLabel);
			add(naamLabel);
			add(emailLabel);
			add(naamVeld);
			add(emailVeld);
			add(stuurKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}		
	}
	
	public static void main(String[] args){
		WachtwoordVergetenGUI test = new WachtwoordVergetenGUI();
	}
	
}
