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

public class BeheerGUI extends JFrame{
	
	private BeheerPanel panel;
	private JButton titel;
	private JLabel tekst;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologieënKnop;
	private JButton accountsKnop;

	public BeheerGUI(){
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
			vragenKnop.setBounds(255, 25, 120, 30);
			
			vragenlijstenKnop = new JButton("Vragenlijsten");
			vragenlijstenKnop.setBounds(400, 25, 120, 30);
			
			aandoeningenKnop = new JButton("Aandoeningen");
			aandoeningenKnop.setBounds(545, 25, 120, 30);
			
			pathologieënKnop = new JButton("Pathologieën");
			pathologieënKnop.setBounds(690, 25, 120, 30);
			
			accountsKnop = new JButton("Accounts");
			accountsKnop.setBounds(835, 25, 120, 30);
			
			ButtonHandler handler = new ButtonHandler();
			titel.addActionListener(handler);
			vragenKnop.addActionListener(handler);
			vragenlijstenKnop.addActionListener(handler);
			aandoeningenKnop.addActionListener(handler);
			pathologieënKnop.addActionListener(handler);
			accountsKnop.addActionListener(handler);
			
			tekst = new JLabel("<html>Welkom op de beheerderspagina!<br><br>Hier kan u alle overzichten bekijken en waar nodig "
					+ "aanpassingen maken.<br/>Indien u terug wilt gaan klikt u gewoon op de tekst FINAH en wordt u terug <br>naar "
					+ "de home-pagina gebracht.");
			tekst.setFont(new Font("Default", Font.PLAIN, 17));
			tekst.setBounds(230, 100, 560, 160);
			
			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologieënKnop);
			add(accountsKnop);
			add(tekst);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "FINAH":	newFrame = new AccountGUI();
							BeheerGUI.this.setVisible(false);
							break;
			case "Vragen":	newFrame = new VragenGUI();
							BeheerGUI.this.setVisible(false);
							break;
			case "Vragenlijsten":	newFrame = new VragenlijstenGUI();
									BeheerGUI.this.setVisible(false);
									break;
			case "Aandoeningen":	newFrame = new AandoeningenGUI();
									BeheerGUI.this.setVisible(false);
									break;
			case "Pathologieën":	newFrame = new PathologieënGUI();
									BeheerGUI.this.setVisible(false);
									break;
			case "Accounts":	newFrame = new AccountsOverzichtGUI();
								BeheerGUI.this.setVisible(false);
								break;
			}
		}			
	}
	
	public static void main(String[] args){
		BeheerGUI test = new BeheerGUI();
	}
	
}
