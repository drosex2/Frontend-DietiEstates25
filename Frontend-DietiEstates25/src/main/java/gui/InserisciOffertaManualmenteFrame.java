package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import customElements.RoundedButton;
import customElements.RoundedPasswordField;
import customElements.RoundedTextField;
import dto.Inserzione;
import utils.CredentialCheckerUtils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class InserisciOffertaManualmenteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pane1;
	private Inserzione inserzione;
	private JTextField textField;
	private JTextField textField_1;
	
	
	public InserisciOffertaManualmenteFrame() {
		
        JPanel panel = new JPanel();
		panel.setBackground(new Color(217, 217, 217));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
	
		JLabel lblTitolo = new JLabel("Titolo:");
		lblTitolo.setBackground(new Color(217, 217, 217));
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTitolo.setBounds(182, 163, 149, 14);
		panel.add(lblTitolo);
		
		JLabel valueTitolo = new JLabel(inserzione.getTitolo());
		valueTitolo.setFont(new Font("Arial", Font.PLAIN, 18));
		valueTitolo.setBounds(288, 145, 110, 51);
		panel.add(valueTitolo);
		
		JLabel lblPrezzoIniziale = new JLabel("Prezzo iniziale:");
		lblPrezzoIniziale.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPrezzoIniziale.setBounds(182, 207, 149, 14);
		panel.add(lblPrezzoIniziale);
		
		
		JLabel valuePrezzo = new JLabel("€000");
		valuePrezzo.setFont(new Font("Arial", Font.PLAIN, 18));
		valuePrezzo.setBounds(355, 207, 49, 14);
		panel.add(valuePrezzo);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(355, 249, 167, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email utente:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(182, 252, 134, 14);
		panel.add(lblEmail);
		
		JLabel lblOfferta = new JLabel("Prezzo offerto:");
		lblOfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		lblOfferta.setBounds(182, 308, 134, 14);
		panel.add(lblOfferta);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(355, 307, 167, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new RoundedButton("Inserisci offerta", 30, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 175, 68));
		btnNewButton.setBounds(182, 367, 161, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new RoundedButton("Annulla", 30, 30);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(398, 367, 124, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("INSERISCI OFFERTA MANUALMENTE");
		lblNewJgoodiesTitle.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewJgoodiesTitle.setBounds(237, 120, 324, 14);
		panel.add(lblNewJgoodiesTitle);
		
		
		
		
		
		
		
	}
}
