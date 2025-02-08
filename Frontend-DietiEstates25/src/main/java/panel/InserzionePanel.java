package panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class InserzionePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public InserzionePanel() {
		setBackground(new Color(217, 217, 217));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 131, 0, 393, 127, 0};
		gridBagLayout.rowHeights = new int[]{120, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 2.0, 1.0, Double.MIN_VALUE};
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
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblVuota = new JLabel("      ");
		GridBagConstraints gbc_lblVuota = new GridBagConstraints();
		gbc_lblVuota.insets = new Insets(0, 0, 5, 5);
		gbc_lblVuota.gridx = 1;
		gbc_lblVuota.gridy = 0;
		panel.add(lblVuota, gbc_lblVuota);
		
		JLabel lblDimensioni = new JLabel("Dimensioni:");
		lblDimensioni.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDimensioni = new GridBagConstraints();
		gbc_lblDimensioni.anchor = GridBagConstraints.WEST;
		gbc_lblDimensioni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDimensioni.gridx = 1;
		gbc_lblDimensioni.gridy = 1;
		panel.add(lblDimensioni, gbc_lblDimensioni);
		
		JLabel valueDimensioni = new JLabel("value");
		valueDimensioni.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valueDimensioni = new GridBagConstraints();
		gbc_valueDimensioni.anchor = GridBagConstraints.WEST;
		gbc_valueDimensioni.insets = new Insets(0, 0, 5, 0);
		gbc_valueDimensioni.gridx = 2;
		gbc_valueDimensioni.gridy = 1;
		panel.add(valueDimensioni, gbc_valueDimensioni);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.gridx = 1;
		gbc_lblPrezzo.gridy = 2;
		panel.add(lblPrezzo, gbc_lblPrezzo);
		
		JLabel valuePrezzo = new JLabel("value");
		valuePrezzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valuePrezzo = new GridBagConstraints();
		gbc_valuePrezzo.anchor = GridBagConstraints.WEST;
		gbc_valuePrezzo.insets = new Insets(0, 0, 5, 0);
		gbc_valuePrezzo.gridx = 2;
		gbc_valuePrezzo.gridy = 2;
		panel.add(valuePrezzo, gbc_valuePrezzo);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndirizzo.anchor = GridBagConstraints.WEST;
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 3;
		panel.add(lblIndirizzo, gbc_lblIndirizzo);
		
		JLabel valueIndirizzo = new JLabel("value");
		valueIndirizzo.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_valueIndirizzo = new GridBagConstraints();
		gbc_valueIndirizzo.anchor = GridBagConstraints.WEST;
		gbc_valueIndirizzo.insets = new Insets(0, 0, 5, 0);
		gbc_valueIndirizzo.gridx = 2;
		gbc_valueIndirizzo.gridy = 3;
		panel.add(valueIndirizzo, gbc_valueIndirizzo);
		
		JLabel lblVuota2 = new JLabel("         ");
		GridBagConstraints gbc_lblVuota2 = new GridBagConstraints();
		gbc_lblVuota2.insets = new Insets(0, 0, 0, 5);
		gbc_lblVuota2.gridx = 1;
		gbc_lblVuota2.gridy = 4;
		panel.add(lblVuota2, gbc_lblVuota2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{39, 0, 0, 39, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBackground(new Color(255, 175, 68));
		btnModifica.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnModifica = new GridBagConstraints();
		gbc_btnModifica.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifica.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifica.gridx = 0;
		gbc_btnModifica.gridy = 1;
		panel_1.add(btnModifica, gbc_btnModifica);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setMaximumSize(new Dimension(71, 23));
		btnElimina.setFont(new Font("Arial", Font.PLAIN, 18));
		btnElimina.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_btnElimina = new GridBagConstraints();
		gbc_btnElimina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnElimina.insets = new Insets(0, 0, 5, 5);
		gbc_btnElimina.gridx = 0;
		gbc_btnElimina.gridy = 2;
		panel_1.add(btnElimina, gbc_btnElimina);

	}

}
