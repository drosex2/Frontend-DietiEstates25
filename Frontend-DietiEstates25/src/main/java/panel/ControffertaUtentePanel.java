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
import utils.S3Utils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ControffertaUtentePanel extends JPanel {
	private Controfferta controfferta;
	private VisualizzaControfferteUtenteController visualizzaControfferteUtenteController;
	private Starter starter;
	private String token;
	
	public ControffertaUtentePanel(Controfferta pControfferta, VisualizzaControfferteUtenteController pVisualizzaControfferteUtenteController, String pToken, Starter pStarter) {
		this.controfferta=pControfferta;
		this.visualizzaControfferteUtenteController=pVisualizzaControfferteUtenteController;
		this.setStarter(pStarter);
		this.setToken(pToken);
		setBackground(new Color(220, 220, 220));
		setPreferredSize(new Dimension(700, 200));
		setMaximumSize(new Dimension(2000, 200));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{109, 20, 420, 143, 0};
		gridBagLayout.rowHeights = new int[]{33, 134, 22, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
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
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{38, 31, 37, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTitolo = new JLabel("Inserzione:"+controfferta.getInserzione().getTitolo());
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTitolo = new GridBagConstraints();
		gbc_lblTitolo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitolo.gridx = 0;
		gbc_lblTitolo.gridy = 0;
		panel.add(lblTitolo, gbc_lblTitolo);
		
		JLabel lblPrezzo = new JLabel("Prezzo: €"+controfferta.getInserzione().getPrezzo());
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrezzo.gridx = 0;
		gbc_lblPrezzo.gridy = 1;
		panel.add(lblPrezzo, gbc_lblPrezzo);
		
		JLabel lblAgente = new JLabel("Agente: "+controfferta.getAgente().getEmail());
		lblAgente.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblAgente = new GridBagConstraints();
		gbc_lblAgente.anchor = GridBagConstraints.WEST;
		gbc_lblAgente.insets = new Insets(0, 0, 5, 0);
		gbc_lblAgente.gridx = 0;
		gbc_lblAgente.gridy = 2;
		panel.add(lblAgente, gbc_lblAgente);
		
		JLabel lblControfferta = new JLabel("Controfferta: €"+controfferta.getValore());
		lblControfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblControfferta = new GridBagConstraints();
		gbc_lblControfferta.anchor = GridBagConstraints.WEST;
		gbc_lblControfferta.gridx = 0;
		gbc_lblControfferta.gridy = 3;
		panel.add(lblControfferta, gbc_lblControfferta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{157, 0};
		gbl_panel_1.rowHeights = new int[]{30, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		RoundedButton btnAccetta = new RoundedButton("Accetta", 30, 30);
		GridBagConstraints gbc_btnAccetta = new GridBagConstraints();
		gbc_btnAccetta.insets = new Insets(0, 0, 5, 0);
		gbc_btnAccetta.anchor = GridBagConstraints.NORTH;
		gbc_btnAccetta.gridx = 0;
		gbc_btnAccetta.gridy = 1;
		panel_1.add(btnAccetta, gbc_btnAccetta);
		btnAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaControfferteUtenteController.aggiornaEsito(controfferta, "accettata");
			}
		});
		btnAccetta.setText("    Accetta   ");
		btnAccetta.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAccetta.setBackground(new Color(255, 175, 68));
		
		RoundedButton rndbtnAccetta = new RoundedButton("Rifiuta", 30, 30);
		GridBagConstraints gbc_rndbtnAccetta = new GridBagConstraints();
		gbc_rndbtnAccetta.gridx = 0;
		gbc_rndbtnAccetta.gridy = 2;
		panel_1.add(rndbtnAccetta, gbc_rndbtnAccetta);
		rndbtnAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizzaControfferteUtenteController.aggiornaEsito(controfferta, "rifiutata");
			}
		});
		rndbtnAccetta.setText("     Rifiuta    ");
		rndbtnAccetta.setMaximumSize(new Dimension(69, 22));
		rndbtnAccetta.setBackground(new Color(181, 180, 180));
		rndbtnAccetta.setFont(new Font("Arial", Font.PLAIN, 18));

	}

	public Starter getStarter() {
		return starter;
	}

	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
