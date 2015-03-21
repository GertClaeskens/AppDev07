package finah_desktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultatenGUI extends JFrame{
	
	private ResultatenPanel panel;
	private JLabel titel;
	private JButton accountKnop;
	private JButton bevragingKnop;
	private JButton beheerKnop;
	private JButton resultatenKnop;
	private JButton uitloggenKnop;
	private JLabel vragenlijstLabel;
	private JLabel vragenlijstIDLabel;
	private JComboBox vragenlijstCombo;
	private JComboBox vragenlijstIDCombo;
	private JButton zoek;

	public ResultatenGUI(){
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
			g2d.fillRoundRect(250, 100, 500, 170, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(220, 0, 220, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(250, 100, 500, 170, 75, 75);
			
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
			
			vragenlijstLabel = new JLabel("Vragenlijst:");
			vragenlijstLabel.setFont(new Font("Default", Font.PLAIN, 17));
			vragenlijstLabel.setBounds(300, 130, 110, 20);
			vragenlijstIDLabel = new JLabel("Vragenlijst ID:");
			vragenlijstIDLabel.setFont(new Font("Default", Font.PLAIN, 17));
			vragenlijstIDLabel.setBounds(300, 165, 110, 20);
			vragenlijstCombo = new JComboBox();
			vragenlijstCombo.setBounds(430, 128, 250, 25);
			vragenlijstIDCombo = new JComboBox();
			vragenlijstIDCombo.setBounds(430, 163, 250, 25);
			zoek = new JButton("Zoek resultaten");
			zoek.setBounds(550, 210, 130, 25);
			
			add(titel);
			add(accountKnop);
			add(bevragingKnop);
			add(beheerKnop);
			add(resultatenKnop);
			add(uitloggenKnop);
			add(vragenlijstLabel);
			add(vragenlijstIDLabel);
			add(vragenlijstCombo);
			add(vragenlijstIDCombo);
			add(zoek);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "Beheer":	BeheerGUI newFrame = new BeheerGUI();
							ResultatenGUI.this.setVisible(false);
							break;
			}
		}		
	}
	
	public static void main(String[] args){
		ResultatenGUI test = new ResultatenGUI();
	}
	
}

