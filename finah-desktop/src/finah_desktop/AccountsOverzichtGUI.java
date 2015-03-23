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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountsOverzichtGUI extends JFrame{
	
	private AccountsPanel panel;
	private JButton titel;
	private JButton vragenKnop;
	private JButton vragenlijstenKnop;
	private JButton aandoeningenKnop;
	private JButton pathologieënKnop;
	private JButton accountsKnop;
	private JButton toevoegKnop;
	private JLabel overzichtAanvragenLabel;
	private JLabel overzichtAccountsLabel;
	private List<Aanvraag> aanvragen;
	private List<Account> accounts;
	int hoogte = 0;

	public AccountsOverzichtGUI(){
		aanvragen = new ArrayList<Aanvraag>();
		for(int i=1; i<=3; i++){
			aanvragen.add(new Aanvraag());
		}
		
		accounts = new ArrayList<Account>();
		for(int i=1; i<=6; i++){
			accounts.add(new Account());
		}
		
		panel = new AccountsPanel();		
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class AccountsPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			ButtonHandler handler = new ButtonHandler();
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setColor(Color.black);
			g2d.drawLine(220, 0, 220, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			
			overzichtAanvragenLabel = new JLabel("Overzicht aanvragen");
			overzichtAanvragenLabel.setFont(new Font("Default", Font.BOLD, 17));
			overzichtAanvragenLabel.setBounds(100, 100, 190, 20);
			
			if(aanvragen.size()>=1){
				//Dynamische tabel 1
				g2d.setPaint(Color.white);
				g2d.fillRect(100, 130, 800, 40);
				g2d.fillRect(100, 170, 800, 30*aanvragen.size());
				
				g2d.setPaint(Color.black);
				g2d.drawRect(100, 130, 800, 40);
				g2d.drawRect(100, 170, 800, 30*aanvragen.size());
				g2d.drawLine(600, 130, 600, 170+30*aanvragen.size());
				g2d.drawLine(700, 130, 700, 170+30*aanvragen.size());
				g2d.drawLine(800, 130, 800, 170+30*aanvragen.size());
				
				g2d.setFont(new Font("Arial", Font.BOLD, 17));
				g2d.drawString("Gebruikers", 315, 155);
				g2d.setFont(new Font("Arial", Font.PLAIN, 15));
				hoogte = 200;
				for(int i=1; i<=aanvragen.size(); i++){
					g2d.drawLine(100, hoogte, 900, hoogte);
					g2d.drawString("Aanvraag "+i, 120, hoogte-10);
					hoogte+=30;
				}
			}
			else{
				g2d.setColor(Color.black);
				g2d.setFont(new Font("Arial", Font.PLAIN, 15));
				g2d.drawString("Geen aanvragen.", 100, 150);
				hoogte = 180;
			}
			
			
			overzichtAccountsLabel = new JLabel("Overzicht accounts");
			overzichtAccountsLabel.setFont(new Font("Default", Font.BOLD, 17));
			overzichtAccountsLabel.setBounds(100, hoogte, 190, 20);

			toevoegKnop = new JButton("Account toevoegen");
			toevoegKnop.setBounds(750, hoogte, 150, 25);
			
			hoogte+=30;
			
			//dynamische tabel 2
			g2d.setPaint(Color.white);
			g2d.fillRect(100, hoogte, 800, 40);
			g2d.fillRect(100, hoogte+40, 800, 30*accounts.size());
			
			g2d.setPaint(Color.black);
			g2d.drawRect(100, hoogte, 800, 40);
			g2d.drawRect(100, hoogte+40, 800, 30*accounts.size());
			g2d.drawLine(670, hoogte, 670, hoogte+40+30*accounts.size());
			g2d.drawLine(700, hoogte, 700, hoogte+40+30*accounts.size());
			
			g2d.setFont(new Font("Arial", Font.BOLD, 17));
			g2d.drawString("Gebruikers", 315, hoogte+25);
			g2d.setFont(new Font("Arial", Font.PLAIN, 15));
			hoogte+=70;
			for(int i=1; i<=accounts.size(); i++){
				g2d.drawLine(100, hoogte, 900, hoogte);
				g2d.drawString("Gebruiker "+i, 120, hoogte-10);
				JButton wijzigLabel = new JButton("Aanpassen");
				wijzigLabel.setBounds(701,hoogte-29,199,29);
				wijzigLabel.addActionListener(handler);
				add(wijzigLabel);
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
			
			pathologieënKnop = new JButton("Pathologieën");
			pathologieënKnop.setBounds(690, 25, 120, 30);
			
			accountsKnop = new JButton("Accounts");
			accountsKnop.setBounds(835, 25, 120, 30);
			
			titel.addActionListener(handler);
			vragenKnop.addActionListener(handler);
			vragenlijstenKnop.addActionListener(handler);
			aandoeningenKnop.addActionListener(handler);
			pathologieënKnop.addActionListener(handler);
			toevoegKnop.addActionListener(handler);
			accountsKnop.addActionListener(handler);

			add(titel);
			add(vragenKnop);
			add(vragenlijstenKnop);
			add(aandoeningenKnop);
			add(pathologieënKnop);
			add(accountsKnop);
			add(overzichtAccountsLabel);
			add(overzichtAanvragenLabel);
			add(toevoegKnop);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame;
			switch(e.getActionCommand()){
			case "FINAH":	newFrame = new AccountGUI();
							AccountsOverzichtGUI.this.setVisible(false);
							break;
			case "Vragen":	newFrame = new VragenGUI();
							AccountsOverzichtGUI.this.setVisible(false);
							break;
			case "Vragenlijsten":	newFrame = new VragenlijstenGUI();
									AccountsOverzichtGUI.this.setVisible(false);
									break;
			case "Aandoeningen":	newFrame = new AandoeningenGUI();
									AccountsOverzichtGUI.this.setVisible(false);
									break;
			case "Pathologieën":	newFrame = new PathologieënGUI();
									AccountsOverzichtGUI.this.setVisible(false);
									break;
			case "Accounts":	newFrame = new AccountsOverzichtGUI();
								AccountsOverzichtGUI.this.setVisible(false);
								break;
			case "Account toevoegen":	newFrame = new AccountToevoegenGUI();
										AccountsOverzichtGUI.this.setVisible(false);
										break;
			case "Aanpassen":	newFrame = new AccountAanpassenGUI();
								AccountsOverzichtGUI.this.setVisible(false);
								break;
			}
		}		
	}
	
	public static void main(String[] args){
		AccountsOverzichtGUI test = new AccountsOverzichtGUI();
	}
	
}
