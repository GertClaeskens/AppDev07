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

public class BeheerGUI extends JFrame{
	
	private WachtwoordVergetenPanel panel;
	private JButton titel;
	private JLabel tekst;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologiënKnop;
	private JButton accountsKnop;

	public BeheerGUI(){
		panel = new WachtwoordVergetenPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
	}

	private class WachtwoordVergetenPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setColor(new Color(239, 239, 239));
			g2d.fillRoundRect(200, 100, 600, 200, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(220, 0, 220, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(200, 100, 600, 200, 75, 75);
			
			titel = new JButton("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(0, 0, 220, 75);
			titel.setOpaque(false);
			titel.setContentAreaFilled(false);
			titel.setBorderPainted(false);
			
			vragenKnop = new JButton("Vragen");
			vragenKnop.setBounds(260, 25, 120, 25);
			
			vragenlijstenKnop = new JButton("Vragenlijsten");
			vragenlijstenKnop.setBounds(400, 25, 120, 25);
			
			aandoeningenKnop = new JButton("Aandoeningen");
			aandoeningenKnop.setBounds(545, 25, 120, 25);
			
			pathologiënKnop = new JButton("Pathologiën");
			pathologiënKnop.setBounds(690, 25, 120, 25);
			
			accountsKnop = new JButton("Accounts");
			accountsKnop.setBounds(835, 25, 120, 25);
			
			tekst = new JLabel("<html>Welkom op de beheerderspagina!<br><br>Hier kan u alle overzichten bekijken en waar nodig "
					+ "aanpassingen maken.<br/>Indien u terug wilt gaan klikt u gewoon op de tekst FINAH en wordt u terug <br>naar "
					+ "de home-pagina gebracht.");
			tekst.setFont(new Font("Default", Font.PLAIN, 17));
			tekst.setBounds(230, 100, 560, 160);
			
			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologiënKnop);
			add(accountsKnop);
			add(tekst);
		}
	}
	
	public static void main(String[] args){
		BeheerGUI test = new BeheerGUI();
	}
	
}
