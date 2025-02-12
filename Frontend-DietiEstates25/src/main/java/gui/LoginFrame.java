package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.LoginController;
import customElements.*;
import dto.Agente;
import dto.Agenzia;
import dto.Amministratore;
import dto.Utente;
import starter.Starter;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.ComponentOrientation;


public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panePrincipale;
	private JPasswordField passwordField;
	private Starter starter;
	private LoginController loginController;





	public LoginFrame(Starter starter) {
		loginController= new LoginController(this);
		this.starter=starter;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		
		panePrincipale = new JPanel();
		setTitle("Login Utente");

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
		
		JPanel loginFormPanel = new JPanel();
		loginFormPanel.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_loginFormPanel = new GridBagConstraints();
		gbc_loginFormPanel.insets = new Insets(0, 0, 0, 5);
		gbc_loginFormPanel.fill = GridBagConstraints.BOTH;
		gbc_loginFormPanel.gridx = 1;
		gbc_loginFormPanel.gridy = 0;
		panel.add(loginFormPanel, gbc_loginFormPanel);
		GridBagLayout gbl_loginFormPanel = new GridBagLayout();
		gbl_loginFormPanel.columnWidths = new int[]{74, 616, 74, 0};
		gbl_loginFormPanel.rowHeights = new int[]{20, 0, 50, 32, 50, 0, 50, 0, 0, 20, 0, 10, 0, 0};
		gbl_loginFormPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_loginFormPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loginFormPanel.setLayout(gbl_loginFormPanel);
		
		JLabel lblWelcome = new JLabel("Effettua il login");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 1;
		loginFormPanel.add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblEmail = new JLabel(" E-Mail");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 2;
		loginFormPanel.add(lblEmail, gbc_lblEmail);
		
		RoundedTextField emailField = new RoundedTextField(15,30,30);
		emailField.setForeground(new Color(0, 0, 0));
		emailField.setFont(new Font("Arial", Font.PLAIN, 14));
		emailField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 3;
		emailField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		loginFormPanel.add(emailField, gbc_emailField);
		
		JLabel lblPassword = new JLabel(" Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		loginFormPanel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new RoundedPasswordField(15,30,30);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 5;
		passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		loginFormPanel.add(passwordField, gbc_passwordField);
		JCheckBox checkAgente = new ModernCheckBox("Sono un agente immobiliare");
		checkAgente.setForeground(new Color(0, 0, 0));
		RoundedButton btnAccedi = new RoundedButton("Accedi",30,30);
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAgente.isSelected()) {
					String email=emailField.getText();
					String password=new String(passwordField.getPassword());
					try {
						String response = loginController.loginAgente(email,password);
			            JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
			            String token = jsonResponse.get("token").getAsString();
			            Agente agenteConnesso = getAgenteFromJsonResponse(email,password,jsonResponse);
			            emailField.setText("");
			            passwordField.setText("");
			            starter.switchLoginToHomePageAgente(agenteConnesso, token);
					}catch(Exception ex) {
						CustomDialog dialog=new CustomDialog(ex.getMessage(),"ok");
						dialog.setLocationRelativeTo(panePrincipale);
						dialog.setVisible(true);
						}
				}else {
					String email=emailField.getText();
					String password=new String(passwordField.getPassword());
					try {
						String response = loginController.loginUtente(email,password);
			            JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
			            String token = jsonResponse.get("token").getAsString();
			            Utente utenteConnesso = getUtenteFromJsonResponse(email,password,jsonResponse);
			            emailField.setText("");
			            passwordField.setText("");
			            starter.switchLoginToHomePageUtente(utenteConnesso, token);
					}catch(Exception ex) {
						CustomDialog dialog=new CustomDialog(ex.getMessage(),"Ok");
						dialog.setLocationRelativeTo(panePrincipale);
						dialog.setVisible(true);
						}
				}
				
			}
		});
		
		
		checkAgente.setBackground(new Color(217, 217, 217));
		checkAgente.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkAgente.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 6;
		loginFormPanel.add(checkAgente, gbc_chckbxNewCheckBox);
		btnAccedi.setBackground(new Color(255, 175, 68));
		btnAccedi.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnAccedi = new GridBagConstraints();
		gbc_btnAccedi.insets = new Insets(0, 0, 5, 5);
		gbc_btnAccedi.gridx = 1;
		gbc_btnAccedi.gridy = 8;
		loginFormPanel.add(btnAccedi, gbc_btnAccedi);
		
		JLabel lblSignUp = new JLabel("<html><u>Non hai ancora un account? Registrati</u></html>");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				starter.switchLoginFrameToSignUpFrame();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblSignUp.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSignUp = new GridBagConstraints();
		gbc_lblSignUp.anchor = GridBagConstraints.WEST;
		gbc_lblSignUp.insets = new Insets(0, 0, 5, 5);
		gbc_lblSignUp.gridx = 1;
		gbc_lblSignUp.gridy = 10;
		loginFormPanel.add(lblSignUp, gbc_lblSignUp);
		
		JLabel lblLoginAmministratore = new JLabel("<html> <u>Effettua il Login come amministratore<u> <html>");
		lblLoginAmministratore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				starter.switchLoginToLoginAdmin();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLoginAmministratore.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLoginAmministratore.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblLoginAmministratore.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblLoginAmministratore = new GridBagConstraints();
		gbc_lblLoginAmministratore.anchor = GridBagConstraints.WEST;
		gbc_lblLoginAmministratore.insets = new Insets(0, 0, 0, 5);
		gbc_lblLoginAmministratore.gridx = 1;
		gbc_lblLoginAmministratore.gridy = 12;
		loginFormPanel.add(lblLoginAmministratore, gbc_lblLoginAmministratore);
		
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


	public LoginController getLoginController() {
		return loginController;
	}


	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	private Agente getAgenteFromJsonResponse(String email, String password,JsonObject jsonResponse) {
		JsonObject agenziaJson=jsonResponse.getAsJsonObject("agenzia");
		Agenzia agency= new Gson().fromJson(agenziaJson, Agenzia.class);
		String nome = jsonResponse.get("nome").getAsString();
		String cognome = jsonResponse.get("cognome").getAsString();
		Agente agenteConnesso= new Agente(nome,cognome,email,password,agency);
		return agenteConnesso;
	}
	
	private Utente getUtenteFromJsonResponse(String email, String password,JsonObject jsonResponse) {
		String nome = jsonResponse.get("nome").getAsString();
		String cognome = jsonResponse.get("cognome").getAsString();
		Utente utenteConnesso= new Utente(nome,cognome,email,password);
		return utenteConnesso;
	}
}
