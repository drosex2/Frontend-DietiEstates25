package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import controller.HomePageAgenteController;
import customElements.RoundedButton;
import dto.Agente;
import dto.Inserzione;
import dto.Offerta;
import dto.Controfferta;
import starter.Starter;

public class HomePageAgenteFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JPanel panePrincipale;
	private Starter starter;
	private HomePageAgenteController homePageAgenteController;
	private Agente agenteConnesso;
	private String token;


	public HomePageAgenteFrame(Starter starter,Agente agenteConnesso,String token) {
		this.agenteConnesso=agenteConnesso;
		this.starter=starter;
		this.token=token;
		this.homePageAgenteController=new HomePageAgenteController(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		
		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(217, 217, 217));
		setTitle("HomePage agente");

		setContentPane(panePrincipale);
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[]{881, 0};
		gbl_panePrincipale.rowHeights = new int[]{97, 473, 40, 0};
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
		JFrame myFrame=this;
		JLabel logoutImage = new JLabel("");
		logoutImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				starter.logout(myFrame);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logoutImage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		logoutImage.setIcon(new ImageIcon(LoginFrame.class.getResource("/DietiEstates25/client/gui/images/logoutButton.png")));
		GridBagConstraints gbc_logoutImage = new GridBagConstraints();
		gbc_logoutImage.anchor = GridBagConstraints.EAST;
		gbc_logoutImage.fill = GridBagConstraints.VERTICAL;
		gbc_logoutImage.gridx = 2;
		gbc_logoutImage.gridy = 0;
		navBar.add(logoutImage, gbc_logoutImage);
		
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
		gbl_panel.columnWeights = new double[]{5.0, 1.0, 5.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		gbl_loginFormPanel.columnWidths = new int[]{120, 560, 120, 0};
		gbl_loginFormPanel.rowHeights = new int[]{0, 70, 20, 70, 20, 70, 20, 70, 20, 70, 10, 0};
		gbl_loginFormPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_loginFormPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		loginFormPanel.setLayout(gbl_loginFormPanel);
		
		
		
		RoundedButton btnInserisciInserzione = new RoundedButton("Inserisci inserzione",30,30);
		btnInserisciInserzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchHomePageAgenteToInserisciInserzione(agenteConnesso,token);
			}
		});
		btnInserisciInserzione.setFont(new Font("Arial", Font.PLAIN, 18));
		btnInserisciInserzione.setForeground(new Color(255, 255, 255));
		btnInserisciInserzione.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnInserisciInserzione = new GridBagConstraints();
		gbc_btnInserisciInserzione.fill = GridBagConstraints.BOTH;
		gbc_btnInserisciInserzione.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciInserzione.gridx = 1;
		gbc_btnInserisciInserzione.gridy = 1;
		loginFormPanel.add(btnInserisciInserzione, gbc_btnInserisciInserzione);
		
		
		RoundedButton btnInserisciOfferta = new RoundedButton("Inserisci offerta manualmente",30,30);
		btnInserisciOfferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserisciOfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		btnInserisciOfferta.setForeground(new Color(255, 255, 255));
		btnInserisciOfferta.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnInserisciOfferta = new GridBagConstraints();
		gbc_btnInserisciOfferta.fill = GridBagConstraints.BOTH;
		gbc_btnInserisciOfferta.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciOfferta.gridx = 1;
		gbc_btnInserisciOfferta.gridy = 3;
		loginFormPanel.add(btnInserisciOfferta, gbc_btnInserisciOfferta);
		
		RoundedButton btnVisualizzaOfferte = new RoundedButton("Visualizza offerte",30,30);
		btnVisualizzaOfferte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Offerta> offerte = homePageAgenteController.ottieniOfferteAgente(agenteConnesso.getEmail());
						if (offerte.isEmpty()) {
							throw new Exception("Nessuna inserzione disponibile");
						}
						starter.switchHomePageAgenteToVisualizzaOfferteAgente(starter,token,offerte);
						return null;
					}

					@Override
					protected void done() {
						try {
							get();
							loadingDialog.dispose();
						} catch (Exception ex) {
							
							loadingDialog.dispose();
							CustomDialog dialog = new CustomDialog("Nessuna offerta disponibile", "Ok");
							dialog.setLocationRelativeTo(panePrincipale);
							dialog.setVisible(true);
						}
					}
				};
				worker.execute();
				loadingDialog.setVisible(true);
			}
		});
		btnVisualizzaOfferte.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVisualizzaOfferte.setForeground(new Color(255, 255, 255));
		btnVisualizzaOfferte.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnVisualizzaOfferte = new GridBagConstraints();
		gbc_btnVisualizzaOfferte.fill = GridBagConstraints.BOTH;
		gbc_btnVisualizzaOfferte.insets = new Insets(0, 0, 5, 5);
		gbc_btnVisualizzaOfferte.gridx = 1;
		gbc_btnVisualizzaOfferte.gridy = 5;
		loginFormPanel.add(btnVisualizzaOfferte, gbc_btnVisualizzaOfferte);
		
		RoundedButton btnVisualizzaControfferte = new RoundedButton("Visualizza controfferte",30,30);
		btnVisualizzaControfferte.setForeground(new Color(255, 255, 255));
		btnVisualizzaControfferte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Controfferta> controfferte = homePageAgenteController.ottieniControfferteAgente(agenteConnesso.getEmail());
						if (controfferte.isEmpty()) {
							throw new Exception("Nessuna inserzione disponibile");
						}
						starter.switchHomePageAgenteToVisualizzaControfferteAgente(starter,controfferte);
						return null;
					}

					@Override
					protected void done() {
						try {
							get();
							loadingDialog.dispose();
						} catch (Exception ex) {
							
							loadingDialog.dispose();
							CustomDialog dialog = new CustomDialog("Nessuna controfferta disponibile", "Ok");
							dialog.setLocationRelativeTo(panePrincipale);
							dialog.setVisible(true);
						}
					}
				};
				worker.execute();
				loadingDialog.setVisible(true);
			}
			
		});
		btnVisualizzaControfferte.setBackground(new Color(13, 49, 71));
		btnVisualizzaControfferte.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnVisualizzaControfferte = new GridBagConstraints();
		gbc_btnVisualizzaControfferte.fill = GridBagConstraints.BOTH;
		gbc_btnVisualizzaControfferte.insets = new Insets(0, 0, 5, 5);
		gbc_btnVisualizzaControfferte.gridx = 1;
		gbc_btnVisualizzaControfferte.gridy = 7;
		loginFormPanel.add(btnVisualizzaControfferte, gbc_btnVisualizzaControfferte);
		
		RoundedButton btnModificaInserzioni = new RoundedButton("Modifica inserzioni",30,30);
		btnModificaInserzioni.setForeground(new Color(255, 255, 255));
		
		btnModificaInserzioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Inserzione> inserzioni = homePageAgenteController.ottieniInserzioniAgente(agenteConnesso.getEmail());
						if (inserzioni.isEmpty()) {
							throw new Exception("Nessuna inserzione disponibile");
						}
						starter.switchHomePageAgenteToVisualizzaInserzioni(starter, token, inserzioni);
						return null;
					}

					@Override
					protected void done() {
						try {
							get();
							loadingDialog.dispose();
						} catch (Exception ex) {
							loadingDialog.dispose();
							CustomDialog dialog = new CustomDialog("Nessuna inserzione disponibile", "Ok");
							dialog.setLocationRelativeTo(panePrincipale);
							dialog.setVisible(true);
						}
					}
				};
				worker.execute();
				loadingDialog.setVisible(true);
			}
		});
		btnModificaInserzioni.setBackground(new Color(13, 49, 71));
		btnModificaInserzioni.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnModificaInserzioni = new GridBagConstraints();
		gbc_btnModificaInserzioni.fill = GridBagConstraints.BOTH;
		gbc_btnModificaInserzioni.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificaInserzioni.gridx = 1;
		gbc_btnModificaInserzioni.gridy = 9;
		loginFormPanel.add(btnModificaInserzioni, gbc_btnModificaInserzioni);
		
		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(13, 49, 71));
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
	public HomePageAgenteController getHomePageAgenteController() {
		return homePageAgenteController;
	}
	public void setHomePageAgenteController(HomePageAgenteController homePageAgenteController) {
		this.homePageAgenteController = homePageAgenteController;
	}
	public Agente getAgenteConnesso() {
		return agenteConnesso;
	}
	public void setAdminConnesso(Agente agenteConnesso) {
		this.agenteConnesso = agenteConnesso;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
