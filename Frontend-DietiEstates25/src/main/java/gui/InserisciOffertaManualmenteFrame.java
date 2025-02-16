package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import customElements.RoundedButton;
import customElements.RoundedTextField;
import dto.Inserzione;
import starter.Starter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciOffertaManualmenteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Inserzione inserzione;
	private JTextField TFemail;
	private JTextField TFofferta;
	private Starter starter;

	
	public InserisciOffertaManualmenteFrame() {
		
		JPanel InserisciOfferta = new JPanel();
		InserisciOfferta.setBackground(new Color(217, 217, 217));
		getContentPane().add(InserisciOfferta, BorderLayout.CENTER);
		InserisciOfferta.setLayout(null);
		
		JPanel NavBar = new JPanel();
		NavBar.setBackground(new Color(6, 128, 180));
		NavBar.setBounds(0, 0, 886, 97);
		InserisciOfferta.add(NavBar);
		
		NavBar.setLayout(null);
		JLabel imageIcon = new JLabel("");
		imageIcon.setBounds(0, 11, 80, 80);
		NavBar.add(imageIcon);
		imageIcon.setIcon(new ImageIcon(LoginFrame.class.getResource("/DietiEstates25/client/gui/images/logoFigma80.png")));
		GridBagConstraints gbc_imageIcon = new GridBagConstraints();
		gbc_imageIcon.fill = GridBagConstraints.VERTICAL;
		
		JLabel lblNewLabel = new JLabel("DietiEstates25");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setBounds(90, 33, 168, 30);
		NavBar.add(lblNewLabel);
		JLabel lblTitolo = new JLabel("Titolo:");
		lblTitolo.setBounds(227, 122, 60, 41);
		lblTitolo.setBackground(new Color(217, 217, 217));
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(lblTitolo);
		
		JLabel valueTitolo = new JLabel(inserzione.getTitolo());
		valueTitolo.setBounds(297, 122, 144, 41);
		valueTitolo.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(valueTitolo);
		
		JLabel lblPrezzoIniziale = new JLabel("Prezzo iniziale:");
		lblPrezzoIniziale.setBounds(227, 174, 127, 41);
		lblPrezzoIniziale.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(lblPrezzoIniziale);
		
		JLabel valuePrezzo = new JLabel("€000");
		valuePrezzo.setBounds(366, 174, 144, 41);
		valuePrezzo.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(valuePrezzo);
		
		JLabel lblEmail = new JLabel("Email utente:");
		lblEmail.setBounds(227, 226, 111, 41);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(lblEmail);
		
		TFemail = new RoundedTextField(30,30,30);
		TFemail.setBounds(366, 234, 170, 24);
		TFemail.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(TFemail);
		TFemail.setColumns(10);
		
		JLabel lblOfferta = new JLabel("Prezzo offerto:");
		lblOfferta.setBounds(227, 278, 127, 41);
		lblOfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(lblOfferta);
		
		TFofferta = new RoundedTextField(30,30,30);
		TFofferta.setBounds(366, 286, 170, 24);
		TFofferta.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(TFofferta);
		TFofferta.setColumns(10);
		
		JButton btnInserisciOfferta = new RoundedButton("Inserisci offerta", 30, 30);
		btnInserisciOfferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserisciOfferta.setBounds(227, 348, 144, 30);
		btnInserisciOfferta.setBackground(new Color(255, 175, 68));
		btnInserisciOfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(btnInserisciOfferta);
		
		JButton btnAnnulla = new RoundedButton("Annulla", 30, 30);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnnulla.setBounds(425, 348, 111, 30);
		btnAnnulla.setBackground(new Color(192, 192, 192));
		btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 18));
		InserisciOfferta.add(btnAnnulla);
		
		
		
		
		
		
		
		
		
		


		
		
		
		
		
		
		
		
	}
}
