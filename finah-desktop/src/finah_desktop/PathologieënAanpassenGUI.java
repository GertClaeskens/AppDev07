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

public class PathologieŽnAanpassenGUI extends JFrame{
	
	private PathologieŽnAanpassenPanel panel;
	private JButton titel;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologieŽnKnop;
	private JButton accountsKnop;
	private JButton opslaanKnop;
	private JLabel aanpassenLabel;
	private List<Pathologie> pathologieŽn;

	public PathologieŽnAanpassenGUI(){
		pathologieŽn = new ArrayList<Pathologie>();
		for(int i=1; i<=10; i++){
			pathologieŽn.add(new Pathologie());
		}
		
		panel = new PathologieŽnAanpassenPanel();		
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class PathologieŽnAanpassenPanel extends JPanel{
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
			g2d.fillRect(100, 130, 800, 40);
			g2d.fillRect(100, 170, 800, 30*pathologieŽn.size());
			
			g2d.setPaint(Color.black);
			g2d.drawRect(100, 130, 800, 40);
			g2d.drawRect(100, 170, 800, 30*pathologieŽn.size());
			g2d.drawLine(640, 130, 640, 170+30*pathologieŽn.size());
			g2d.drawLine(870, 130, 870, 170+30*pathologieŽn.size());
			
			g2d.setFont(new Font("Arial", Font.BOLD, 17));
			g2d.drawString("PathologieŽn", 320, 155);
			g2d.drawString("Vragenlijst", 715, 155);
			g2d.setFont(new Font("Arial", Font.PLAIN, 15));
			int hoogte = 200;
			for(int i=1; i<=pathologieŽn.size(); i++){
				g2d.drawLine(100, hoogte, 900, hoogte);
				JTextField pathologieVeld = new JTextField("Pathologie"+i);
				pathologieVeld.setBounds(101,hoogte-29,539,29);
				add(pathologieVeld);
				JComboBox vragenlijstCombo = new JComboBox();
				vragenlijstCombo.setBounds(642,hoogte-28,227,27);
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
			
			opslaanKnop = new JButton("Wijzigingen opslaan");
			opslaanKnop.setBounds(750, 100, 150, 25);
			
			aanpassenLabel = new JLabel("PathologieŽn aanpassen");
			aanpassenLabel.setFont(new Font("Default", Font.BOLD, 17));
			aanpassenLabel.setBounds(100, 100, 200, 20);
			
			ButtonHandler handler = new ButtonHandler();
			titel.addActionListener(handler);
			vragenKnop.addActionListener(handler);
			vragenlijstenKnop.addActionListener(handler);
			aandoeningenKnop.addActionListener(handler);
			pathologieŽnKnop.addActionListener(handler);
			accountsKnop.addActionListener(handler);
			
			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologieŽnKnop);
			add(accountsKnop);
			add(opslaanKnop);
			add(aanpassenLabel);
			opslaanKnop.addActionListener(handler);
			
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "FINAH":	newFrame = new AccountGUI();
							PathologieŽnAanpassenGUI.this.setVisible(false);
							break;
			case "Vragen":	newFrame = new VragenGUI();
							PathologieŽnAanpassenGUI.this.setVisible(false);
							break;
			case "Vragenlijsten":	newFrame = new VragenlijstenGUI();
									PathologieŽnAanpassenGUI.this.setVisible(false);
									break;
			case "Aandoeningen":	newFrame = new AandoeningenGUI();
									PathologieŽnAanpassenGUI.this.setVisible(false);
									break;
			case "PathologieŽn":	newFrame = new PathologieŽnGUI();
									PathologieŽnAanpassenGUI.this.setVisible(false);
									break;
			case "Accounts":	newFrame = new AccountsOverzichtGUI();
								PathologieŽnAanpassenGUI.this.setVisible(false);
								break;
			case "Wijzigingen opslaan":	newFrame = new PathologieŽnGUI();
										PathologieŽnAanpassenGUI.this.setVisible(false);
										break;
			}
		}		
	}
	
	public static void main(String[] args){
		PathologieŽnAanpassenGUI test = new PathologieŽnAanpassenGUI();
	}
	
}
