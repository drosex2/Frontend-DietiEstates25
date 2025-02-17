package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.CreaAgenteController;
import customElements.RoundedButton;
import customElements.RoundedPasswordField;
import customElements.RoundedTextField;
import dto.Amministratore;
import dto.Inserzione;
import dto.Offerta;
import starter.Starter;
import utils.CredentialCheckerUtils;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InserisciControffertaAgenteFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Starter starter;
	private JPanel panePrincipale;
	private Amministratore adminConnesso;
	private CreaAgenteController creaAgenteController;
	private String token;
	private JTextField textField;
	private Offerta offerta;
	public InserisciControffertaAgenteFrame() {
	
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(50, 50, 770, 512);
	panePrincipale = new JPanel();
	panePrincipale.setBackground(new Color(217, 217, 217));
	setTitle("Insersci Controfferta");

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
	JLabel lblTitiloInserzione = new JLabel("Titolo inserzione");
	lblTitiloInserzione.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lblTitiloInserzione = new GridBagConstraints();
	gbc_lblTitiloInserzione.anchor = GridBagConstraints.SOUTHWEST;
	gbc_lblTitiloInserzione.insets = new Insets(0, 0, 5, 5);
	gbc_lblTitiloInserzione.gridx = 1;
	gbc_lblTitiloInserzione.gridy = 0;
	formPanelInterno.add(lblTitiloInserzione, gbc_lblTitiloInserzione);
	
	
	JLabel lbTitolo = new JLabel(offerta.getInserzione().getTitolo());
	lbTitolo.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lbTitolo = new GridBagConstraints();
	gbc_lbTitolo.anchor = GridBagConstraints.NORTHWEST;
	gbc_lbTitolo.insets = new Insets(0, 0, 5, 5);
	gbc_lbTitolo.gridx = 1;
	gbc_lbTitolo.gridy = 1;
	formPanelInterno.add(lbTitolo, gbc_lbTitolo);
	
	JLabel lblNome = new JLabel("Email Utente");
	lblNome.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lblNome = new GridBagConstraints();
	gbc_lblNome.anchor = GridBagConstraints.SOUTHWEST;
	gbc_lblNome.insets = new Insets(0, 0, 5, 5);
	gbc_lblNome.gridx = 1;
	gbc_lblNome.gridy = 2;
	formPanelInterno.add(lblNome, gbc_lblNome);
	
	JLabel lblemail = new JLabel(offerta.getUtente().getEmail());
	lblemail.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lblemail = new GridBagConstraints();
	gbc_lblemail.anchor = GridBagConstraints.NORTHWEST;
	gbc_lblemail.insets = new Insets(0, 0, 5, 5);
	gbc_lblemail.gridx = 1;
	gbc_lblemail.gridy = 3;
	formPanelInterno.add(lblemail, gbc_lblemail);
	
	JLabel lblnew = new JLabel("Offerta");
	lblnew.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lblnew = new GridBagConstraints();
	gbc_lblnew.anchor = GridBagConstraints.SOUTHWEST;
	gbc_lblnew.insets = new Insets(0, 0, 5, 5);
	gbc_lblnew.gridx = 1;
	gbc_lblnew.gridy = 4;
	formPanelInterno.add(lblnew, gbc_lblnew);
	
	JLabel lblofferta = new JLabel("€"+ offerta.getValore());
	lblofferta.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lblofferta = new GridBagConstraints();
	gbc_lblofferta.anchor = GridBagConstraints.NORTHWEST;
	gbc_lblofferta.insets = new Insets(0, 0, 5, 5);
	gbc_lblofferta.gridx = 1;
	gbc_lblofferta.gridy = 5;
	formPanelInterno.add(lblofferta, gbc_lblofferta);
	
	JLabel lblPrezzo = new JLabel("Prezzo Iniziale");
	lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
	gbc_lblPrezzo.anchor = GridBagConstraints.SOUTHWEST;
	gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
	gbc_lblPrezzo.gridx = 1;
	gbc_lblPrezzo.gridy = 6;
	formPanelInterno.add(lblPrezzo, gbc_lblPrezzo);
	
	JLabel lglPrezzoIniziale = new JLabel("€"+ offerta.getInserzione().getPrezzo());
	lglPrezzoIniziale.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lglPrezzoIniziale = new GridBagConstraints();
	gbc_lglPrezzoIniziale.anchor = GridBagConstraints.NORTHWEST;
	gbc_lglPrezzoIniziale.insets = new Insets(0, 0, 5, 5);
	gbc_lglPrezzoIniziale.gridx = 1;
	gbc_lglPrezzoIniziale.gridy = 7;
	formPanelInterno.add(lglPrezzoIniziale, gbc_lglPrezzoIniziale);
	
	JLabel lblNewLabel_4 = new JLabel("Controfferta");
	lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
	gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTHWEST;
	gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel_4.gridx = 1;
	gbc_lblNewLabel_4.gridy = 8;
	formPanelInterno.add(lblNewLabel_4, gbc_lblNewLabel_4);
	
	textField = new RoundedTextField(30,30,30);
	textField.setFont(new Font("Arial", Font.PLAIN, 18));
	GridBagConstraints gbc_textField = new GridBagConstraints();
	gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField.insets = new Insets(0, 0, 5, 5);
	gbc_textField.gridx = 1;
	gbc_textField.gridy = 9;
	formPanelInterno.add(textField, gbc_textField);
	textField.setColumns(10);
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
	
	
	btnCrea.setEnabled(false);
	btnCrea.setFont(new Font("Arial", Font.PLAIN, 18));
	JFrame myFrame=this;
	btnCrea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
	btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 18));
	btnAnnulla.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			starter.switchCreaAgenteFrameToHomePageAdmin();
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
	public Amministratore getAdminConnesso() {
		return adminConnesso;
	}


	public void setAdminConnesso(Amministratore adminConnesso) {
		this.adminConnesso = adminConnesso;
	}


	public String getToken() {
		return token;
	}


}
