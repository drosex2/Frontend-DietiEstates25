package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


import dto.Controfferta;
import utils.S3Utils;

public class ControffertaAgentePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controfferta controfferta;
	
	public ControffertaAgentePanel(Controfferta controfferta) {
		this.controfferta=controfferta;
		setBackground(new Color(220, 220, 220));
		setPreferredSize(new Dimension(700, 200));
		setMaximumSize(new Dimension(800, 200));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{106, 20, 397, 66, 75, 0};
		gridBagLayout.rowHeights = new int[]{24, 143, 24, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		Border bordo = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JLabel lblIconFoto = new JLabel("");
		S3Utils s3Utils=new S3Utils();
		lblIconFoto.setIcon(s3Utils.getIconFromS3(controfferta.getInserzione().getFoto()));
		GridBagConstraints gbc_lblIconFoto = new GridBagConstraints();
		gbc_lblIconFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconFoto.gridx = 0;
		gbc_lblIconFoto.gridy = 1;
		add(lblIconFoto, gbc_lblIconFoto);
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{375, 0};
		gbl_panel.rowHeights = new int[]{43, 35, 35, 34, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel titoloInserzione = new JLabel("Inserzione: "+controfferta.getInserzione().getTitolo());
		GridBagConstraints gbc_titoloInserzione = new GridBagConstraints();
		gbc_titoloInserzione.anchor = GridBagConstraints.WEST;
		gbc_titoloInserzione.insets = new Insets(0, 0, 5, 0);
		gbc_titoloInserzione.gridx = 0;
		gbc_titoloInserzione.gridy = 0;
		panel.add(titoloInserzione, gbc_titoloInserzione);
		titoloInserzione.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblPrezzo = new JLabel("Prezzo: €"+controfferta.getInserzione().getPrezzo()+" ");
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrezzo.gridx = 0;
		gbc_lblPrezzo.gridy = 1;
		panel.add(lblPrezzo, gbc_lblPrezzo);
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel emailUtente = new JLabel("Utente: "+controfferta.getUtente().getEmail());
		GridBagConstraints gbc_emailUtente = new GridBagConstraints();
		gbc_emailUtente.anchor = GridBagConstraints.WEST;
		gbc_emailUtente.insets = new Insets(0, 0, 5, 0);
		gbc_emailUtente.gridx = 0;
		gbc_emailUtente.gridy = 2;
		panel.add(emailUtente, gbc_emailUtente);
		emailUtente.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel valoreOfferta = new JLabel("Controfferta: €"+controfferta.getValore());
		GridBagConstraints gbc_valoreOfferta = new GridBagConstraints();
		gbc_valoreOfferta.anchor = GridBagConstraints.WEST;
		gbc_valoreOfferta.gridx = 0;
		gbc_valoreOfferta.gridy = 3;
		panel.add(valoreOfferta, gbc_valoreOfferta);
		valoreOfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblEsito = new JLabel("Esito:");
		lblEsito.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEsito = new GridBagConstraints();
		gbc_lblEsito.anchor = GridBagConstraints.EAST;
		gbc_lblEsito.insets = new Insets(0, 0, 5, 5);
		gbc_lblEsito.gridx = 3;
		gbc_lblEsito.gridy = 1;
		add(lblEsito, gbc_lblEsito);
		String esito=controfferta.getEsito();
		JLabel esitoValue = new JLabel(esito);
		if(esito.equals("in attesa")) {
			esitoValue.setForeground(Color.BLACK);
		}else if(esito.equals("accettata")) {
			esitoValue.setForeground(new Color(0, 128, 0));
		}else {
			esitoValue.setForeground(new Color(200, 0, 0));

		}
		
		esitoValue.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_esitoValue = new GridBagConstraints();
		gbc_esitoValue.anchor = GridBagConstraints.WEST;
		gbc_esitoValue.insets = new Insets(0, 0, 5, 0);
		gbc_esitoValue.gridx = 4;
		gbc_esitoValue.gridy = 1;
		add(esitoValue, gbc_esitoValue);
	}

}
