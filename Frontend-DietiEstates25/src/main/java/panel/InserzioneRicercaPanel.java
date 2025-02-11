package panel;

import javax.swing.JPanel;

import customElements.RoundedButton;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

public class InserzioneRicercaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public InserzioneRicercaPanel() {
		setBackground(new Color(217, 217, 217));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 131, 0, 513, 127, 0};
		gridBagLayout.rowHeights = new int[]{120, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIconFoto = new JLabel("Foto");
		GridBagConstraints gbc_lblIconFoto = new GridBagConstraints();
		gbc_lblIconFoto.insets = new Insets(0, 0, 0, 5);
		gbc_lblIconFoto.gridx = 1;
		gbc_lblIconFoto.gridy = 0;
		add(lblIconFoto, gbc_lblIconFoto);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 103, 138, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblVuota = new JLabel("      ");
		GridBagConstraints gbc_lblVuota = new GridBagConstraints();
		gbc_lblVuota.insets = new Insets(0, 0, 5, 5);
		gbc_lblVuota.gridx = 1;
		gbc_lblVuota.gridy = 0;
		panel.add(lblVuota, gbc_lblVuota);
		
		JLabel lblTitolo = new JLabel("Titolo:");
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitolo = new GridBagConstraints();
		gbc_lblTitolo.anchor = GridBagConstraints.WEST;
		gbc_lblTitolo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitolo.gridx = 1;
		gbc_lblTitolo.gridy = 1;
		panel.add(lblTitolo, gbc_lblTitolo);
		
		JLabel valueTitolo = new JLabel("value");
		valueTitolo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valueTitolo = new GridBagConstraints();
		gbc_valueTitolo.anchor = GridBagConstraints.WEST;
		gbc_valueTitolo.insets = new Insets(0, 0, 5, 0);
		gbc_valueTitolo.gridx = 2;
		gbc_valueTitolo.gridy = 1;
		panel.add(valueTitolo, gbc_valueTitolo);
		
		JLabel lblDimensioni = new JLabel("Dimensioni:");
		lblDimensioni.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDimensioni = new GridBagConstraints();
		gbc_lblDimensioni.anchor = GridBagConstraints.WEST;
		gbc_lblDimensioni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDimensioni.gridx = 1;
		gbc_lblDimensioni.gridy = 2;
		panel.add(lblDimensioni, gbc_lblDimensioni);
		
		JLabel valueDimensioni = new JLabel("value");
		valueDimensioni.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valueDimensioni = new GridBagConstraints();
		gbc_valueDimensioni.anchor = GridBagConstraints.WEST;
		gbc_valueDimensioni.insets = new Insets(0, 0, 5, 0);
		gbc_valueDimensioni.gridx = 2;
		gbc_valueDimensioni.gridy = 2;
		panel.add(valueDimensioni, gbc_valueDimensioni);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.gridx = 1;
		gbc_lblPrezzo.gridy = 3;
		panel.add(lblPrezzo, gbc_lblPrezzo);
		
		JLabel valuePrezzo = new JLabel("value");
		valuePrezzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valuePrezzo = new GridBagConstraints();
		gbc_valuePrezzo.anchor = GridBagConstraints.WEST;
		gbc_valuePrezzo.insets = new Insets(0, 0, 5, 0);
		gbc_valuePrezzo.gridx = 2;
		gbc_valuePrezzo.gridy = 3;
		panel.add(valuePrezzo, gbc_valuePrezzo);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndirizzo.anchor = GridBagConstraints.WEST;
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 4;
		panel.add(lblIndirizzo, gbc_lblIndirizzo);
		
		JLabel valueIndirizzo = new JLabel("value");
		valueIndirizzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valueIndirizzo = new GridBagConstraints();
		gbc_valueIndirizzo.anchor = GridBagConstraints.WEST;
		gbc_valueIndirizzo.insets = new Insets(0, 0, 5, 0);
		gbc_valueIndirizzo.gridx = 2;
		gbc_valueIndirizzo.gridy = 4;
		panel.add(valueIndirizzo, gbc_valueIndirizzo);
		
		JLabel lblNewLabel = new JLabel("Città:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel valueCitta = new JLabel("value");
		valueCitta.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valueCitta = new GridBagConstraints();
		gbc_valueCitta.anchor = GridBagConstraints.WEST;
		gbc_valueCitta.insets = new Insets(0, 0, 5, 0);
		gbc_valueCitta.gridx = 2;
		gbc_valueCitta.gridy = 5;
		panel.add(valueCitta, gbc_valueCitta);
		
		JLabel lblVuota2 = new JLabel("         ");
		GridBagConstraints gbc_lblVuota2 = new GridBagConstraints();
		gbc_lblVuota2.insets = new Insets(0, 0, 0, 5);
		gbc_lblVuota2.gridx = 1;
		gbc_lblVuota2.gridy = 6;
		panel.add(lblVuota2, gbc_lblVuota2);
		
		JButton btnDettagli = new RoundedButton("Dettagli",30,30);
		btnDettagli.setBackground(new Color(255, 175, 68));
		btnDettagli.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnDettagli = new GridBagConstraints();
		gbc_btnDettagli.gridx = 4;
		gbc_btnDettagli.gridy = 0;
		add(btnDettagli, gbc_btnDettagli);

	}

}
