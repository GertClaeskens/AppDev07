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

public class PathologieŽnGUI extends JFrame{
	
	private VragenPanel panel;
	private JButton titel;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologieŽnKnop;
	private JButton accountsKnop;
	private JButton toevoegKnop;
	private JLabel toevoegenLabel;
	private JLabel overzichtLabel;
	private JTextField nieuwePathologieVeld;
	private JComboBox nieuwePathologieCombo;
	private List<Pathologie> pathologieŽn;

	public PathologieŽnGUI(){
		pathologieŽn = new ArrayList<Pathologie>();
		for(int i=1; i<=10; i++){
			pathologieŽn.add(new Pathologie());
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
			g2d.fillRect(100, 250, 800, 30*pathologieŽn.size());
			
			g2d.setPaint(Color.black);
			g2d.drawRect(100, 210, 800, 40);
			g2d.drawRect(100, 250, 800, 30*pathologieŽn.size());
			g2d.drawLine(640, 210, 640, 250+30*pathologieŽn.size());
			g2d.drawLine(670, 210, 670, 250+30*pathologieŽn.size());
			g2d.drawLine(700, 210, 700, 250+30*pathologieŽn.size());
			
			g2d.setFont(new Font("Arial", Font.BOLD, 17));
			g2d.drawString("PathologieŽn", 320, 235);
			g2d.drawString("Aandoeningen", 745, 235);
			g2d.setFont(new Font("Arial", Font.PLAIN, 15));
			int hoogte = 280;
			for(int i=1; i<=pathologieŽn.size(); i++){
				g2d.drawLine(100, hoogte, 900, hoogte);
				g2d.drawString("Pathologie "+i, 120, hoogte-10);
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
			
			toevoegenLabel = new JLabel("Pathologie toevoegen");
			toevoegenLabel.setFont(new Font("Default", Font.BOLD, 17));
			toevoegenLabel.setBounds(100, 100, 190, 20);
			overzichtLabel = new JLabel("Overzicht pathologieŽn");
			overzichtLabel.setFont(new Font("Default", Font.BOLD, 17));
			overzichtLabel.setBounds(100, 180, 190, 20);
			
			nieuwePathologieVeld = new JTextField();
			nieuwePathologieVeld.setBounds(100, 130, 490, 25);
			nieuwePathologieCombo = new JComboBox();
			nieuwePathologieCombo.setBounds(600, 130, 190, 25);
			
			toevoegKnop = new JButton("Toevoegen");
			toevoegKnop.setBounds(800, 130, 100, 25);
			
			ButtonHandler handler = new ButtonHandler();
			titel.addActionListener(handler);
			vragenKnop.addActionListener(handler);
			vragenlijstenKnop.addActionListener(handler);
			aandoeningenKnop.addActionListener(handler);
			accountsKnop.addActionListener(handler);
			
			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologieŽnKnop);
			add(accountsKnop);
			add(toevoegenLabel);
			add(overzichtLabel);
			add(nieuwePathologieVeld);
			add(nieuwePathologieCombo);
			add(toevoegKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "FINAH":	newFrame = new AccountGUI();
							PathologieŽnGUI.this.setVisible(false);
							break;
			case "Vragen":	newFrame = new VragenGUI();
							PathologieŽnGUI.this.setVisible(false);
							break;
			case "Vragenlijsten":	newFrame = new AandoeningenGUI();
									PathologieŽnGUI.this.setVisible(false);
									break;
			case "Aandoeningen":	newFrame = new PathologieŽnGUI();
									PathologieŽnGUI.this.setVisible(false);
									break;
			case "Accounts":	newFrame = new AccountsOverzichtGUI();
								PathologieŽnGUI.this.setVisible(false);
								break;
			}
		}	
	}
	
	public static void main(String[] args){
		PathologieŽnGUI test = new PathologieŽnGUI();
	}
	
}
