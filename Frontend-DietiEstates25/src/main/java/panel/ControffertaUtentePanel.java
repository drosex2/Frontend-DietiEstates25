package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.VisualizzaControfferteUtenteController;
import customElements.RoundedButton;
import dto.Controfferta;
import starter.Starter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ControffertaUtentePanel extends JPanel {
	private Controfferta controfferta;
	private VisualizzaControfferteUtenteController visualizzaControfferteUtenteController;
	private Starter starter;
	private String token;
	
	public ControffertaUtentePanel(Controfferta controfferta, VisualizzaControfferteUtenteController visualizzaControfferteUtenteController, String token, Starter starter) {
		this.controfferta=controfferta;
		this.visualizzaControfferteUtenteController=visualizzaControfferteUtenteController;
		this.starter=starter;
		this.token=token;
		setBackground(new Color(220, 220, 220));
		setPreferredSize(new Dimension(700, 200));
		setMaximumSize(new Dimension(2000, 200));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 345, 140, 157, 0};
		gridBagLayout.rowHeights = new int[]{56, 20, 20, 20, 56, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblInserzione = new JLabel("Inserzione: "+controfferta.getInserzione().getTitolo());
		lblInserzione.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblInserzione = new GridBagConstraints();
		gbc_lblInserzione.anchor = GridBagConstraints.WEST;
		gbc_lblInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_lblInserzione.gridx = 1;
		gbc_lblInserzione.gridy = 1;
		add(lblInserzione, gbc_lblInserzione);
		
		JLabel lblNewLabel = new JLabel("Prezzo: €"+controfferta.getInserzione().getPrezzo()+" ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		RoundedButton btnAccetta = new RoundedButton("Accetta", 30, 30);
		btnAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaControfferteUtenteController.aggiornaEsito(controfferta, "accettata");
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
		
		JLabel lblAgente = new JLabel("Agente: "+controfferta.getAgente().getEmail());
		lblAgente.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblAgente = new GridBagConstraints();
		gbc_lblAgente.anchor = GridBagConstraints.WEST;
		gbc_lblAgente.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgente.gridx = 1;
		gbc_lblAgente.gridy = 2;
		add(lblAgente, gbc_lblAgente);
		
		JLabel lblValore = new JLabel("Controfferta: €"+controfferta.getValore());
		lblValore.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblValore = new GridBagConstraints();
		gbc_lblValore.anchor = GridBagConstraints.WEST;
		gbc_lblValore.insets = new Insets(0, 0, 5, 5);
		gbc_lblValore.gridx = 1;
		gbc_lblValore.gridy = 3;
		add(lblValore, gbc_lblValore);
		
		RoundedButton rndbtnAccetta = new RoundedButton("Rifiuta", 30, 30);
		rndbtnAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaControfferteUtenteController.aggiornaEsito(controfferta, "rifiutata");
			}
		});
		rndbtnAccetta.setText("     Rifiuta    ");
		rndbtnAccetta.setMaximumSize(new Dimension(69, 22));
		rndbtnAccetta.setBackground(new Color(181, 180, 180));
		rndbtnAccetta.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_rndbtnAccetta = new GridBagConstraints();
		gbc_rndbtnAccetta.insets = new Insets(0, 0, 5, 0);
		gbc_rndbtnAccetta.gridx = 3;
		gbc_rndbtnAccetta.gridy = 3;
		add(rndbtnAccetta, gbc_rndbtnAccetta);

	}

}
