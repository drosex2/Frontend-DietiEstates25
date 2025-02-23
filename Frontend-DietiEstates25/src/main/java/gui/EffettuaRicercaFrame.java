package gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.text.NumberFormatter;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import controller.RicercaController;
import customElements.ModernCheckBox;
import customElements.RoundedButton;
import customElements.RoundedFormattedTextField;
import dto.Inserzione;
import dto.Ricerca;
import dto.Utente;
import starter.Starter;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class EffettuaRicercaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panePrincipale;
	private Starter starter;
	private Utente utenteConnesso;
	private String token;
	private double[] coordinate=new double[2];
	private RoundedFormattedTextField numeroStanzeField;
	private RoundedFormattedTextField minField;
	private RoundedFormattedTextField maxField;
	private RicercaController ricercaController;
	private JComboBox<String> comboBoxTipologia;
	private JComboBox<String> comboBoxCitta;
	private JComboBox<String> comboBoxClasseEnergetica;
	private ModernCheckBox checkboxRicercaConMappa;
	private RoundedFormattedTextField raggioField; 

	public EffettuaRicercaFrame(Starter pStarter, String token, Utente utente) {
		this.starter = pStarter;
		this.setToken(token);
		this.utenteConnesso = utente;
		this.ricercaController=new RicercaController(token);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1288, 813);
		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(217, 217, 217));
		setContentPane(panePrincipale);
		setTitle("Inserisci Inserzione");
		try {
			UIManager.put("ScrollBarUI", "com.sun.java.swing.plaf.windows.WindowsScrollBarUI");
		} catch (Exception e) {

		}
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[] { 1278, 0 };
		gbl_panePrincipale.rowHeights = new int[] { 97, 617, 55, 0 };
		gbl_panePrincipale.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panePrincipale.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panePrincipale.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 20, 100, 100, 100, 0 };
		gbl_panel.rowHeights = new int[] { 544, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 5.0, 0.0, 5.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 2.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_formPanel = new GridBagConstraints();
		gbc_formPanel.insets = new Insets(0, 0, 5, 5);
		gbc_formPanel.fill = GridBagConstraints.BOTH;
		gbc_formPanel.gridx = 2;
		gbc_formPanel.gridy = 0;
		panel.add(formPanel, gbc_formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[] { 400, 0, 400, 0 };
		gbl_formPanel.rowHeights = new int[] { 0, 81, 0, 0 };
		gbl_formPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_formPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		formPanel.setLayout(gbl_formPanel);

		JLabel lblWelcome = new JLabel("Effettua Ricerca ");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 32));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.anchor = GridBagConstraints.SOUTH;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 1;
		formPanel.add(lblWelcome, gbc_lblWelcome);
		JPanel formPanelInterno = new JPanel();
		GridBagConstraints gbc_formPanelInterno = new GridBagConstraints();
		gbc_formPanelInterno.anchor = GridBagConstraints.NORTHWEST;
		gbc_formPanelInterno.insets = new Insets(0, 0, 0, 5);
		gbc_formPanelInterno.gridx = 0;
		gbc_formPanelInterno.gridy = 2;
		formPanel.add(formPanelInterno, gbc_formPanelInterno);
		formPanelInterno.setBackground(new Color(217, 217, 217));
		GridBagLayout gbl_formPanelInterno = new GridBagLayout();
		gbl_formPanelInterno.columnWidths = new int[] { 346, 0 };
		gbl_formPanelInterno.rowHeights = new int[] { 30, 40, 30, 39, 30, 40, 30, 0, 0, 40, 0, 0, 0 };
		gbl_formPanelInterno.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_formPanelInterno.rowWeights = new double[] { 2.0, 1.0, 2.0, 0.0, 2.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		formPanelInterno.setLayout(gbl_formPanelInterno);

		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblTipologia = new GridBagConstraints();
		gbc_lblTipologia.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTipologia.insets = new Insets(0, 0, 5, 0);
		gbc_lblTipologia.gridx = 0;
		gbc_lblTipologia.gridy = 0;
		formPanelInterno.add(lblTipologia, gbc_lblTipologia);
		

		comboBoxTipologia = new JComboBox<String>();
		comboBoxTipologia.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxTipologia.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleziona una tipologia", "affitto", "vendita"}));
		comboBoxTipologia.setBackground(new Color(192, 192, 192));

		GridBagConstraints gbc_comboBoxTipologia = new GridBagConstraints();
		gbc_comboBoxTipologia.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxTipologia.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTipologia.gridx = 0;
		gbc_comboBoxTipologia.gridy = 1;
		formPanelInterno.add(comboBoxTipologia, gbc_comboBoxTipologia);

		JLabel lblCitta = new JLabel("Comune/Citta");
		lblCitta.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblCitta = new GridBagConstraints();
		gbc_lblCitta.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCitta.insets = new Insets(0, 0, 5, 0);
		gbc_lblCitta.gridx = 0;
		gbc_lblCitta.gridy = 2;
		formPanelInterno.add(lblCitta, gbc_lblCitta);
		NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
		numberFormatter.setAllowsInvalid(true);
        numberFormatter.setCommitsOnValidEdit(true);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(0);
		
		LinkedList<String> comuni;
		try {
			comuni = ricercaController.getComuni();
		} catch (IOException | InterruptedException e) {
			comuni = new LinkedList<String>();
		}
		comuni.addFirst("Seleziona un comune/città");
		comboBoxCitta = new JComboBox<String>(comuni.toArray(new String[0]));
		comboBoxCitta.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxCitta.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_comboBoxCitta = new GridBagConstraints();
		gbc_comboBoxCitta.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxCitta.fill = GridBagConstraints.BOTH;
		gbc_comboBoxCitta.gridx = 0;
		gbc_comboBoxCitta.gridy = 3;
		formPanelInterno.add(comboBoxCitta, gbc_comboBoxCitta);

		JLabel lblPrezzo = new JLabel("Range prezzo");
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrezzo.gridx = 0;
		gbc_lblPrezzo.gridy = 4;
		formPanelInterno.add(lblPrezzo, gbc_lblPrezzo);
		

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 5;
		formPanelInterno.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 172, 0, 172, 0 };
		gbl_panel_3.rowHeights = new int[] { 35, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblMin = new JLabel("Min");
		lblMin.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblMin = new GridBagConstraints();
		gbc_lblMin.anchor = GridBagConstraints.EAST;
		gbc_lblMin.insets = new Insets(0, 0, 0, 5);
		gbc_lblMin.gridx = 0;
		gbc_lblMin.gridy = 0;
		panel_3.add(lblMin, gbc_lblMin);
		
		minField = new RoundedFormattedTextField(numberFormatter);
		minField.setFont(new Font("Arial", Font.PLAIN, 18));
		minField.setBackground(new Color(192, 192, 192));
		minField.setMaximumSize(new Dimension(30, 30));
		minField.setValue(0);
		GridBagConstraints gbc_minField = new GridBagConstraints();
		gbc_minField.insets = new Insets(0, 0, 0, 5);
		gbc_minField.fill = GridBagConstraints.HORIZONTAL;
		gbc_minField.gridx = 1;
		gbc_minField.gridy = 0;
		panel_3.add(minField, gbc_minField);

		JLabel lblMax = new JLabel("Max");
		lblMax.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblMax = new GridBagConstraints();
		gbc_lblMax.insets = new Insets(0, 0, 0, 5);
		gbc_lblMax.gridx = 2;
		gbc_lblMax.gridy = 0;
		panel_3.add(lblMax, gbc_lblMax);

		maxField = new RoundedFormattedTextField(numberFormatter);
		maxField.setFont(new Font("Arial", Font.PLAIN, 18));
		maxField.setBackground(new Color(192, 192, 192));
		maxField.setMaximumSize(new Dimension(30, 30));
		maxField.setValue(0);
		GridBagConstraints gbc_maxField = new GridBagConstraints();
		gbc_maxField.fill = GridBagConstraints.HORIZONTAL;
		gbc_maxField.gridx = 3;
		gbc_maxField.gridy = 0;
		panel_3.add(maxField, gbc_maxField);

		JLabel lblNumeroStanze = new JLabel("Numero stanze");
		lblNumeroStanze.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNumeroStanze = new GridBagConstraints();
		gbc_lblNumeroStanze.anchor = GridBagConstraints.WEST;
		gbc_lblNumeroStanze.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumeroStanze.gridx = 0;
		gbc_lblNumeroStanze.gridy = 6;
		formPanelInterno.add(lblNumeroStanze, gbc_lblNumeroStanze);
		numeroStanzeField = new RoundedFormattedTextField(numberFormatter);
		numeroStanzeField.setValue(0);
		numeroStanzeField.setFont(new Font("Arial", Font.PLAIN, 18));
		numeroStanzeField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_numeroStanzeField = new GridBagConstraints();
		gbc_numeroStanzeField.insets = new Insets(0, 0, 5, 0);
		gbc_numeroStanzeField.fill = GridBagConstraints.BOTH;
		gbc_numeroStanzeField.gridx = 0;
		gbc_numeroStanzeField.gridy = 7;
		formPanelInterno.add(numeroStanzeField, gbc_numeroStanzeField);

		JLabel lblClasseEnergetica = new JLabel("Classe energetica");
		lblClasseEnergetica.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblClasseEnergetica = new GridBagConstraints();
		gbc_lblClasseEnergetica.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblClasseEnergetica.insets = new Insets(0, 0, 5, 0);
		gbc_lblClasseEnergetica.gridx = 0;
		gbc_lblClasseEnergetica.gridy = 8;
		formPanelInterno.add(lblClasseEnergetica, gbc_lblClasseEnergetica);

		comboBoxClasseEnergetica = new JComboBox<String>();
		comboBoxClasseEnergetica.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleziona una classe energetica", "A4", "A3", "A2", "A1", "B", "C", "D", "E", "F", "G"}));
		comboBoxClasseEnergetica.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxClasseEnergetica.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_comboBoxClasseEnergetica = new GridBagConstraints();
		gbc_comboBoxClasseEnergetica.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxClasseEnergetica.fill = GridBagConstraints.BOTH;
		gbc_comboBoxClasseEnergetica.gridx = 0;
		gbc_comboBoxClasseEnergetica.gridy = 9;
		formPanelInterno.add(comboBoxClasseEnergetica, gbc_comboBoxClasseEnergetica);

		JPanel panelBottoni = new JPanel();
		GridBagConstraints gbc_panelBottoni = new GridBagConstraints();
		gbc_panelBottoni.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panelBottoni.insets = new Insets(0, 0, 0, 5);
		gbc_panelBottoni.gridx = 1;
		gbc_panelBottoni.gridy = 2;
		formPanel.add(panelBottoni, gbc_panelBottoni);
		panelBottoni.setBackground(new Color(217, 217, 217));
		GridBagLayout gbl_panelBottoni = new GridBagLayout();
		gbl_panelBottoni.columnWidths = new int[] { 170, 149, 0 };
		gbl_panelBottoni.rowHeights = new int[] { 30, 0 };
		gbl_panelBottoni.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelBottoni.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelBottoni.setLayout(gbl_panelBottoni);

		RoundedButton btnEffettua = new RoundedButton("Registrati", 30, 30);
		GridBagConstraints gbc_btnEffettua = new GridBagConstraints();
		gbc_btnEffettua.fill = GridBagConstraints.VERTICAL;
		gbc_btnEffettua.insets = new Insets(0, 0, 0, 5);
		gbc_btnEffettua.gridx = 0;
		gbc_btnEffettua.gridy = 0;
		panelBottoni.add(btnEffettua, gbc_btnEffettua);
		JFrame myFrame=this;
		btnEffettua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Ricerca in corso","");
				loadingDialog.setLocationRelativeTo(panePrincipale);
				
					SwingWorker<Void, Void> worker = new SwingWorker<>() {
			            @Override
			            protected Void doInBackground() throws Exception {
			            	
			            	List<Inserzione> risultatiRicerca=new ArrayList<Inserzione>();
			            	risultatiRicerca=effettuaRicerca();
			            	
			            	if(risultatiRicerca.isEmpty()) {
			            		throw new Exception("La ricerca non ha generato risultati");
			            	}
			            	starter.switchEffettuaRicercaToRisultatiRicerca(utenteConnesso,token,risultatiRicerca,myFrame);
			                return null;
			            }

			            @Override
			            protected void done() {
			            	try {
			            		get();
			            		loadingDialog.dispose();
			            	}catch(InterruptedException ex){
			            		
			            		loadingDialog.dispose();
			            		showCustomDialog("Errore nello svolgimento della ricerca","Riprova");
			            					            		
			                }catch(Exception ex){
			                	
			                	loadingDialog.dispose();
			                	
			                	showCustomDialog(ex.getMessage(),"Riprova");
			                }
			            }
			        };
			     worker.execute();
			     loadingDialog.setVisible(true);
				
			}
	
		});
		btnEffettua.setText("Effettua");
		btnEffettua.setPreferredSize(new Dimension(150, 30));
		btnEffettua.setFont(new Font("Arial", Font.PLAIN, 22));
		btnEffettua.setBackground(new Color(255, 175, 68));

		RoundedButton btnAnnulla = new RoundedButton("Annulla", 30, 30);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchEffettuaRicercaToHomePageUtente();
			}
		});
		btnAnnulla.setText("   Annulla   ");
		btnAnnulla.setMaximumSize(new Dimension(78, 22));

		btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.fill = GridBagConstraints.VERTICAL;
		gbc_btnAnnulla.gridx = 1;
		gbc_btnAnnulla.gridy = 0;
		panelBottoni.add(btnAnnulla, gbc_btnAnnulla);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 2;
		formPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 226, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);
		
		checkboxRicercaConMappa = new ModernCheckBox("Effettua ricerca con mappa");
		checkboxRicercaConMappa.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(checkboxRicercaConMappa.isSelected()) {
					raggioField.setEditable(true);
				}else {
					raggioField.setEditable(false);
				}
			}
		});
		checkboxRicercaConMappa.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkboxRicercaConMappa.setForeground(new Color(0, 0, 0));
		checkboxRicercaConMappa.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_checkboxRicercaConMappa = new GridBagConstraints();
		gbc_checkboxRicercaConMappa.anchor = GridBagConstraints.WEST;
		gbc_checkboxRicercaConMappa.insets = new Insets(0, 0, 5, 0);
		gbc_checkboxRicercaConMappa.gridx = 0;
		gbc_checkboxRicercaConMappa.gridy = 0;
		panel_1.add(checkboxRicercaConMappa, gbc_checkboxRicercaConMappa);

		JLabel lblRaggio = new JLabel(" Raggio di ricerca");
		lblRaggio.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblRaggio = new GridBagConstraints();
		gbc_lblRaggio.anchor = GridBagConstraints.WEST;
		gbc_lblRaggio.insets = new Insets(0, 0, 5, 0);
		gbc_lblRaggio.gridx = 0;
		gbc_lblRaggio.gridy = 1;
		panel_1.add(lblRaggio, gbc_lblRaggio);

		raggioField = new RoundedFormattedTextField(numberFormatter);
		raggioField.setEditable(false);
		
		raggioField.setFont(new Font("Arial", Font.PLAIN, 18));
		raggioField.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_raggioField = new GridBagConstraints();
		gbc_raggioField.insets = new Insets(0, 0, 5, 0);
		gbc_raggioField.fill = GridBagConstraints.HORIZONTAL;
		gbc_raggioField.gridx = 0;
		gbc_raggioField.gridy = 2;
		panel_1.add(raggioField, gbc_raggioField);
		
		JLabel lblDoppioClick = new JLabel("Doppio click per selezionare un punto sulla mappa:");
		lblDoppioClick.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDoppioClick = new GridBagConstraints();
		gbc_lblDoppioClick.anchor = GridBagConstraints.WEST;
		gbc_lblDoppioClick.insets = new Insets(0, 0, 5, 0);
		gbc_lblDoppioClick.gridx = 0;
		gbc_lblDoppioClick.gridy = 3;
		panel_1.add(lblDoppioClick, gbc_lblDoppioClick);

		
		GridBagConstraints gbc_panelMappa = new GridBagConstraints();
		JXMapViewer mapViewer=getJxMapViewer();
		gbc_panelMappa.insets = new Insets(0, 0, 5, 0);
		gbc_panelMappa.fill = GridBagConstraints.BOTH;
		gbc_panelMappa.gridx = 0;
		gbc_panelMappa.gridy = 4;
		panel_1.add(mapViewer, gbc_panelMappa);

		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_fooBar = new GridBagConstraints();
		gbc_fooBar.fill = GridBagConstraints.BOTH;
		gbc_fooBar.gridx = 0;
		gbc_fooBar.gridy = 2;
		panePrincipale.add(fooBar, gbc_fooBar);

	}

	protected void inserimentoInserzioneRiuscitoDialog() {
		CustomDialog dialog = new CustomDialog("Inserimento inserzione eseguito con successo!", "Ok");
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);

	}

	public void compilaCampiDialog() {
		CustomDialog dialog = new CustomDialog("Compila tutti i campi", "Ok");
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}

	public void inserimentoInserzioneFallitoDialog() {
		CustomDialog dialog = new CustomDialog("Inserimento inserzione non riuscito", "Torna alla home");
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	private JXMapViewer getJxMapViewer() {
        JXMapViewer mapViewer = new JXMapViewer();

        OSMTileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);
        
        mapViewer.setZoom(2);
        GeoPosition myPoint= new GeoPosition(41.9028, 12.4964);
		mapViewer.setAddressLocation(myPoint);

        Set<Waypoint> waypoints = new HashSet<>();
        
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);

        mapViewer.setOverlayPainter(waypointPainter);
        mapViewer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                
                Point clickPoint = e.getPoint();
                GeoPosition geoPosition = mapViewer.convertPointToGeoPosition(clickPoint);

				coordinate[0]=geoPosition.getLatitude();
				coordinate[1]=geoPosition.getLongitude();
				waypoints.clear();
				               
                DefaultWaypoint waypoint = new DefaultWaypoint(geoPosition);
                waypoints.add(waypoint);
                
                waypointPainter.setWaypoints(waypoints);
                mapViewer.repaint();
               }
            }
        });
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addMouseMotionListener(new PanMouseInputListener(mapViewer));
        return mapViewer;
    }
	
	public List<Inserzione> effettuaRicerca()throws Exception,IOException,InterruptedException{
		if(checkboxRicercaConMappa.isSelected()){
			return effettuaRicercaConMappa();
		}else {
			return effettuaRicercaConFiltri();
		}
	}
	
	private List<Inserzione> effettuaRicercaConMappa()throws Exception,IOException,InterruptedException{
		int raggio=((Number)raggioField.getValue()).intValue();
		
		if(raggio!=0 && coordinate[0]!=0.0 && coordinate[1]!=0.0) {
			return ricercaController.getByRaggio(coordinate[0], coordinate[1], raggio);
		}else {
			throw new Exception("Indica il raggio e seleziona un punto sulla mappa");
		}
		
	}

	public List<Inserzione> effettuaRicercaConFiltri() throws Exception,IOException,InterruptedException{
		if(ricercaPerCitta()) {
			String citta=getCittaSelezionata();
			return ricercaController.getByCitta(citta);
		}else if(ricercaPerRangePrezzo()) {
			int prezzoMin=getPrezzoMinimoInserito();
			int prezzoMax=getPrezzoMassimoInserito();
			return ricercaController.getByRangePrezzo(prezzoMin, prezzoMax);
		}else if(ricercaPerNumeroStanze()) {
			int numeroStanze=getNumeroStanzeInserito();
			return ricercaController.getByNumeroStanze(numeroStanze);
		}else if(ricercaPerClasseEnergetica()) {
			String classeEnergetica= getClasseEnergeticaSelezionata();
			return ricercaController.getByClasseEnergetica(classeEnergetica);
		}else if(campiCompilati()) {
			Ricerca ricerca=estraiRicerca();
			return ricercaController.eseguiRicerca(ricerca);
		}else {
			throw new Exception("Compila tutti i campi per una ricerca con più filtri");
		}
	}

	public int getNumeroStanzeInserito() {
		return ((Number)numeroStanzeField.getValue()).intValue();
	}

	public int getPrezzoMassimoInserito() {
		return ((Number)maxField.getValue()).intValue();
	}

	public int getPrezzoMinimoInserito() {
		return ((Number)minField.getValue()).intValue();
	}
	
	
	
	
	private Ricerca estraiRicerca() {
		String citta=getCittaSelezionata();
		int prezzoMin=getPrezzoMinimoInserito();
		int prezzoMax=getPrezzoMassimoInserito();
		int numeroStanze=getNumeroStanzeInserito();
		String classeEnergetica= getClasseEnergeticaSelezionata();
		String tipologia=getTipologiaSelezionata();
		Ricerca ricerca=new Ricerca(0,prezzoMin,prezzoMax,tipologia,citta,numeroStanze,classeEnergetica,utenteConnesso);
		return ricerca;
	}

	public boolean ricercaPerCitta() {
		return !getCittaSelezionata().equals("Seleziona un comune/città") &&
				getNumeroStanzeInserito()==0 && 
				getTipologiaSelezionata().equals("Seleziona una tipologia") &&
				getClasseEnergeticaSelezionata().equals("Seleziona una classe energetica") &&
				getPrezzoMassimoInserito()==0;
				
	}

	public String getClasseEnergeticaSelezionata() {
		return (String)comboBoxClasseEnergetica.getSelectedItem();
	}

	public String getTipologiaSelezionata() {
		return (String)comboBoxTipologia.getSelectedItem();
	}

	public String getCittaSelezionata() {
		return (String)comboBoxCitta.getSelectedItem();
	}
	public boolean ricercaPerRangePrezzo() {
		return  getPrezzoMassimoInserito()!=0 &&
				getNumeroStanzeInserito()==0 && 
				getTipologiaSelezionata().equals("Seleziona una tipologia") &&
				getClasseEnergeticaSelezionata().equals("Seleziona una classe energetica") &&
				getCittaSelezionata().equals("Seleziona un comune/città");
				
	}
	public boolean ricercaPerNumeroStanze() {
		return  getNumeroStanzeInserito()!=0 && 
				getPrezzoMassimoInserito()==0 &&
				getTipologiaSelezionata().equals("Seleziona una tipologia") &&
				getClasseEnergeticaSelezionata().equals("Seleziona una classe energetica") &&
				getCittaSelezionata().equals("Seleziona un comune/città");
				
	}
	public boolean ricercaPerClasseEnergetica() {
		return  !getClasseEnergeticaSelezionata().equals("Seleziona una classe energetica")&&
				getPrezzoMassimoInserito()==0 &&
				getNumeroStanzeInserito()==0 && 
				getTipologiaSelezionata().equals("Seleziona una tipologia") && 
				getCittaSelezionata().equals("Seleziona un comune/città");
				
	}
	public boolean campiCompilati() {
		return  !getClasseEnergeticaSelezionata().equals("Seleziona una classe energetica")&&
				getPrezzoMassimoInserito()!=0 &&
				getNumeroStanzeInserito()!=0 && 
				!getTipologiaSelezionata().equals("Seleziona una tipologia") && 
				!getCittaSelezionata().equals("Seleziona un comune/città");
	}
	
	private void showCustomDialog(String message,String testoButton) {
		message=message.replace("java.lang.Exception: ", "");
		CustomDialog dialog = new CustomDialog(message, testoButton);
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}
}
