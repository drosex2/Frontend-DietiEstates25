package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.InserisciOffertaManualmenteController;
import customElements.RoundedButton;
import customElements.RoundedTextField;
import dto.Inserzione;
import starter.Starter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.GridBagLayout;
import java.awt.Insets;
import customElements.RoundedFormattedTextField;
import javax.swing.text.NumberFormatter;

public class InserisciOffertaManualmenteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Starter starter;
	private JPanel panePrincipale;
	private JTextField emailUtenteField;
	private RoundedFormattedTextField offertaField;
	private Inserzione inserzione;
	private String token;
	private InserisciOffertaManualmenteController inserisciOffertaManualmenteController;
	
	
	public InserisciOffertaManualmenteFrame(Starter starter,Inserzione inserzione, String token) {
		
		this.starter=starter;
		this.inserzione=inserzione;
		this.setToken(token);
		this.inserisciOffertaManualmenteController=new InserisciOffertaManualmenteController(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		
		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(217, 217, 217));
		setTitle("Registrazione");

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
		
		JLabel lblWelcome = new JLabel("Inserisci offerta manualmente");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 30));
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
		gbl_formPanelInterno.rowHeights = new int[]{30, 40, 30, 40, 30, 40, 30, 40, 20, 38, 0};
		gbl_formPanelInterno.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_formPanelInterno.rowWeights = new double[]{2.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanelInterno.setLayout(gbl_formPanelInterno);
		RoundedButton btnInserisci = new RoundedButton("Inserisci",30,30);
		int minimo;
		if(inserzione.getTipologia().equals("affitto")) {
			minimo=inserzione.getPrezzo()-((inserzione.getPrezzo()/100)*20);
		}else {
			minimo=inserzione.getPrezzo()-((inserzione.getPrezzo()/100)*15);
		}
		
		btnInserisci.setText("Inserisci");
		JLabel lblTitoloInserzione = new JLabel("Titolo Inserzione");
		lblTitoloInserzione.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblTitoloInserzione = new GridBagConstraints();
		gbc_lblTitoloInserzione.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTitoloInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitoloInserzione.gridx = 1;
		gbc_lblTitoloInserzione.gridy = 0;
		formPanelInterno.add(lblTitoloInserzione, gbc_lblTitoloInserzione);
		
		JLabel titoloValue = new JLabel(inserzione.getTitolo());
		titoloValue.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_titoloValue = new GridBagConstraints();
		gbc_titoloValue.anchor = GridBagConstraints.WEST;
		gbc_titoloValue.insets = new Insets(0, 0, 5, 5);
		gbc_titoloValue.gridx = 1;
		gbc_titoloValue.gridy = 1;
		formPanelInterno.add(titoloValue, gbc_titoloValue);
		
		JLabel lblPrezzo = new JLabel("Prezzo iniziale");
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.gridx = 1;
		gbc_lblPrezzo.gridy = 2;
		formPanelInterno.add(lblPrezzo, gbc_lblPrezzo);
		
		JLabel prezzoValue = new JLabel("€"+inserzione.getPrezzo());
		prezzoValue.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_prezzoValue = new GridBagConstraints();
		gbc_prezzoValue.anchor = GridBagConstraints.WEST;
		gbc_prezzoValue.insets = new Insets(0, 0, 5, 5);
		gbc_prezzoValue.gridx = 1;
		gbc_prezzoValue.gridy = 3;
		formPanelInterno.add(prezzoValue, gbc_prezzoValue);
		
		JLabel lblEmailUtente = new JLabel("E-Mail Utente");
		lblEmailUtente.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblEmailUtente = new GridBagConstraints();
		gbc_lblEmailUtente.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEmailUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailUtente.gridx = 1;
		gbc_lblEmailUtente.gridy = 4;
		formPanelInterno.add(lblEmailUtente, gbc_lblEmailUtente);
		
		emailUtenteField = new RoundedTextField(15,30,30);
		emailUtenteField.setFont(new Font("Arial", Font.PLAIN, 24));
		emailUtenteField.setColumns(10);
		emailUtenteField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_emailUtenteField = new GridBagConstraints();
		gbc_emailUtenteField.insets = new Insets(0, 0, 5, 5);
		gbc_emailUtenteField.fill = GridBagConstraints.BOTH;
		gbc_emailUtenteField.gridx = 1;
		gbc_emailUtenteField.gridy = 5;
		emailUtenteField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		formPanelInterno.add(emailUtenteField, gbc_emailUtenteField);
		
		JLabel lblOfferta = new JLabel("Offerta");
		lblOfferta.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblOfferta = new GridBagConstraints();
		gbc_lblOfferta.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblOfferta.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfferta.gridx = 1;
		gbc_lblOfferta.gridy = 6;
		formPanelInterno.add(lblOfferta, gbc_lblOfferta);
		
		
		NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(1);
		offertaField = new RoundedFormattedTextField(numberFormatter);
		offertaField.setValue(minimo);
		offertaField.setFont(new Font("Arial", Font.PLAIN, 24));
		offertaField.setBackground(new Color(192, 192, 192));
		
		GridBagConstraints gbc_offertaField = new GridBagConstraints();
		gbc_offertaField.insets = new Insets(0, 0, 5, 5);
		gbc_offertaField.fill = GridBagConstraints.BOTH;
		gbc_offertaField.gridx = 1;
		gbc_offertaField.gridy = 7;
		formPanelInterno.add(offertaField, gbc_offertaField);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 9;
		formPanelInterno.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{177, 177, 0};
		gbl_panel_1.rowHeights = new int[]{30, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		btnInserisci.setFont(new Font("Arial", Font.PLAIN, 24));
		
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int offerta=((Number)offertaField.getValue()).intValue();
				if(offerta>=minimo) {
					try {
						inserisciOffertaManualmenteController.inserisciOfferta(emailUtenteField.getText(),inserzione,offerta);
						showCustomDialog("Offerta inserita con successo","Ok");
					} catch (Exception ex) {
						showCustomDialog(ex.getMessage(),"Ok");
					}
				}else {
					
					showCustomDialog("L'offerta deve essere almeno:€"+minimo,"Ok");
				}
			}

			
		});
		btnInserisci.setPreferredSize(new Dimension(150, 30));
		btnInserisci.setBackground(new Color(255, 175, 68));
		GridBagConstraints gbc_btnInserisci = new GridBagConstraints();
		gbc_btnInserisci.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnInserisci.insets = new Insets(0, 0, 0, 5);
		gbc_btnInserisci.gridx = 0;
		gbc_btnInserisci.gridy = 0;
		panel_1.add(btnInserisci, gbc_btnInserisci);
		
		RoundedButton btnAnnulla = new RoundedButton("Annulla",30,30);
		btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 24));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchInserisciOffertaManualmenteToInserisciOffertaManualeScrollFrame();
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

	public Starter getStarter() {
		return starter;
	}

	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	public void showCustomDialog(String messaggio,String testoBottone) {
		CustomDialog dialog=new CustomDialog(messaggio,testoBottone);
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
