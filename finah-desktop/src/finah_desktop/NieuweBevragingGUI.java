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
import javax.swing.JTextField;

public class NieuweBevragingGUI extends JFrame{
	
	private NieuweBevragingPanel panel;
	private JLabel titel;
	private JButton accountKnop;
	private JButton bevragingKnop;
	private JButton beheerKnop;
	private JButton resultatenKnop;
	private JButton uitlogKnop;
	private JLabel hulpverlenerLabel;
	private JLabel hulpverlenerIngevuldLabel;
	private JLabel pati�ntLabel;
	private JLabel vragenlijstLabel;
	private JLabel aandoeningLabel;
	private JLabel pathologieLabel;
	private JLabel leeftijdPati�ntLabel;
	private JLabel leeftijdMantelLabel;
	private JTextField pati�ntVeld;
	private JComboBox vragenlijstCombo;
	private JComboBox aandoeningCombo;
	private JComboBox pathologieCombo;
	private JComboBox leeftijdPati�ntCombo;
	private JComboBox leeftijdMantelCombo;
	private JButton versturen;

	public NieuweBevragingGUI(){
		panel = new NieuweBevragingPanel();
		panel.setLayout(null);
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class NieuweBevragingPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			setBackground(new Color(188,188,188));
			
			g2d.setPaint(new GradientPaint(0,0,new Color(2,154,204),0,75,new Color(102,204,204)));
			g2d.fillRoundRect(0, 0, 984, 75, 30, 30);
			
			g2d.setColor(new Color(239, 239, 239));
			g2d.fillRoundRect(200, 100, 600, 360, 75, 75);
			
			g2d.setColor(Color.black);
			g2d.drawLine(220, 0, 220, 75);
			
			g2d.setPaint(Color.gray);
			g2d.drawRoundRect(0, 0, 984, 75, 30, 30);
			g2d.drawRoundRect(200, 100, 600, 360, 75, 75);
			
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
			uitlogKnop = new JButton("Uitloggen");
			uitlogKnop.setBounds(815, 25, 100, 30);
			
			ButtonHandler handler = new ButtonHandler();
			beheerKnop.addActionListener(handler);
			accountKnop.addActionListener(handler);
			resultatenKnop.addActionListener(handler);
			uitlogKnop.addActionListener(handler);
			
			hulpverlenerLabel = new JLabel("Hulpverlener");
			hulpverlenerLabel.setFont(new Font("Default", Font.PLAIN, 17));
			hulpverlenerLabel.setBounds(260, 130, 190, 20);
			pati�ntLabel = new JLabel("Pati�nt");
			pati�ntLabel.setFont(new Font("Default", Font.PLAIN, 17));
			pati�ntLabel.setBounds(260, 165, 190, 20);
			vragenlijstLabel = new JLabel("Vragenlijst");
			vragenlijstLabel.setFont(new Font("Default", Font.PLAIN, 17));
			vragenlijstLabel.setBounds(260, 200, 190, 20);
			aandoeningLabel = new JLabel("Aandoening");
			aandoeningLabel.setFont(new Font("Default", Font.PLAIN, 17));
			aandoeningLabel.setBounds(260, 235, 190, 20);
			pathologieLabel = new JLabel("Pathologie");
			pathologieLabel.setFont(new Font("Default", Font.PLAIN, 17));
			pathologieLabel.setBounds(260, 270, 190, 20);
			leeftijdPati�ntLabel = new JLabel("Leeftijdscat. pati�nt");
			leeftijdPati�ntLabel.setFont(new Font("Default", Font.PLAIN, 17));
			leeftijdPati�ntLabel.setBounds(260, 305, 190, 20);
			leeftijdMantelLabel = new JLabel("Leeftijdscat. mantelzorger");
			leeftijdMantelLabel.setFont(new Font("Default", Font.PLAIN, 17));
			leeftijdMantelLabel.setBounds(260, 340, 190, 20);
			hulpverlenerIngevuldLabel = new JLabel();
			hulpverlenerIngevuldLabel.setFont(new Font("Default", Font.PLAIN, 17));
			hulpverlenerIngevuldLabel.setBounds(470, 130, 250, 20);
			
			pati�ntVeld = new JTextField();
			pati�ntVeld.setBounds(470, 163, 250, 25);
			
			vragenlijstCombo = new JComboBox();
			vragenlijstCombo.setBounds(470, 198, 250, 25);
			aandoeningCombo = new JComboBox();
			aandoeningCombo.setBounds(470, 233, 250, 25);
			pathologieCombo = new JComboBox();
			pathologieCombo.setBounds(470, 268, 250, 25);
			leeftijdPati�ntCombo = new JComboBox();
			leeftijdPati�ntCombo.setBounds(470, 303, 250, 25);
			leeftijdMantelCombo = new JComboBox();
			leeftijdMantelCombo.setBounds(470, 338, 250, 25);
			
			versturen = new JButton("Vragenlijst versturen");
			versturen.setBounds(420, 400, 165, 30);
			
			add(titel);
			add(accountKnop);
			add(bevragingKnop);
			add(beheerKnop);
			add(resultatenKnop);
			add(uitlogKnop);
			add(hulpverlenerLabel);
			add(pati�ntLabel);
			add(vragenlijstLabel);
			add(aandoeningLabel);
			add(pathologieLabel);
			add(leeftijdPati�ntLabel);
			add(leeftijdMantelLabel);
			add(hulpverlenerIngevuldLabel);
			add(pati�ntVeld);
			add(vragenlijstCombo);
			add(aandoeningCombo);
			add(aandoeningCombo);
			add(pathologieCombo);
			add(leeftijdPati�ntCombo);
			add(leeftijdMantelCombo);
			add(versturen);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame newFrame = new JFrame();
			switch(e.getActionCommand()){
			case "Beheer":	newFrame = new BeheerGUI();
							NieuweBevragingGUI.this.setVisible(false);
							break;
			case "Account":	newFrame = new AccountGUI();
							NieuweBevragingGUI.this.setVisible(false);
							break;
			case "Resultaten":	newFrame = new ResultatenGUI();
								NieuweBevragingGUI.this.setVisible(false);
								break;
			case "Uitloggen":	newFrame = new LoginGUI();
								NieuweBevragingGUI.this.setVisible(false);
								break;
			}
			
		}		
	}
	
	public static void main(String[] args){
		NieuweBevragingGUI test = new NieuweBevragingGUI();
	}
	
}

