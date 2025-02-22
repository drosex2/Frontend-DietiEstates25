package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import controller.HomePageAdminController;
import customElements.RoundedButton;
import dto.Amministratore;
import dto.Inserzione;
import starter.Starter;
import javax.swing.SwingWorker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePageAdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panePrincipale;
	private Starter starter;
	private HomePageAdminController homePageAdminController;
	private Amministratore adminConnesso;
	private String token;

	public HomePageAdminFrame(Starter starter, Amministratore adminConnesso, String token) {
		this.adminConnesso = adminConnesso;
		this.starter = starter;
		this.token = token;
		this.homePageAdminController = new HomePageAdminController(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);

		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(217, 217, 217));
		setTitle("HomePage amministratore");

		setContentPane(panePrincipale);
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[] { 881, 0 };
		gbl_panePrincipale.rowHeights = new int[] { 97, 473, 40, 0 };
		gbl_panePrincipale.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panePrincipale.rowWeights = new double[] { 1.0, 10.0, 0.0, Double.MIN_VALUE };
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
		gbl_navBar.columnWidths = new int[] { 84, 293, 502, 0 };
		gbl_navBar.rowHeights = new int[] { 104, 0 };
		gbl_navBar.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_navBar.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		navBar.setLayout(gbl_navBar);

		JLabel logoImage = new JLabel("");

		logoImage.setIcon(
				new ImageIcon(LoginFrame.class.getResource("/DietiEstates25/client/gui/images/logoFigma80.png")));
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
		logoutImage.setIcon(
				new ImageIcon(LoginFrame.class.getResource("/DietiEstates25/client/gui/images/logoutButton.png")));
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
		gbl_panel.columnWidths = new int[] { 100, 100, 100, 0 };
		gbl_panel.rowHeights = new int[] { 363, 0 };
		gbl_panel.columnWeights = new double[] { 5.0, 1.0, 5.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
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
		gbl_loginFormPanel.columnWidths = new int[] { 120, 560, 118, 0 };
		gbl_loginFormPanel.rowHeights = new int[] { 0, 25, 70, 20, 70, 20, 70, 20, 70, 0, 10, 0 };
		gbl_loginFormPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_loginFormPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, 0.0,
				Double.MIN_VALUE };
		loginFormPanel.setLayout(gbl_loginFormPanel);

		RoundedButton btnVisualizzaInserzioni = new RoundedButton("Visualizza inserzioni dell'agenzia", 30, 30);
		btnVisualizzaInserzioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Inserzione> inserzioni = homePageAdminController
								.ottieniInserzioniAgenzia(adminConnesso.getAgenzia().getNome());
						if (inserzioni.isEmpty()) {
							throw new Exception("Nessuna inserzione disponibile");
						}
						starter.switchHomePageAdminToVisualizzaInserzioni(starter, token, inserzioni);
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
		btnVisualizzaInserzioni.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVisualizzaInserzioni.setForeground(new Color(255, 255, 255));
		btnVisualizzaInserzioni.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_btnVisualizzaInserzioni = new GridBagConstraints();
		gbc_btnVisualizzaInserzioni.fill = GridBagConstraints.BOTH;
		gbc_btnVisualizzaInserzioni.insets = new Insets(0, 0, 5, 5);
		gbc_btnVisualizzaInserzioni.gridx = 1;
		gbc_btnVisualizzaInserzioni.gridy = 2;
		loginFormPanel.add(btnVisualizzaInserzioni, gbc_btnVisualizzaInserzioni);

		RoundedButton btnNuovoAdmin = new RoundedButton("Crea nuovo amministratore", 30, 30);
		btnNuovoAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchHomePageAdminToCreaAmministratoreFrame(adminConnesso, token);
			}
		});
		btnNuovoAdmin.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNuovoAdmin.setBackground(new Color(16, 49, 71));
		btnNuovoAdmin.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnNuovoAdmin = new GridBagConstraints();
		gbc_btnNuovoAdmin.fill = GridBagConstraints.BOTH;
		gbc_btnNuovoAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuovoAdmin.gridx = 1;
		gbc_btnNuovoAdmin.gridy = 4;
		loginFormPanel.add(btnNuovoAdmin, gbc_btnNuovoAdmin);

		RoundedButton btnNuovoAgente = new RoundedButton("Crea nuovo agente immobiliare", 30, 30);
		btnNuovoAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchHomePageAdminToCreaAgenteFrame(adminConnesso, token);
			}
		});
		btnNuovoAgente.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNuovoAgente.setForeground(new Color(255, 255, 255));
		btnNuovoAgente.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_btnNuovoAgente = new GridBagConstraints();
		gbc_btnNuovoAgente.fill = GridBagConstraints.BOTH;
		gbc_btnNuovoAgente.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuovoAgente.gridx = 1;
		gbc_btnNuovoAgente.gridy = 6;
		loginFormPanel.add(btnNuovoAgente, gbc_btnNuovoAgente);

		RoundedButton btnModificaPassword = new RoundedButton("Modifica password", 30, 30);
		btnModificaPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchHomePageAdminToModificaPasswordFrame(adminConnesso, token);
			}
		});
		btnModificaPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		btnModificaPassword.setForeground(new Color(255, 255, 255));
		btnModificaPassword.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_btnModificaPassword = new GridBagConstraints();
		gbc_btnModificaPassword.fill = GridBagConstraints.BOTH;
		gbc_btnModificaPassword.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificaPassword.gridx = 1;
		gbc_btnModificaPassword.gridy = 8;
		loginFormPanel.add(btnModificaPassword, gbc_btnModificaPassword);

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

	public HomePageAdminController getHomePageAdminController() {
		return homePageAdminController;
	}

	public void setHomePageAdminController(HomePageAdminController homePageAdminController) {
		this.homePageAdminController = homePageAdminController;
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
