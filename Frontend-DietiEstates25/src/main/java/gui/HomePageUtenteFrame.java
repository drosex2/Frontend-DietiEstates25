package gui;
import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import controller.HomePageUtenteController;
import customElements.RoundedButton;
import dto.Controfferta;
import dto.Notifica;
import dto.Offerta;
import dto.Ricerca;
import dto.Utente;
import starter.Starter;

public class HomePageUtenteFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JPanel panePrincipale;
	private Starter starter;
	private HomePageUtenteController homePageUtenteController;
	private Utente utenteConnesso;
	private String token;

	public HomePageUtenteFrame(Starter starter, Utente utenteConnesso, String token) {
		this.utenteConnesso = utenteConnesso;
		this.starter = starter;
		this.token = token;
		this.homePageUtenteController = new HomePageUtenteController(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		
		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(217, 217, 217));
		setTitle("HomePage Utente");

		setContentPane(panePrincipale);
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[]{881, 0};
		gbl_panePrincipale.rowHeights = new int[]{97, 473, 40, 0};
		gbl_panePrincipale.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panePrincipale.rowWeights = new double[]{1.0, 10.0, 0.0, Double.MIN_VALUE};
		panePrincipale.setLayout(gbl_panePrincipale);
		
		JPanel navBar = new JPanel();
		navBar.setBackground(new Color(6, 128, 180));
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
		
		JFrame myFrame = this;
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
		
		
		RoundedButton btnRicerca = new RoundedButton("Ricerca", 30, 30);
		btnRicerca.setText("Effettua ricerca");
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						
						starter.switchHomePageUtenteToEffettuaRicerca(token,utenteConnesso);
						return null;
					}

					@Override
					protected void done() {
							loadingDialog.dispose();
					}
				};
				worker.execute();
				loadingDialog.setVisible(true);
			}
		});
		btnRicerca.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRicerca.setForeground(new Color(255, 255, 255));
		btnRicerca.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnRicerca = new GridBagConstraints();
		gbc_btnRicerca.fill = GridBagConstraints.BOTH;
		gbc_btnRicerca.insets = new Insets(0, 0, 5, 5);
		gbc_btnRicerca.gridx = 1;
		gbc_btnRicerca.gridy = 1;
		loginFormPanel.add(btnRicerca, gbc_btnRicerca);
		
		
		RoundedButton btnCronologiaRicerca = new RoundedButton("Cronologia Ricerca", 30, 30);
		btnCronologiaRicerca.setText("Visualizza cronologia ricerche");
		btnCronologiaRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Ricerca> ricerche = homePageUtenteController.ottieniRicercheUtente(utenteConnesso.getEmail());
						if (ricerche.isEmpty()) {
							throw new Exception("Non ci sono ricerche in arrivo");
						}
						starter.switchHomePageUtenteToVisualizzaRicerche(ricerche,token);
						return null;
					}
					@Override
					protected void done() {
						try {
							get();
							loadingDialog.dispose();
						} catch (Exception ex) {
							
							loadingDialog.dispose();
							CustomDialog dialog = new CustomDialog("Nessuna ricerca eseguita in precedenza", "Ok");
							dialog.setLocationRelativeTo(panePrincipale);
							dialog.setVisible(true);
						}
					}
				};
				worker.execute();
				loadingDialog.setVisible(true);
				
			}
		});
		btnCronologiaRicerca.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCronologiaRicerca.setForeground(new Color(255, 255, 255));
		btnCronologiaRicerca.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnCronologiaRicerca = new GridBagConstraints();
		gbc_btnCronologiaRicerca.fill = GridBagConstraints.BOTH;
		gbc_btnCronologiaRicerca.insets = new Insets(0, 0, 5, 5);
		gbc_btnCronologiaRicerca.gridx = 1;
		gbc_btnCronologiaRicerca.gridy = 3;
		loginFormPanel.add(btnCronologiaRicerca, gbc_btnCronologiaRicerca);
		
		
		RoundedButton btnNotifiche = new RoundedButton("Notifiche", 30, 30);
		btnNotifiche.setText("Visualizza notifiche");
		btnNotifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Notifica> notifiche = homePageUtenteController.ottieniNotificheUtente(utenteConnesso.getEmail());
						if (notifiche.isEmpty()) {
							throw new Exception("Non ci sono notifiche in arrivo");
						}
						starter.switchHomePageUtenteToVisualizzaNotifiche(notifiche);
						return null;
					}
					@Override
					protected void done() {
						try {
							get();
							loadingDialog.dispose();
						} catch (Exception ex) {
							
							loadingDialog.dispose();
							CustomDialog dialog = new CustomDialog("Nessuna notifica in arrivo", "Ok");
							dialog.setLocationRelativeTo(panePrincipale);
							dialog.setVisible(true);
						}
					}
				};
				worker.execute();
				loadingDialog.setVisible(true);
			
			}
		});
		btnNotifiche.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNotifiche.setForeground(new Color(255, 255, 255));
		btnNotifiche.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnNotifiche = new GridBagConstraints();
		gbc_btnNotifiche.fill = GridBagConstraints.BOTH;
		gbc_btnNotifiche.insets = new Insets(0, 0, 5, 5);
		gbc_btnNotifiche.gridx = 1;
		gbc_btnNotifiche.gridy = 5;
		loginFormPanel.add(btnNotifiche, gbc_btnNotifiche);
		
		
		RoundedButton btnOfferta = new RoundedButton("Offerta", 30, 30);
		btnOfferta.setText("Visualizza offerte inviate");
		btnOfferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Offerta> offerte = homePageUtenteController.ottieniOfferteUtente(utenteConnesso.getEmail());
						if (offerte.isEmpty()) {
							throw new Exception("Non ci sono offerte inviate");
						}
						starter.switchHomePageUtenteToVisualizzaOfferteUtente(offerte);
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
		btnOfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		btnOfferta.setForeground(new Color(255, 255, 255));
		btnOfferta.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnOfferta = new GridBagConstraints();
		gbc_btnOfferta.fill = GridBagConstraints.BOTH;
		gbc_btnOfferta.insets = new Insets(0, 0, 5, 5);
		gbc_btnOfferta.gridx = 1;
		gbc_btnOfferta.gridy = 7;
		loginFormPanel.add(btnOfferta, gbc_btnOfferta);
		
		
		RoundedButton btnContrOfferta = new RoundedButton("Controfferta", 30, 30);
		btnContrOfferta.setText("Visualizza controfferte ricevute");
		btnContrOfferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Controfferta> controfferte = homePageUtenteController.ottieniControfferteUtente(utenteConnesso.getEmail());
						
						if (!hasControfferteInAttesa(controfferte)) {
							throw new Exception("Non ci sono controfferte ricevute");
						}
						starter.switchHomePageUtenteToVisualizzaControfferteUtente(controfferte,token);
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
		btnContrOfferta.setFont(new Font("Arial", Font.PLAIN, 18));
		btnContrOfferta.setForeground(new Color(255, 255, 255));
		btnContrOfferta.setBackground(new Color(13, 49, 71));
		GridBagConstraints gbc_btnControOfferta = new GridBagConstraints();
		gbc_btnControOfferta.fill = GridBagConstraints.BOTH;
		gbc_btnControOfferta.insets = new Insets(0, 0, 5, 5);
		gbc_btnControOfferta.gridx = 1;
		gbc_btnControOfferta.gridy = 9;
		loginFormPanel.add(btnContrOfferta, gbc_btnControOfferta);
	}
	private boolean hasControfferteInAttesa(List<Controfferta> controfferte) {
		for(Controfferta controfferta: controfferte) {
			if(controfferta.getEsito().equals("in attesa")) {
				return true;
			}
		}
		return false;
	}

	public Starter getStarter() {
		return starter;
	}

	public void setStarter(Starter starter) {
		this.starter = starter;
	}
	
	public HomePageUtenteController getHomePageUtenteController() {
		return homePageUtenteController;
	}
	
	public void setHomePageUtenteController(HomePageUtenteController homePageUtenteController) {
		this.homePageUtenteController = homePageUtenteController;
	}

	public Utente getUtenteConnesso() {
		return utenteConnesso;
	}

	public void setUtenteConnesso(Utente utenteConnesso) {
		this.utenteConnesso = utenteConnesso;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
