package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import controller.VisualizzaInserzioniController;
import customElements.RoundedButton;
import dto.Inserzione;
import dto.Notifica;
import dto.NotificaCorrelazione;
import dto.NotificaPromozionale;
import dto.NotificaVisita;
import panel.InserzionePanel;
import panel.NotificaPanel;
import starter.Starter;
import customElements.ModernCheckBox;

public class VisualizzaNotificheUtente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panePrincipale;
	private JPanel panelNotifiche;
	private Starter starter;
	private ModernCheckBox checkboxCorrelazioni;
	private ModernCheckBox checkboxPromozioni;
	private ModernCheckBox checkboxVisite;
	private List<Notifica> notifiche;
	
	public VisualizzaNotificheUtente(Starter starter,List<Notifica> notifiche) {
		this.setStarter(starter);
		
		this.setNotifiche(notifiche);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 512);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		panePrincipale = new JPanel();
		setTitle("Notifiche");
		try {
            UIManager.put("ScrollBarUI", "com.sun.java.swing.plaf.windows.WindowsScrollBarUI");
        } catch (Exception e) {
           
        }
		setContentPane(panePrincipale);
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[]{881, 0};
		gbl_panePrincipale.rowHeights = new int[]{97, 0, 368, 40, 0};
		gbl_panePrincipale.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panePrincipale.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		
		JLabel lblNewLabel = new JLabel("Notifiche");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panePrincipale.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panelCentrale = new JPanel();
		GridBagConstraints gbc_panelCentrale = new GridBagConstraints();
		gbc_panelCentrale.insets = new Insets(0, 0, 5, 0);
		gbc_panelCentrale.fill = GridBagConstraints.BOTH;
		gbc_panelCentrale.gridx = 0;
		gbc_panelCentrale.gridy = 2;
		panePrincipale.add(panelCentrale, gbc_panelCentrale);
		GridBagLayout gbl_panelCentrale = new GridBagLayout();
		gbl_panelCentrale.columnWidths = new int[]{180, 547, 162, 0};
		gbl_panelCentrale.rowHeights = new int[]{0, 30, 0};
		gbl_panelCentrale.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCentrale.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelCentrale.setLayout(gbl_panelCentrale);
		
		JPanel panelSx = new JPanel();
		GridBagConstraints gbc_panelSx = new GridBagConstraints();
		gbc_panelSx.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelSx.insets = new Insets(0, 0, 5, 5);
		gbc_panelSx.gridx = 0;
		gbc_panelSx.gridy = 0;
		panelCentrale.add(panelSx, gbc_panelSx);
		GridBagLayout gbl_panelSx = new GridBagLayout();
		gbl_panelSx.columnWidths = new int[]{20, 97, 58, 0};
		gbl_panelSx.rowHeights = new int[]{0, 0, 0, 0, 0, 71, 68, 0, 0, 56, 10, 0};
		gbl_panelSx.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSx.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 10.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelSx.setLayout(gbl_panelSx);
		
		JLabel lblFiltri = new JLabel("Filtri:");
		lblFiltri.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblFiltri = new GridBagConstraints();
		gbc_lblFiltri.anchor = GridBagConstraints.WEST;
		gbc_lblFiltri.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltri.gridx = 1;
		gbc_lblFiltri.gridy = 0;
		panelSx.add(lblFiltri, gbc_lblFiltri);
		
		checkboxVisite = new ModernCheckBox((String) null);
		checkboxVisite.setSelected(true);
		checkboxVisite.setFont(new Font("Arial", Font.PLAIN, 18));
		checkboxVisite.setText("Visite");
		GridBagConstraints gbc_checkboxVisite = new GridBagConstraints();
		gbc_checkboxVisite.anchor = GridBagConstraints.WEST;
		gbc_checkboxVisite.insets = new Insets(0, 0, 5, 5);
		gbc_checkboxVisite.gridx = 1;
		gbc_checkboxVisite.gridy = 1;
		panelSx.add(checkboxVisite, gbc_checkboxVisite);
		
		checkboxPromozioni = new ModernCheckBox((String) null);
		checkboxPromozioni.setText("Promozioni");
		checkboxPromozioni.setFont(new Font("Arial", Font.PLAIN, 18));
		checkboxPromozioni.setSelected(true);
		GridBagConstraints gbc_checkboxPromozioni = new GridBagConstraints();
		gbc_checkboxPromozioni.anchor = GridBagConstraints.WEST;
		gbc_checkboxPromozioni.insets = new Insets(0, 0, 5, 5);
		gbc_checkboxPromozioni.gridx = 1;
		gbc_checkboxPromozioni.gridy = 2;
		panelSx.add(checkboxPromozioni, gbc_checkboxPromozioni);
		
		checkboxCorrelazioni = new ModernCheckBox((String) null);
		checkboxCorrelazioni.setFont(new Font("Arial", Font.PLAIN, 18));
		checkboxCorrelazioni.setText("Correlazioni");
		checkboxCorrelazioni.setSelected(true);
		GridBagConstraints gbc_checkboxCorrelazioni = new GridBagConstraints();
		gbc_checkboxCorrelazioni.insets = new Insets(0, 0, 5, 5);
		gbc_checkboxCorrelazioni.gridx = 1;
		gbc_checkboxCorrelazioni.gridy = 3;
		panelSx.add(checkboxCorrelazioni, gbc_checkboxCorrelazioni);
		
		RoundedButton btnFiltra = new RoundedButton("Filtra", 30, 30);
		btnFiltra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadNotifiche();
			}
		});
		btnFiltra.setBackground(new Color(255, 175, 68));
		
		btnFiltra.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_btnFiltra = new GridBagConstraints();
		gbc_btnFiltra.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltra.gridx = 1;
		gbc_btnFiltra.gridy = 4;
		panelSx.add(btnFiltra, gbc_btnFiltra);
		
		
		panelNotifiche = new JPanel();
        panelNotifiche.setLayout(new BoxLayout(panelNotifiche, BoxLayout.Y_AXIS)); // Layout verticale

        loadNotifiche();
        
        JScrollPane scrollPane = new JScrollPane(panelNotifiche);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);


		
		GridBagConstraints gbc_scrollPane1 = new GridBagConstraints();
		gbc_scrollPane1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane1.gridx = 1;
		gbc_scrollPane1.gridy = 0;
		panelCentrale.add(scrollPane, gbc_scrollPane1);
		
		JPanel panelDx = new JPanel();
		GridBagConstraints gbc_panelDx = new GridBagConstraints();
		gbc_panelDx.insets = new Insets(0, 0, 5, 0);
		gbc_panelDx.fill = GridBagConstraints.BOTH;
		gbc_panelDx.gridx = 2;
		gbc_panelDx.gridy = 0;
		panelCentrale.add(panelDx, gbc_panelDx);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panelCentrale.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 137, 50, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnIndietro = new RoundedButton("Indietro",30,30);
		GridBagConstraints gbc_btnIndietro = new GridBagConstraints();
		gbc_btnIndietro.anchor = GridBagConstraints.SOUTH;
		gbc_btnIndietro.insets = new Insets(0, 0, 0, 5);
		gbc_btnIndietro.gridx = 1;
		gbc_btnIndietro.gridy = 0;
		panel.add(btnIndietro, gbc_btnIndietro);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchVisualizzaNotificheToHomePageUtente();
			}
		});
		btnIndietro.setFont(new Font("Arial", Font.PLAIN, 24));
		btnIndietro.setBackground(new Color(217, 217, 217));
		
			
		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_fooBar = new GridBagConstraints();
		gbc_fooBar.fill = GridBagConstraints.BOTH;
		gbc_fooBar.gridx = 0;
		gbc_fooBar.gridy = 3;
		panePrincipale.add(fooBar, gbc_fooBar);
	}

	public void loadNotifiche() {
		panelNotifiche.removeAll();
        for (Notifica notifica: notifiche) {
        	if(notifica instanceof NotificaVisita && checkboxVisite.isSelected()) {
        		panelNotifiche.add(new NotificaPanel(notifica));
        		panelNotifiche.add(Box.createVerticalStrut(5));
        	}
        	if(notifica instanceof NotificaPromozionale && checkboxPromozioni.isSelected()) {
        		panelNotifiche.add(new NotificaPanel(notifica));
        		panelNotifiche.add(Box.createVerticalStrut(5));
        	}
        	if(notifica instanceof NotificaCorrelazione && checkboxCorrelazioni.isSelected()) {
        		panelNotifiche.add(new NotificaPanel(notifica));
        		panelNotifiche.add(Box.createVerticalStrut(5));
        	}
            
        }
        panelNotifiche.revalidate();
        panelNotifiche.repaint();
	}
	public void showDeleteDialog() {
		CustomDialog deleteDialog=new CustomDialog("Inserzione eliminata con successo","Ok");
		deleteDialog.setLocationRelativeTo(panePrincipale);
		deleteDialog.setVisible(true);
	}
	public void showErrorDeleteDialog() {
		CustomDialog deleteDialog=new CustomDialog("Errore nell'eliminazione dell'inserzione","Ok");
		deleteDialog.setLocationRelativeTo(panePrincipale);
		deleteDialog.setVisible(true);
	}
	

	public Starter getStarter() {
		return starter;
	}

	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	public List<Notifica> getNotifiche() {
		return notifiche;
	}

	public void setNotifiche(List<Notifica> notifiche) {
		this.notifiche = notifiche;
	}

}
