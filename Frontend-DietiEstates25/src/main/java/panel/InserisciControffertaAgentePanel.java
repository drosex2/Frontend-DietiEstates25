package panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;

import customElements.RoundedButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class InserisciControffertaAgentePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtContrrofferta;

	/**
	 * Create the panel.
	 */
	public InserisciControffertaAgentePanel() {
		setBackground(new Color(220, 220, 220));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 345, 140, 191, 0};
		gridBagLayout.rowHeights = new int[]{56, 20, 20, 20, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblInserzione = new JLabel("Inserzione: <dynamic>");
		lblInserzione.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblInserzione = new GridBagConstraints();
		gbc_lblInserzione.anchor = GridBagConstraints.WEST;
		gbc_lblInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_lblInserzione.gridx = 1;
		gbc_lblInserzione.gridy = 1;
		add(lblInserzione, gbc_lblInserzione);
		
		JLabel lblPrezzo = new JLabel("Prezzo: €0");
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.gridx = 2;
		gbc_lblPrezzo.gridy = 1;
		add(lblPrezzo, gbc_lblPrezzo);
		
		RoundedButton btnInvia = new RoundedButton("Invia", 30, 30);
		btnInvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInvia.setText("    Invia    ");
		btnInvia.setFont(new Font("Arial", Font.PLAIN, 18));
		btnInvia.setBackground(new Color(255, 175, 68));
		GridBagConstraints gbc_btnInvia = new GridBagConstraints();
		gbc_btnInvia.insets = new Insets(0, 0, 5, 0);
		gbc_btnInvia.gridx = 3;
		gbc_btnInvia.gridy = 1;
		add(btnInvia, gbc_btnInvia);
		
		JLabel lblUtente = new JLabel("Utente: <dynamic>");
		lblUtente.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblUtente = new GridBagConstraints();
		gbc_lblUtente.anchor = GridBagConstraints.WEST;
		gbc_lblUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtente.gridx = 1;
		gbc_lblUtente.gridy = 2;
		add(lblUtente, gbc_lblUtente);
		
		JLabel lblNewLabel = new JLabel("Controfferta");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		RoundedButton btnAnnulla = new RoundedButton("Annulla", 30, 30);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAnnulla.setText("  Annulla ");
		btnAnnulla.setMaximumSize(new Dimension(69, 22));
		btnAnnulla.setBackground(new Color(181, 180, 180));
		btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnnulla.gridx = 3;
		gbc_btnAnnulla.gridy = 2;
		add(btnAnnulla, gbc_btnAnnulla);
		
		JLabel lblValore = new JLabel("Offerta: €0");
		lblValore.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblValore = new GridBagConstraints();
		gbc_lblValore.anchor = GridBagConstraints.WEST;
		gbc_lblValore.insets = new Insets(0, 0, 5, 5);
		gbc_lblValore.gridx = 1;
		gbc_lblValore.gridy = 3;
		add(lblValore, gbc_lblValore);
		
		txtContrrofferta = new JTextField();
		txtContrrofferta.setText("00.00");
		GridBagConstraints gbc_txtContrrofferta = new GridBagConstraints();
		gbc_txtContrrofferta.anchor = GridBagConstraints.NORTH;
		gbc_txtContrrofferta.insets = new Insets(0, 0, 5, 5);
		gbc_txtContrrofferta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContrrofferta.gridx = 2;
		gbc_txtContrrofferta.gridy = 3;
		add(txtContrrofferta, gbc_txtContrrofferta);
		txtContrrofferta.setColumns(10);

	}

}
