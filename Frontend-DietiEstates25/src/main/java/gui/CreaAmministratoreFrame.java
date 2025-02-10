package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import controller.ModificaAgenteController;
import customElements.*;
import controller.CreaAmministratoreController;
import controller.LoginController;
import dto.Amministratore;
import starter.Starter;
import utils.CredentialCheckerUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CreaAmministratoreFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Starter starter;
	private JPanel panePrincipale;
	private JTextField nomeAdminField;
	private JPasswordField passwordField;
	private Amministratore adminConnesso;
	private CreaAmministratoreController creaAmministratoreController;
	private String token;

	
	public CreaAmministratoreFrame(Starter starter,Amministratore admin,String token) {
		
		this.starter=starter;
		this.adminConnesso=admin;
		this.token=token;
		this.creaAmministratoreController=new CreaAmministratoreController(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		
		panePrincipale = new JPanel();
		setTitle("Crea un nuovo amministratore");

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
		
		JLabel lblWelcome = new JLabel("Crea un nuovo amministratore");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 28));
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
		gbl_formPanelInterno.rowHeights = new int[]{89, 40, 59, 40, 88, 0};
		gbl_formPanelInterno.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_formPanelInterno.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		formPanelInterno.setLayout(gbl_formPanelInterno);
		RoundedButton btnCrea = new RoundedButton("Crea",30,30);
		
		JLabel lblNomeAdmin = new JLabel("NomeAdmin");
		lblNomeAdmin.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNomeAdmin = new GridBagConstraints();
		gbc_lblNomeAdmin.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNomeAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeAdmin.gridx = 1;
		gbc_lblNomeAdmin.gridy = 0;
		formPanelInterno.add(lblNomeAdmin, gbc_lblNomeAdmin);
		
		nomeAdminField = new RoundedTextField(15,30,30);
		nomeAdminField.setFont(new Font("Arial", Font.PLAIN, 18));
		nomeAdminField.setColumns(10);
		nomeAdminField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_nomeAdminField = new GridBagConstraints();
		gbc_nomeAdminField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeAdminField.fill = GridBagConstraints.BOTH;
		gbc_nomeAdminField.gridx = 1;
		gbc_nomeAdminField.gridy = 1;
		nomeAdminField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		formPanelInterno.add(nomeAdminField, gbc_nomeAdminField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		formPanelInterno.add(lblPassword, gbc_lblPassword);
		
		passwordField = new RoundedPasswordField(15,30,30);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		passwordField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		formPanelInterno.add(passwordField, gbc_passwordField);
		
		JLabel lblErrorePassword = new JLabel("<html> Inserire una password di almeno 8 caratteri,<br> un numero e un carattere speciale</html>");
		lblErrorePassword.setVisible(false);
		lblErrorePassword.setForeground(new Color(255, 0, 0));
		lblErrorePassword.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblErrorePassword = new GridBagConstraints();
		gbc_lblErrorePassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblErrorePassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrorePassword.gridx = 2;
		gbc_lblErrorePassword.gridy = 3;
		formPanelInterno.add(lblErrorePassword, gbc_lblErrorePassword);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String password=new String(passwordField.getPassword());
				if(!CredentialCheckerUtils.checkPassword(password)){
					lblErrorePassword.setVisible(true);
					btnCrea.setEnabled(false);
				}else {
					btnCrea.setEnabled(true);
				}
				
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				lblErrorePassword.setVisible(false);
			}
		});
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
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
				String nomeAdmin=nomeAdminField.getText();
				String password=new String(passwordField.getPassword());
				
				try {
					creaAmministratoreController.creaAmministratore(nomeAdmin,password);
					CustomDialog dialog=new CustomDialog("Nuovo agente creato con successo!","Torna alla Home");
					dialog.setModal(true);
					dialog.setLocationRelativeTo(myFrame);
					dialog.setVisible(true);
					starter.switchCreaAmministratoreFrameToHomePageAdmin();
				}catch(Exception ex) {
					CustomDialog dialog=new CustomDialog(ex.getMessage(),"Ok");
					dialog.setModal(true);
					dialog.setLocationRelativeTo(myFrame);
					dialog.setVisible(true);
				}
				
			}
		});
		btnCrea.setPreferredSize(new Dimension(150, 30));
		btnCrea.setBackground(new Color(255, 175, 68));
		GridBagConstraints gbc_btnCrea = new GridBagConstraints();
		gbc_btnCrea.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnCrea.insets = new Insets(0, 0, 0, 5);
		gbc_btnCrea.gridx = 0;
		gbc_btnCrea.gridy = 0;
		panel_1.add(btnCrea, gbc_btnCrea);
		
		RoundedButton btnAnnulla = new RoundedButton("Annulla",30,30);
		btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchCreaAmministratoreFrameToHomePageAdmin();
			}
		});
		btnAnnulla.setPreferredSize(new Dimension(150, 30));
		btnAnnulla.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.anchor = GridBagConstraints.SOUTHWEST;
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


	public Amministratore getAdminConnesso() {
		return adminConnesso;
	}


	public void setAdminConnesso(Amministratore adminConnesso) {
		this.adminConnesso = adminConnesso;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}

}
