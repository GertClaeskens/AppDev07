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

public class AccountGUI extends JFrame{
	
	private AccountPanel panel;
	private JLabel titel;
	private JButton accountKnop;
	private JButton bevragingKnop;
	private JButton beheerKnop;
	private JButton resultatenKnop;
	private JButton uitloggenKnop;
	private JLabel onderzoekerLabel;
	private JLabel straatLabel;
	private JLabel gemeenteLabel;
	private JLabel landLabel;
	private JLabel emailLabel;
	private JLabel IDLabel;
	private JLabel nummerLabel;
	private JLabel postcodeLabel;
	private JLabel fotoLabel;
	private JLabel gebruikerLabel;
	private JTextField straatVeld;
	private JTextField gemeenteVeld;
	private JTextField landVeld;
	private JTextField emailVeld;
	private JTextField nummerVeld;
	private JTextField postcodeVeld;
	private JButton IDKnop;
	private JButton fotoKnop;
	private JButton wijzigenKnop;

	public AccountGUI(){
		panel = new AccountPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class AccountPanel extends JPanel{
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
			
			onderzoekerLabel = new JLabel("Onderzoeker");
			onderzoekerLabel.setFont(new Font("Default", Font.PLAIN, 15));
			onderzoekerLabel.setBounds(180, 130, 90, 25);
			gebruikerLabel = new JLabel();
			gebruikerLabel.setBounds(280, 131, 200, 25);
			
			straatLabel = new JLabel("Straat");
			straatLabel.setFont(new Font("Default", Font.PLAIN, 15));
			straatLabel.setBounds(180, 160, 90, 25);
			straatVeld = new JTextField();
			straatVeld.setBounds(280, 161, 200, 25);
			
			gemeenteLabel = new JLabel("Gemeente");
			gemeenteLabel.setFont(new Font("Default", Font.PLAIN, 15));
			gemeenteLabel.setBounds(180, 190, 90, 25);
			gemeenteVeld = new JTextField();
			gemeenteVeld.setBounds(280, 191, 200, 25);
			
			landLabel = new JLabel("Land");
			landLabel.setFont(new Font("Default", Font.PLAIN, 15));
			landLabel.setBounds(180, 220, 90, 25);
			landVeld = new JTextField();
			landVeld.setBounds(280, 221, 200, 25);
			
			emailLabel = new JLabel("E-mail");
			emailLabel.setFont(new Font("Default", Font.PLAIN, 15));
			emailLabel.setBounds(180, 250, 90, 25);
			emailVeld = new JTextField();
			emailVeld.setBounds(280, 251, 200, 25);
			
			IDLabel = new JLabel("E-ID");
			IDLabel.setFont(new Font("Default", Font.PLAIN, 15));
			IDLabel.setBounds(180, 290, 90, 25);
			IDKnop = new JButton("E-ID lezen");
			IDKnop.setBounds(280, 290, 90, 25);
			
			nummerLabel = new JLabel("Nr");
			nummerLabel.setFont(new Font("Default", Font.PLAIN, 15));
			nummerLabel.setBounds(500, 160, 20, 25);
			nummerVeld = new JTextField();
			nummerVeld.setBounds(520, 161, 90, 25);
			
			postcodeLabel = new JLabel("Pc");
			postcodeLabel.setFont(new Font("Default", Font.PLAIN, 15));
			postcodeLabel.setBounds(500, 190, 20, 25);
			postcodeVeld = new JTextField();
			postcodeVeld.setBounds(520, 191, 90, 25);
			
			fotoLabel = new JLabel("Profielfoto");
			fotoLabel.setFont(new Font("Default", Font.PLAIN, 15));
			fotoLabel.setBounds(660, 130, 90, 25);
			g2d.drawRect(660, 160, 150, 150);
			fotoKnop = new JButton("Wijzigen");
			fotoKnop.setBounds(690, 320, 90, 25);
			
			wijzigenKnop = new JButton("Veranderingen opslaan");
			wijzigenKnop.setBounds(415, 350, 170, 30);
			
			add(titel);
			add(accountKnop);
			add(bevragingKnop);
			add(beheerKnop);
			add(resultatenKnop);
			add(uitloggenKnop);
			add(onderzoekerLabel);
			add(gebruikerLabel);
			add(straatLabel);
			add(straatVeld);
			add(gemeenteLabel);
			add(gemeenteVeld);
			add(landLabel);
			add(landVeld);
			add(emailLabel);
			add(emailVeld);
			add(IDLabel);
			add(IDKnop);
			add(nummerLabel);
			add(nummerVeld);
			add(postcodeLabel);
			add(postcodeVeld);
			add(fotoLabel);
			add(fotoKnop);
			add(wijzigenKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "Beheer":	BeheerGUI newFrame = new BeheerGUI();
							AccountGUI.this.setVisible(false);
							break;
			}
		}		
	}
	
	public static void main(String[] args){
		AccountGUI test = new AccountGUI();
	}
	
}
