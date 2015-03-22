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

public class OpgezochteResultatenGUI extends JFrame{
	
	private OpgezochteResultatenPanel panel;
	private JLabel titel;
	private JButton andereVragenlijstKnop;
	private List<Vraag> vragen;

	public OpgezochteResultatenGUI(){
		vragen = new ArrayList<Vraag>();
		for(int i=1; i<=10; i++){
			vragen.add(new Vraag());
		}
		
		panel = new OpgezochteResultatenPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class OpgezochteResultatenPanel extends JPanel{
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
			
			//dynamische tabel
			g2d.setPaint(Color.white);
			g2d.fillRect(100, 110, 800, 40);
			g2d.fillRect(100, 150, 800, 30*vragen.size());
			
			g2d.setPaint(Color.black);
			g2d.drawRect(100, 110, 800, 40);
			g2d.drawRect(100, 150, 800, 30*vragen.size());
			g2d.drawLine(640, 110, 640, 150+30*vragen.size());
			g2d.drawLine(770, 110, 770, 150+30*vragen.size());
			
			g2d.setFont(new Font("Arial", Font.BOLD, 17));
			g2d.drawString("Vragen", 335, 135);
			g2d.drawString("Antwoord", 665, 135);
			g2d.drawString("Hulpvraag?", 790, 135);
			g2d.setFont(new Font("Arial", Font.PLAIN, 15));
			int hoogte = 180;
			for(int i=1; i<=vragen.size(); i++){
				g2d.drawLine(100, hoogte, 900, hoogte);
				g2d.drawString("Vraag "+i, 120, hoogte-10);
				hoogte+=30;
			}
			
			titel = new JLabel("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(50, 0, 220, 75);
			
			andereVragenlijstKnop = new JButton("Andere vragenlijst");
			andereVragenlijstKnop.setBounds(800, 25, 140, 30);
			
			ButtonHandler handler = new ButtonHandler();
			andereVragenlijstKnop.addActionListener(handler);
			
			add(titel);
			add(andereVragenlijstKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "Andere vragenlijst":	newFrame = new ResultatenGUI();
										OpgezochteResultatenGUI.this.setVisible(false);
										break;
			}
		}		
	}
	
	public static void main(String[] args){
		OpgezochteResultatenGUI test = new OpgezochteResultatenGUI();
	}
	
}

