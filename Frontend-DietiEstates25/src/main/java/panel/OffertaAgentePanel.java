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
		gridBagLayout.columnWidths = new int[]{20, 345, 140, 191, 0};
		gridBagLayout.rowHeights = new int[]{56, 20, 20, 20, 56, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblInserzione = new JLabel("Inserzione: "+offerta.getInserzione().getTitolo());
		lblInserzione.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblInserzione = new GridBagConstraints();
		gbc_lblInserzione.anchor = GridBagConstraints.WEST;
		gbc_lblInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_lblInserzione.gridx = 1;
		gbc_lblInserzione.gridy = 1;
		add(lblInserzione, gbc_lblInserzione);
		
		JLabel lblPrezzo = new JLabel("Prezzo: €"+offerta.getInserzione().getPrezzo());
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.gridx = 2;
		gbc_lblPrezzo.gridy = 1;
		add(lblPrezzo, gbc_lblPrezzo);
		
		RoundedButton btnAccetta = new RoundedButton("Accetta", 30, 30);
		btnAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaOfferteAgenteController.aggiornaEsito(offerta, "accettata");
			}
		});
		btnAccetta.setText("    Accetta   ");
		btnAccetta.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAccetta.setBackground(new Color(255, 175, 68));
		GridBagConstraints gbc_btnAccetta = new GridBagConstraints();
		gbc_btnAccetta.insets = new Insets(0, 0, 5, 0);
		gbc_btnAccetta.gridx = 3;
		gbc_btnAccetta.gridy = 1;
		add(btnAccetta, gbc_btnAccetta);
		
		JLabel lblUtente = new JLabel("Utente: "+offerta.getUtente().getEmail());
		lblUtente.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblUtente = new GridBagConstraints();
		gbc_lblUtente.anchor = GridBagConstraints.WEST;
		gbc_lblUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtente.gridx = 1;
		gbc_lblUtente.gridy = 2;
		add(lblUtente, gbc_lblUtente);
		
		RoundedButton btnControfferta = new RoundedButton("Controfferta", 30, 30);
		btnControfferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchVisualizzaOfferteToInserisciControfferta(offerta,token,visualizzaOfferteAgenteController);
			}
		});
		btnControfferta.setBackground(new Color(200, 200, 200));
		btnControfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnControfferta = new GridBagConstraints();
		gbc_btnControfferta.insets = new Insets(0, 0, 5, 0);
		gbc_btnControfferta.gridx = 3;
		gbc_btnControfferta.gridy = 2;
		add(btnControfferta, gbc_btnControfferta);
		
		JLabel lblValore = new JLabel("Offerta: €"+offerta.getValore());
		lblValore.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblValore = new GridBagConstraints();
		gbc_lblValore.anchor = GridBagConstraints.WEST;
		gbc_lblValore.insets = new Insets(0, 0, 5, 5);
		gbc_lblValore.gridx = 1;
		gbc_lblValore.gridy = 3;
		add(lblValore, gbc_lblValore);
		
		RoundedButton btnRifiuta = new RoundedButton("Rifiuta", 30, 30);
		btnRifiuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaOfferteAgenteController.aggiornaEsito(offerta, "rifiutata");
			}
		});
		btnRifiuta.setText("     Rifiuta    ");
		btnRifiuta.setMaximumSize(new Dimension(69, 22));
		btnRifiuta.setBackground(new Color(181, 180, 180));
		btnRifiuta.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnRifiuta = new GridBagConstraints();
		gbc_btnRifiuta.insets = new Insets(0, 0, 5, 0);
		gbc_btnRifiuta.gridx = 3;
		gbc_btnRifiuta.gridy = 3;
		add(btnRifiuta, gbc_btnRifiuta);

	}

	public Offerta getOfferta() {
		return offerta;
	}

	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}

}
