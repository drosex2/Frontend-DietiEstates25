package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import customElements.*;
import controller.LoginAdminController;
import dto.Amministratore;
import starter.Starter;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginAdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panePrincipale;
	private JPasswordField passwordField;
	private LoginAdminController loginAdminController;
	private Starter starter;


	public LoginAdminFrame(Starter starter) {
		loginAdminController=new LoginAdminController(this);
		this.starter=starter;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		panePrincipale = new JPanel();
		setTitle("Login Admin");

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
		

		logoImage.setIcon(new ImageIcon(LoginAdminFrame.class.getResource("/DietiEstates25/client/gui/images/logoFigma80.png")));
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
		gbl_loginFormPanel.rowHeights = new int[]{20, 0, 50, 32, 50, 0, 50, 0, 0, 0, 0, 10, 0, 0};
		gbl_loginFormPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_loginFormPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loginFormPanel.setLayout(gbl_loginFormPanel);
		
		JLabel lblWelcome = new JLabel("Effettua il login");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 1;
		loginFormPanel.add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblNomeAdmin = new JLabel("Nome Amministratore");
		lblNomeAdmin.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNomeAdmin = new GridBagConstraints();
		gbc_lblNomeAdmin.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNomeAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeAdmin.gridx = 1;
		gbc_lblNomeAdmin.gridy = 2;
		loginFormPanel.add(lblNomeAdmin, gbc_lblNomeAdmin);
		
		RoundedTextField nomeAdminField = new RoundedTextField(15,30,30);
		nomeAdminField.setForeground(new Color(0, 0, 0));
		nomeAdminField.setFont(new Font("Arial", Font.PLAIN, 14));
		nomeAdminField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_nomeAdminField = new GridBagConstraints();
		gbc_nomeAdminField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeAdminField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeAdminField.gridx = 1;
		gbc_nomeAdminField.gridy = 3;
		nomeAdminField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		loginFormPanel.add(nomeAdminField, gbc_nomeAdminField);
		
		JLabel lblPassword = new JLabel("Password");
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
		JFrame myFrame=this;
		RoundedButton btnAccedi = new RoundedButton("Accedi",30,30);
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeAdmin=nomeAdminField.getText();
				String password=new String(passwordField.getPassword());
				try {
					Amministratore adminConnesso=loginAdminController.login(nomeAdmin,password);
					String token="myToken"; //token che deve essere restituito dalla chiamata al login
					starter.switchLoginAdminToHomePageAdmin(adminConnesso,token);
				}catch(Exception ex) {
					CustomDialog dialog=new CustomDialog(ex.getMessage(),"Ok");
					dialog.setModal(true);
					dialog.setLocationRelativeTo(myFrame);
					dialog.setVisible(true);
				}
					
				
			}
		});
		btnAccedi.setBackground(new Color(255, 175, 68));
		btnAccedi.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnAccedi = new GridBagConstraints();
		gbc_btnAccedi.insets = new Insets(0, 0, 5, 5);
		gbc_btnAccedi.gridx = 1;
		gbc_btnAccedi.gridy = 7;
		loginFormPanel.add(btnAccedi, gbc_btnAccedi);
		
		JLabel lblTornaLogin = new JLabel("<html><u>Torna al login utente </u></html>");
		lblTornaLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				starter.switchLoginAdminToLogin();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTornaLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTornaLogin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblTornaLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTornaLogin = new GridBagConstraints();
		gbc_lblTornaLogin.anchor = GridBagConstraints.WEST;
		gbc_lblTornaLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTornaLogin.gridx = 1;
		gbc_lblTornaLogin.gridy = 9;
		loginFormPanel.add(lblTornaLogin, gbc_lblTornaLogin);
		
		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_fooBar = new GridBagConstraints();
		gbc_fooBar.fill = GridBagConstraints.BOTH;
		gbc_fooBar.gridx = 0;
		gbc_fooBar.gridy = 2;
		panePrincipale.add(fooBar, gbc_fooBar);
	}
}
