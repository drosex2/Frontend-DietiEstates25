package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.VisualizzaOfferteAgenteController;
import customElements.RoundedButton;
import dto.Offerta;
import starter.Starter;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import customElements.RoundedFormattedTextField;
import javax.swing.text.NumberFormatter;

public class InserisciControffertaFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Starter starter;
	private JPanel panePrincipale;
	private String token;
	private Offerta offerta;
	private VisualizzaOfferteAgenteController visualizzaOfferteAgenteController;
	public InserisciControffertaFrame(Starter starter,Offerta offerta,String token,VisualizzaOfferteAgenteController visualizzaOfferteAgenteController) {
		this.starter=starter;
		this.token=token;
		this.offerta=offerta;
		this.visualizzaOfferteAgenteController=visualizzaOfferteAgenteController;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(217, 217, 217));
		setTitle("Inserisci Controfferta");
	
		setContentPane(panePrincipale);
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[]{881, 0};
		gbl_panePrincipale.rowHeights = new int[]{97, 368, 40, 0};
		gbl_panePrincipale.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panePrincipale.rowWeights = new double[]{1.0, 10.0, 0.0, Double.MIN_VALUE};
		panePrincipale.setLayout(gbl_panePrincipale);
		
		JPanel navBar = new JPanel();
		navBar.setBackground(new Color(6,128,180));
		GridBagConstraints gbc_navBar = new GridBagConstraints();
		gbc_navBar.fill = GridBagConstraints.BOTH;
		gbc_navBar.insets = new Insets(0, 0, 5, 0);
		gbc_navBar.gridx = 0;
		gbc_navBar.gridy = 0;
		panePrincipale.add(navBar, gbc_navBar);
		GridBagLayout gbl_navBar = new GridBagLayout();
		gbl_navBar.columnWidths = new int[]{84, 293, 502, 0};
		gbl_navBar.rowHeights = new int[]{104, 0};
		gbl_navBar.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_navBar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		navBar.setLayout(gbl_navBar);
		
		JLabel logoImage = new JLabel("");
		
	
		logoImage.setIcon(new ImageIcon(LoginFrame.class.getResource("/DietiEstates25/client/gui/images/logoFigma80.png")));
		GridBagConstraints gbc_logoImage = new GridBagConstraints();
		gbc_logoImage.fill = GridBagConstraints.VERTICAL;
		gbc_logoImage.insets = new Insets(0, 0, 0, 5);
		gbc_logoImage.gridx = 0;
		gbc_logoImage.gridy = 0;
		navBar.add(logoImage, gbc_logoImage);
		
		JLabel lblTitle = new JLabel("DietiEstates25");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 22));
		lblTitle.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitle.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		navBar.add(lblTitle, gbc_lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panePrincipale.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 100, 100, 0};
		gbl_panel.rowHeights = new int[]{363, 0};
		gbl_panel.columnWeights = new double[]{5.0, 0.0, 5.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_formPanel = new GridBagConstraints();
		gbc_formPanel.insets = new Insets(0, 0, 0, 5);
		gbc_formPanel.fill = GridBagConstraints.BOTH;
		gbc_formPanel.gridx = 1;
		gbc_formPanel.gridy = 0;
		panel.add(formPanel, gbc_formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[]{74, 779, 74, 0};
		gbl_formPanel.rowHeights = new int[]{20, 0, 400, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel lblWelcome = new JLabel("Inserisci Contofferta");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 32));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 1;
		formPanel.add(lblWelcome, gbc_lblWelcome);
		
		JPanel formPanelInterno = new JPanel();
		formPanelInterno.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_formPanelInterno = new GridBagConstraints();
		gbc_formPanelInterno.insets = new Insets(0, 0, 0, 5);
		gbc_formPanelInterno.fill = GridBagConstraints.BOTH;
		gbc_formPanelInterno.gridx = 1;
		gbc_formPanelInterno.gridy = 2;
		formPanel.add(formPanelInterno, gbc_formPanelInterno);
		GridBagLayout gbl_formPanelInterno = new GridBagLayout();
		gbl_formPanelInterno.columnWidths = new int[]{306, 354, 321, 0};
		gbl_formPanelInterno.rowHeights = new int[]{30, 40, 30, 40, 30, 40, 30, 40, 0, 0, 15, 30, 0};
		gbl_formPanelInterno.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_formPanelInterno.rowWeights = new double[]{2.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanelInterno.setLayout(gbl_formPanelInterno);
		RoundedButton btnCrea = new RoundedButton("Crea",30,30);
		JLabel lblTitoloInserzione = new JLabel("Titolo inserzione");
		lblTitoloInserzione.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblTitoloInserzione = new GridBagConstraints();
		gbc_lblTitoloInserzione.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTitoloInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitoloInserzione.gridx = 1;
		gbc_lblTitoloInserzione.gridy = 0;
		formPanelInterno.add(lblTitoloInserzione, gbc_lblTitoloInserzione);
		
		
		JLabel titoloValue = new JLabel(offerta.getInserzione().getTitolo());
		titoloValue.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_titoloValue = new GridBagConstraints();
		gbc_titoloValue.anchor = GridBagConstraints.NORTHWEST;
		gbc_titoloValue.insets = new Insets(0, 0, 5, 5);
		gbc_titoloValue.gridx = 1;
		gbc_titoloValue.gridy = 1;
		formPanelInterno.add(titoloValue, gbc_titoloValue);
		
		JLabel lblEmailUtente = new JLabel("Email Utente");
		lblEmailUtente.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblEmailUtente = new GridBagConstraints();
		gbc_lblEmailUtente.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEmailUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailUtente.gridx = 1;
		gbc_lblEmailUtente.gridy = 2;
		formPanelInterno.add(lblEmailUtente, gbc_lblEmailUtente);
		
		JLabel emailUtenteValue = new JLabel(offerta.getUtente().getEmail());
		emailUtenteValue.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_emailUtenteValue = new GridBagConstraints();
		gbc_emailUtenteValue.anchor = GridBagConstraints.NORTHWEST;
		gbc_emailUtenteValue.insets = new Insets(0, 0, 5, 5);
		gbc_emailUtenteValue.gridx = 1;
		gbc_emailUtenteValue.gridy = 3;
		formPanelInterno.add(emailUtenteValue, gbc_emailUtenteValue);
		
		JLabel lblOfferta = new JLabel("Offerta");
		lblOfferta.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblOfferta = new GridBagConstraints();
		gbc_lblOfferta.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblOfferta.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfferta.gridx = 1;
		gbc_lblOfferta.gridy = 4;
		formPanelInterno.add(lblOfferta, gbc_lblOfferta);
		
		JLabel offertaValue = new JLabel("€"+ offerta.getValore());
		offertaValue.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_offertaValue = new GridBagConstraints();
		gbc_offertaValue.anchor = GridBagConstraints.NORTHWEST;
		gbc_offertaValue.insets = new Insets(0, 0, 5, 5);
		gbc_offertaValue.gridx = 1;
		gbc_offertaValue.gridy = 5;
		formPanelInterno.add(offertaValue, gbc_offertaValue);
		
		JLabel lblPrezzoInserzione = new JLabel("Prezzo Iniziale");
		lblPrezzoInserzione.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPrezzoInserzione = new GridBagConstraints();
		gbc_lblPrezzoInserzione.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPrezzoInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzoInserzione.gridx = 1;
		gbc_lblPrezzoInserzione.gridy = 6;
		formPanelInterno.add(lblPrezzoInserzione, gbc_lblPrezzoInserzione);
		
		JLabel valuePrezzoInserzione = new JLabel("€"+ offerta.getInserzione().getPrezzo());
		valuePrezzoInserzione.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_valuePrezzoInserzione = new GridBagConstraints();
		gbc_valuePrezzoInserzione.anchor = GridBagConstraints.NORTHWEST;
		gbc_valuePrezzoInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_valuePrezzoInserzione.gridx = 1;
		gbc_valuePrezzoInserzione.gridy = 7;
		formPanelInterno.add(valuePrezzoInserzione, gbc_valuePrezzoInserzione);
		
		JLabel lblControfferta = new JLabel("Controfferta");
		lblControfferta.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblControfferta = new GridBagConstraints();
		gbc_lblControfferta.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblControfferta.insets = new Insets(0, 0, 5, 5);
		gbc_lblControfferta.gridx = 1;
		gbc_lblControfferta.gridy = 8;
		formPanelInterno.add(lblControfferta, gbc_lblControfferta);
		NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
	    numberFormatter.setAllowsInvalid(false);
	    numberFormatter.setMinimum(1);
		RoundedFormattedTextField controffertaField = new RoundedFormattedTextField(numberFormatter);
		controffertaField.setValue(offerta.getValore()+1);
		controffertaField.setFont(new Font("Arial", Font.PLAIN, 24));
		controffertaField.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_controffertaField = new GridBagConstraints();
		gbc_controffertaField.insets = new Insets(0, 0, 5, 5);
		gbc_controffertaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_controffertaField.gridx = 1;
		gbc_controffertaField.gridy = 9;
		formPanelInterno.add(controffertaField, gbc_controffertaField);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 11;
		formPanelInterno.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{177, 177, 0};
		gbl_panel_1.rowHeights = new int[]{30, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		btnCrea.setFont(new Font("Arial", Font.PLAIN, 24));
		btnCrea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valore=((Number) controffertaField.getValue()).intValue();
				if(valore>offerta.getValore()) {
					try {
						visualizzaOfferteAgenteController.inserisciControfferta(offerta,valore);
						showCustomDialog("Controfferta inserita con successo","Ok");
						starter.switchInserisciControffertaToVisualizzaOfferte();
					} catch (Exception ex) {
						showCustomDialog(ex.getMessage(),"Ok");
					}
				}else {
					showCustomDialog("Inserire un valore maggiore dell'offerta","Ok");
				}
			}
		});
		btnCrea.setPreferredSize(new Dimension(150, 30));
		btnCrea.setBackground(new Color(255, 175, 68));
		GridBagConstraints gbc_btnCrea = new GridBagConstraints();
		gbc_btnCrea.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnCrea.insets = new Insets(0, 0, 0, 5);
		gbc_btnCrea.gridx = 0;
		gbc_btnCrea.gridy = 0;
		panel_1.add(btnCrea, gbc_btnCrea);
		
		RoundedButton btnAnnulla = new RoundedButton("Annulla",30,30);
		btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 24));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchInserisciControffertaToVisualizzaOfferte();
			}
		});
		btnAnnulla.setPreferredSize(new Dimension(150, 30));
		btnAnnulla.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnAnnulla.gridx = 1;
		gbc_btnAnnulla.gridy = 0;
		panel_1.add(btnAnnulla, gbc_btnAnnulla);
		
		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_fooBar = new GridBagConstraints();
		gbc_fooBar.fill = GridBagConstraints.BOTH;
		gbc_fooBar.gridx = 0;
		gbc_fooBar.gridy = 2;
		panePrincipale.add(fooBar, gbc_fooBar);
	}

	public void setToken(String token) {
		this.token = token;
	}
	


	public String getToken() {
		return token;
	}
	public void showCustomDialog(String messaggio,String testoButton ) {
		CustomDialog dialog=new CustomDialog(messaggio,testoButton);
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}

}
