package panel;

import javax.swing.JPanel;

import controller.VisualizzaOfferteAgenteController;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import customElements.RoundedButton;
import dto.Offerta;
import starter.Starter;
import utils.S3Utils;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OffertaAgentePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Offerta offerta;
	private VisualizzaOfferteAgenteController visualizzaOfferteAgenteController;
	private String token;
	public OffertaAgentePanel(Offerta offerta,VisualizzaOfferteAgenteController controller,String token,Starter starter) {
		this.offerta=offerta;
		this.visualizzaOfferteAgenteController=controller;
		this.token=token;
		setBackground(new Color(220, 220, 220));
		setPreferredSize(new Dimension(700, 200));
		setMaximumSize(new Dimension(2000, 200));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{90, 20, 415, 191, 0};
		gridBagLayout.rowHeights = new int[]{20, 133, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIconFoto = new JLabel("");
		S3Utils s3Utils=new S3Utils();
		lblIconFoto.setIcon(s3Utils.getIconFromS3(offerta.getInserzione().getFoto()));
		GridBagConstraints gbc_lblIconFoto = new GridBagConstraints();
		gbc_lblIconFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconFoto.gridx = 0;
		gbc_lblIconFoto.gridy = 1;
		add(lblIconFoto, gbc_lblIconFoto);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{34, 37, 33, 33, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblInserzione = new JLabel("Inserzione: "+offerta.getInserzione().getTitolo());
		GridBagConstraints gbc_lblInserzione = new GridBagConstraints();
		gbc_lblInserzione.insets = new Insets(0, 0, 5, 0);
		gbc_lblInserzione.gridx = 0;
		gbc_lblInserzione.gridy = 0;
		panel.add(lblInserzione, gbc_lblInserzione);
		lblInserzione.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JLabel lblPrezzo = new JLabel("Prezzo: €"+offerta.getInserzione().getPrezzo());
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.gridx = 0;
		gbc_lblPrezzo.gridy = 1;
		panel.add(lblPrezzo, gbc_lblPrezzo);
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JLabel lblUtente = new JLabel("Utente: "+offerta.getUtente().getEmail());
		GridBagConstraints gbc_lblUtente = new GridBagConstraints();
		gbc_lblUtente.insets = new Insets(0, 0, 5, 0);
		gbc_lblUtente.anchor = GridBagConstraints.WEST;
		gbc_lblUtente.gridx = 0;
		gbc_lblUtente.gridy = 2;
		panel.add(lblUtente, gbc_lblUtente);
		lblUtente.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JLabel lblValore = new JLabel("Offerta: €"+offerta.getValore());
		GridBagConstraints gbc_lblValore = new GridBagConstraints();
		gbc_lblValore.anchor = GridBagConstraints.WEST;
		gbc_lblValore.gridx = 0;
		gbc_lblValore.gridy = 3;
		panel.add(lblValore, gbc_lblValore);
		lblValore.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{189, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0, 0, 0, 14, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		RoundedButton btnAccetta = new RoundedButton("Accetta", 30, 30);
		GridBagConstraints gbc_btnAccetta = new GridBagConstraints();
		gbc_btnAccetta.insets = new Insets(0, 0, 5, 0);
		gbc_btnAccetta.gridx = 0;
		gbc_btnAccetta.gridy = 1;
		panel_1.add(btnAccetta, gbc_btnAccetta);
		btnAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaOfferteAgenteController.aggiornaEsito(offerta, "accettata");
			}
		});
		btnAccetta.setText("    Accetta   ");
		btnAccetta.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAccetta.setBackground(new Color(255, 175, 68));
		
		RoundedButton btnControfferta = new RoundedButton("Controfferta", 30, 30);
		GridBagConstraints gbc_btnControfferta = new GridBagConstraints();
		gbc_btnControfferta.insets = new Insets(0, 0, 5, 0);
		gbc_btnControfferta.gridx = 0;
		gbc_btnControfferta.gridy = 2;
		panel_1.add(btnControfferta, gbc_btnControfferta);
		btnControfferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchVisualizzaOfferteToInserisciControfferta(offerta,token,visualizzaOfferteAgenteController);
			}
		});
		btnControfferta.setBackground(new Color(200, 200, 200));
		btnControfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		
		RoundedButton btnRifiuta = new RoundedButton("Rifiuta", 30, 30);
		GridBagConstraints gbc_btnRifiuta = new GridBagConstraints();
		gbc_btnRifiuta.insets = new Insets(0, 0, 5, 0);
		gbc_btnRifiuta.gridx = 0;
		gbc_btnRifiuta.gridy = 3;
		panel_1.add(btnRifiuta, gbc_btnRifiuta);
		btnRifiuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaOfferteAgenteController.aggiornaEsito(offerta, "rifiutata");
			}
		});
		btnRifiuta.setText("     Rifiuta    ");
		btnRifiuta.setMaximumSize(new Dimension(69, 22));
		btnRifiuta.setBackground(new Color(181, 180, 180));
		btnRifiuta.setFont(new Font("Arial", Font.PLAIN, 18));

	}

	public Offerta getOfferta() {
		return offerta;
	}

	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}

}
