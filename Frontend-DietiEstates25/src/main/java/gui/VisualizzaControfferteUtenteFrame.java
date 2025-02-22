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
import controller.VisualizzaControfferteUtenteController;
import customElements.RoundedButton;
import dto.Controfferta;
import panel.ControffertaUtentePanel;
import starter.Starter;

public class VisualizzaControfferteUtenteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panePrincipale;
	private JPanel panelControfferte;
	private List<Controfferta> controfferte;
	private Starter starter;
	private VisualizzaControfferteUtenteController visualizzaControfferteUtenteController;
	private String token;

	public VisualizzaControfferteUtenteFrame(Starter starter,List<Controfferta> controfferte,String token) {
		this.starter=starter;
		this.controfferte=controfferte;
		this.setToken(token);
		this.visualizzaControfferteUtenteController=new VisualizzaControfferteUtenteController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 512);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		panePrincipale = new JPanel();
		setTitle("Controfferte ricevute");
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
		
		
		JFrame myFrame=this;
		
		JLabel lblNewLabel = new JLabel("Controfferte ricevute");
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
		gbl_panelCentrale.rowHeights = new int[]{0, 0};
		gbl_panelCentrale.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCentrale.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelCentrale.setLayout(gbl_panelCentrale);
		
		JPanel panelSx = new JPanel();
		GridBagConstraints gbc_panelSx = new GridBagConstraints();
		gbc_panelSx.anchor = GridBagConstraints.SOUTH;
		gbc_panelSx.insets = new Insets(0, 0, 0, 5);
		gbc_panelSx.gridx = 0;
		gbc_panelSx.gridy = 0;
		panelCentrale.add(panelSx, gbc_panelSx);
		GridBagLayout gbl_panelSx = new GridBagLayout();
		gbl_panelSx.columnWidths = new int[]{0, 97, 58, 0};
		gbl_panelSx.rowHeights = new int[]{56, 10, 0};
		gbl_panelSx.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSx.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelSx.setLayout(gbl_panelSx);
		
		JButton btnIndietro = new RoundedButton("Indietro",30,30);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchVisualizzaControfferteUtenteToHomePageUtente();
			}
		});
		btnIndietro.setFont(new Font("Arial", Font.PLAIN, 18));
		btnIndietro.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_btnIndietro = new GridBagConstraints();
		gbc_btnIndietro.insets = new Insets(0, 0, 5, 5);
		gbc_btnIndietro.anchor = GridBagConstraints.SOUTH;
		gbc_btnIndietro.gridx = 1;
		gbc_btnIndietro.gridy = 0;
		panelSx.add(btnIndietro, gbc_btnIndietro);
		
		
		panelControfferte = new JPanel();
        panelControfferte.setLayout(new BoxLayout(panelControfferte, BoxLayout.Y_AXIS)); // Layout verticale

        loadControfferteInAttesa();
        
        JScrollPane scrollPane = new JScrollPane(panelControfferte);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);


		
		GridBagConstraints gbc_scrollPane1 = new GridBagConstraints();
		gbc_scrollPane1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane1.gridx = 1;
		gbc_scrollPane1.gridy = 0;
		panelCentrale.add(scrollPane, gbc_scrollPane1);
		
		JPanel panelDx = new JPanel();
		GridBagConstraints gbc_panelDx = new GridBagConstraints();
		gbc_panelDx.fill = GridBagConstraints.BOTH;
		gbc_panelDx.gridx = 2;
		gbc_panelDx.gridy = 0;
		panelCentrale.add(panelDx, gbc_panelDx);
		
		
		
		
		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_fooBar = new GridBagConstraints();
		gbc_fooBar.fill = GridBagConstraints.BOTH;
		gbc_fooBar.gridx = 0;
		gbc_fooBar.gridy = 3;
		panePrincipale.add(fooBar, gbc_fooBar);
	}

	public void loadControfferteInAttesa() {
		panelControfferte.removeAll();
		for (Controfferta controfferta: controfferte) {
			if(controfferta.getEsito().equals("in attesa")) {
				panelControfferte.add(new ControffertaUtentePanel(controfferta,visualizzaControfferteUtenteController,token,starter));
				panelControfferte.add(Box.createVerticalStrut(10));
			}  
        }
		panelControfferte.revalidate();
		panelControfferte.repaint();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void showUpdateDialog(String message) {
		CustomDialog updateDialog=new CustomDialog(message,"Ok");
		updateDialog.setLocationRelativeTo(panePrincipale);
		updateDialog.setVisible(true);
		
	}
}
