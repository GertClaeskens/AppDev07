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

public class TitelbalkGUI1 extends JFrame{
	
	private ResultatenPanel panel;
	private JLabel titel;
	private JButton accountKnop;
	private JButton bevragingKnop;
	private JButton beheerKnop;
	private JButton resultatenKnop;
	private JButton uitloggenKnop;

	public TitelbalkGUI1(){
		panel = new ResultatenPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class ResultatenPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setColor(new Color(239, 239, 239));
			g2d.fillRoundRect(150, 100, 700, 300, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(220, 0, 220, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(150, 100, 700, 300, 75, 75);
			
			titel = new JLabel("FINAH");
			titel.setFont(new Font("Default", Font.BOLD, 40));
			titel.setBounds(50, 0, 220, 75);
			
			accountKnop = new JButton("Account");
			accountKnop.setBounds(280, 25, 100, 30);
			bevragingKnop = new JButton("Nieuwe bevraging");
			bevragingKnop.setBounds(405, 25, 135, 30);
			beheerKnop = new JButton("Beheer");
			beheerKnop.setBounds(565, 25, 100, 30);
			resultatenKnop = new JButton("Resultaten");
			resultatenKnop.setBounds(690, 25, 100, 30);
			uitloggenKnop = new JButton("Uitloggen");
			uitloggenKnop.setBounds(815, 25, 100, 30);
			
			ButtonHandler handler = new ButtonHandler();
			beheerKnop.addActionListener(handler);
			
			add(titel);
			add(accountKnop);
			add(bevragingKnop);
			add(beheerKnop);
			add(resultatenKnop);
			add(uitloggenKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "Beheer":	BeheerGUI newFrame = new BeheerGUI();
							TitelbalkGUI1.this.setVisible(false);
							break;
			}
		}		
	}
	
	public static void main(String[] args){
		TitelbalkGUI1 test = new TitelbalkGUI1();
	}
	
}

