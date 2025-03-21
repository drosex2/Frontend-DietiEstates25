package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.ModificaInserzioneController;
import dto.Inserzione;
import starter.Starter;
import utils.S3Utils;
import customElements.RoundedTextArea;
import customElements.RoundedTextField;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.text.NumberFormatter;
import customElements.RoundedFormattedTextField;
import customElements.RoundedButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.FileDialog;
import customElements.ModernCheckBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ModificaInserzioneFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panePrincipale;
	private Starter starter;
	private Inserzione inserzione;
	private String token;
	private ModificaInserzioneController modificaInserzioneController;
	private RoundedTextField titoloField;
	private JTextArea textArea;
	private RoundedFormattedTextField prezzoField;
	private JLabel lblFoto;
	private JComboBox<String> comboBoxTipologia;
	private RoundedTextField indirizzoField;
	private JComboBox<String> comboBoxCitta;
	private RoundedTextField codicePostaleField;
	private RoundedFormattedTextField dimensioneField;
	private RoundedFormattedTextField pianoField;
	private ModernCheckBox checkboxAscensore;
	private JComboBox<String> comboBoxClasseEnergetica;
	private RoundedFormattedTextField numeroStanzeField;
	private JFrame homePage;
	
	
	
	
	public ModificaInserzioneFrame(Starter pStarter, String token, Inserzione pInserzione,JFrame homePage) {
		this.starter=pStarter;
		this.setToken(token);
		this.inserzione=pInserzione;
		this.homePage=homePage;
		this.modificaInserzioneController=new ModificaInserzioneController(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		
		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(217, 217, 217));
		setTitle("Modifica Inserzione");

		setContentPane(panePrincipale);
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[]{881, 0};
		gbl_panePrincipale.rowHeights = new int[]{97, 695, 41, 0};
		gbl_panePrincipale.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panePrincipale.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
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
		gbl_formPanel.rowHeights = new int[]{0, 0, 0};
		gbl_formPanel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel lblWelcome = new JLabel("Modifica inserzione");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 28));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		formPanel.add(lblWelcome, gbc_lblWelcome);
		JPanel formPanelInterno = new JPanel();
		GridBagConstraints gbc_formPanelInterno = new GridBagConstraints();
		gbc_formPanelInterno.insets = new Insets(0, 0, 5, 5);
		gbc_formPanelInterno.gridx = 1;
		gbc_formPanelInterno.gridy = 1;
		formPanel.add(formPanelInterno, gbc_formPanelInterno);
		
		formPanelInterno.setBackground(new Color(217, 217, 217));
		
		
		
		GridBagLayout gbl_formPanelInterno = new GridBagLayout();
		gbl_formPanelInterno.columnWidths = new int[]{275, 10, 321, 0};
		gbl_formPanelInterno.rowHeights = new int[]{30, 40, 30, 63, 30, 40, 30, 0, 40, 0, 30, 0, 0, 0, 0, 0, 0};
		gbl_formPanelInterno.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_formPanelInterno.rowWeights = new double[]{2.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		formPanelInterno.setLayout(gbl_formPanelInterno);
		
		JLabel lblTitolo = new JLabel("Titolo");
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTitolo = new GridBagConstraints();
		gbc_lblTitolo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTitolo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitolo.gridx = 0;
		gbc_lblTitolo.gridy = 0;
		formPanelInterno.add(lblTitolo, gbc_lblTitolo);
		
		JLabel lblCitta = new JLabel("Comune/Città");
		lblCitta.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCitta = new GridBagConstraints();
		gbc_lblCitta.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCitta.insets = new Insets(0, 0, 5, 0);
		gbc_lblCitta.gridx = 2;
		gbc_lblCitta.gridy = 0;
		formPanelInterno.add(lblCitta, gbc_lblCitta);
		
		titoloField = new RoundedTextField(15, 30, 30);
		titoloField.setText(inserzione.getTitolo());
		titoloField.setFont(new Font("Arial", Font.PLAIN, 14));
		titoloField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_titoloField = new GridBagConstraints();
		gbc_titoloField.insets = new Insets(0, 0, 5, 5);
		gbc_titoloField.fill = GridBagConstraints.BOTH;
		gbc_titoloField.gridx = 0;
		gbc_titoloField.gridy = 1;
		formPanelInterno.add(titoloField, gbc_titoloField);
		NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
		numberFormatter.setAllowsInvalid(true);
        numberFormatter.setCommitsOnValidEdit(true);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(0);
		AtomicReference<File> selectedFile= new AtomicReference<>();
		ArrayList<String> comuni;
		try {
			comuni=modificaInserzioneController.getComuni();
		} catch (IOException | InterruptedException e) {
			comuni=new ArrayList<String>();
		}
		comboBoxCitta = new JComboBox<String>(comuni.toArray(new String[0]));
		comboBoxCitta.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBoxCitta.setBackground(new Color(192, 192, 192));
		comboBoxCitta.setSelectedItem(inserzione.getImmobile().getCitta());
		GridBagConstraints gbc_comboBoxCitta = new GridBagConstraints();
		gbc_comboBoxCitta.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxCitta.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCitta.gridx = 2;
		gbc_comboBoxCitta.gridy = 1;
		formPanelInterno.add(comboBoxCitta, gbc_comboBoxCitta);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
		gbc_lblDescrizione.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblDescrizione.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrizione.gridx = 0;
		gbc_lblDescrizione.gridy = 2;
		formPanelInterno.add(lblDescrizione, gbc_lblDescrizione);
		
		JLabel lblCodicePostale = new JLabel("Codice Postale");
		lblCodicePostale.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCodicePostale = new GridBagConstraints();
		gbc_lblCodicePostale.anchor = GridBagConstraints.WEST;
		gbc_lblCodicePostale.insets = new Insets(0, 0, 5, 0);
		gbc_lblCodicePostale.gridx = 2;
		gbc_lblCodicePostale.gridy = 2;
		formPanelInterno.add(lblCodicePostale, gbc_lblCodicePostale);
		
		textArea = new RoundedTextArea(30,30);
		textArea.setText(inserzione.getDescrizione());
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true); 
		textArea.setPreferredSize(new Dimension(21, 28)); 
		textArea.setMaximumSize(new Dimension(21, 28)); 
		textArea.setMaximumSize(new Dimension(21, 28));
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 3;
		formPanelInterno.add(textArea, gbc_textArea);
		
		codicePostaleField = new RoundedTextField(15, 30, 30);
		codicePostaleField.setText(inserzione.getImmobile().getCodicePostale());
		codicePostaleField.setFont(new Font("Arial", Font.PLAIN, 14));
		codicePostaleField.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_codicePostaleField = new GridBagConstraints();
		gbc_codicePostaleField.insets = new Insets(0, 0, 5, 0);
		gbc_codicePostaleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_codicePostaleField.gridx = 2;
		gbc_codicePostaleField.gridy = 3;
		formPanelInterno.add(codicePostaleField, gbc_codicePostaleField);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.gridx = 0;
		gbc_lblPrezzo.gridy = 4;
		formPanelInterno.add(lblPrezzo, gbc_lblPrezzo);
		
		JLabel lblDimensione = new JLabel("Dimensione (mq)");
		lblDimensione.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDimensione = new GridBagConstraints();
		gbc_lblDimensione.anchor = GridBagConstraints.WEST;
		gbc_lblDimensione.insets = new Insets(0, 0, 5, 0);
		gbc_lblDimensione.gridx = 2;
		gbc_lblDimensione.gridy = 4;
		formPanelInterno.add(lblDimensione, gbc_lblDimensione);
		prezzoField = new RoundedFormattedTextField(numberFormatter);
		
		prezzoField.setValue(inserzione.getPrezzo());
		prezzoField.setFont(new Font("Arial", Font.PLAIN, 14));
		prezzoField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_prezzoField = new GridBagConstraints();
		gbc_prezzoField.insets = new Insets(0, 0, 5, 5);
		gbc_prezzoField.fill = GridBagConstraints.BOTH;
		gbc_prezzoField.gridx = 0;
		gbc_prezzoField.gridy = 5;
		formPanelInterno.add(prezzoField, gbc_prezzoField);
		
		dimensioneField = new RoundedFormattedTextField(numberFormatter);
		dimensioneField.setValue(inserzione.getImmobile().getDimensione());
		dimensioneField.setFont(new Font("Arial", Font.PLAIN, 14));
		dimensioneField.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_dimensioneField = new GridBagConstraints();
		gbc_dimensioneField.insets = new Insets(0, 0, 5, 0);
		gbc_dimensioneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dimensioneField.gridx = 2;
		gbc_dimensioneField.gridy = 5;
		formPanelInterno.add(dimensioneField, gbc_dimensioneField);
		
		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTipologia = new GridBagConstraints();
		gbc_lblTipologia.anchor = GridBagConstraints.WEST;
		gbc_lblTipologia.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipologia.gridx = 0;
		gbc_lblTipologia.gridy = 6;
		formPanelInterno.add(lblTipologia, gbc_lblTipologia);
		
		JLabel lblPiano = new JLabel("Piano");
		lblPiano.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPiano = new GridBagConstraints();
		gbc_lblPiano.anchor = GridBagConstraints.WEST;
		gbc_lblPiano.insets = new Insets(0, 0, 5, 0);
		gbc_lblPiano.gridx = 2;
		gbc_lblPiano.gridy = 6;
		formPanelInterno.add(lblPiano, gbc_lblPiano);
		
		comboBoxTipologia = new JComboBox<String>();
		comboBoxTipologia.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBoxTipologia.setModel(new DefaultComboBoxModel<String>(new String[] {"affitto", "vendita"}));
		comboBoxTipologia.setBackground(new Color(192, 192, 192));
		comboBoxTipologia.setSelectedItem(inserzione.getTipologia());
		GridBagConstraints gbc_comboBoxTipologia = new GridBagConstraints();
		gbc_comboBoxTipologia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipologia.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTipologia.gridx = 0;
		gbc_comboBoxTipologia.gridy = 7;
		formPanelInterno.add(comboBoxTipologia, gbc_comboBoxTipologia);
		
		pianoField = new RoundedFormattedTextField(numberFormatter);
		pianoField.setValue(inserzione.getImmobile().getPiano());
		pianoField.setFont(new Font("Arial", Font.PLAIN, 14));
		pianoField.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_pianoField = new GridBagConstraints();
		gbc_pianoField.insets = new Insets(0, 0, 5, 0);
		gbc_pianoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_pianoField.gridx = 2;
		gbc_pianoField.gridy = 7;
		formPanelInterno.add(pianoField, gbc_pianoField);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblIndirizzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndirizzo.gridx = 0;
		gbc_lblIndirizzo.gridy = 8;
		formPanelInterno.add(lblIndirizzo, gbc_lblIndirizzo);
		
		JLabel lblNumeroStanze = new JLabel("Numero stanze");
		lblNumeroStanze.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNumeroStanze = new GridBagConstraints();
		gbc_lblNumeroStanze.anchor = GridBagConstraints.WEST;
		gbc_lblNumeroStanze.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumeroStanze.gridx = 2;
		gbc_lblNumeroStanze.gridy = 8;
		formPanelInterno.add(lblNumeroStanze, gbc_lblNumeroStanze);
		
		indirizzoField = new RoundedTextField(15, 30, 30);
		indirizzoField.setText(inserzione.getImmobile().getIndirizzo());
		indirizzoField.setFont(new Font("Arial", Font.PLAIN, 14));
		indirizzoField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_indirizzoField = new GridBagConstraints();
		gbc_indirizzoField.insets = new Insets(0, 0, 5, 5);
		gbc_indirizzoField.fill = GridBagConstraints.BOTH;
		gbc_indirizzoField.gridx = 0;
		gbc_indirizzoField.gridy = 9;
		formPanelInterno.add(indirizzoField, gbc_indirizzoField);
		
		numeroStanzeField = new RoundedFormattedTextField(numberFormatter);
		numeroStanzeField.setFont(new Font("Arial", Font.PLAIN, 14));
		numeroStanzeField.setBackground(Color.LIGHT_GRAY);
		numeroStanzeField.setValue(inserzione.getImmobile().getNumeroStanze());
		GridBagConstraints gbc_numeroStanzeField = new GridBagConstraints();
		gbc_numeroStanzeField.insets = new Insets(0, 0, 5, 0);
		gbc_numeroStanzeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroStanzeField.gridx = 2;
		gbc_numeroStanzeField.gridy = 9;
		formPanelInterno.add(numeroStanzeField, gbc_numeroStanzeField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 10;
		formPanelInterno.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 210, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		RoundedButton btnFoto = new RoundedButton("Modifica Foto", 30, 30);
		lblFoto = new JLabel(inserzione.getFoto());
		btnFoto.setFont(new Font("Arial", Font.PLAIN, 18));
		btnFoto.setBackground(Color.LIGHT_GRAY);
		btnFoto.addActionListener(e -> {
            selectedFile.set(selectFile(this));
            if (selectedFile.get() != null) {
            	lblFoto.setText(selectedFile.get().getName());
            }
        });

		GridBagConstraints gbc_btnFoto = new GridBagConstraints();
		gbc_btnFoto.insets = new Insets(0, 0, 0, 5);
		gbc_btnFoto.gridx = 0;
		gbc_btnFoto.gridy = 0;
		panel_1.add(btnFoto, gbc_btnFoto);
		
		
		lblFoto.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.anchor = GridBagConstraints.WEST;
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 0;
		panel_1.add(lblFoto, gbc_lblFoto);
		
		JLabel lblClasseEnergetica = new JLabel("Classe Energetica");
		lblClasseEnergetica.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblClasseEnergetica = new GridBagConstraints();
		gbc_lblClasseEnergetica.anchor = GridBagConstraints.WEST;
		gbc_lblClasseEnergetica.insets = new Insets(0, 0, 5, 0);
		gbc_lblClasseEnergetica.gridx = 2;
		gbc_lblClasseEnergetica.gridy = 10;
		formPanelInterno.add(lblClasseEnergetica, gbc_lblClasseEnergetica);
		
		checkboxAscensore = new ModernCheckBox((String) null);
		checkboxAscensore.setForeground(new Color(0, 0, 0));
		checkboxAscensore.setFont(new Font("Arial", Font.PLAIN, 18));
		checkboxAscensore.setText("Ascensore");
		
		GridBagConstraints gbc_mdrnchckbxAscensore = new GridBagConstraints();
		gbc_mdrnchckbxAscensore.anchor = GridBagConstraints.WEST;
		gbc_mdrnchckbxAscensore.insets = new Insets(0, 0, 5, 5);
		gbc_mdrnchckbxAscensore.gridx = 0;
		gbc_mdrnchckbxAscensore.gridy = 11;
		formPanelInterno.add(checkboxAscensore, gbc_mdrnchckbxAscensore);
			
				comboBoxClasseEnergetica = new JComboBox<String>();
				comboBoxClasseEnergetica.setModel(new DefaultComboBoxModel<String>(new String[] {"A4", "A3", "A2", "A1", "B", "C", "D", "E", "F", "G"}));
				comboBoxClasseEnergetica.setBackground(new Color(192, 192, 192));
				comboBoxClasseEnergetica.setFont(new Font("Arial", Font.PLAIN, 16));
				comboBoxClasseEnergetica.setSelectedItem(inserzione.getImmobile().getClasseEnergetica());
				GridBagConstraints gbc_comboBoxClasseEnergetica = new GridBagConstraints();
				gbc_comboBoxClasseEnergetica.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxClasseEnergetica.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxClasseEnergetica.gridx = 2;
				gbc_comboBoxClasseEnergetica.gridy = 11;
				formPanelInterno.add(comboBoxClasseEnergetica, gbc_comboBoxClasseEnergetica);
			
			RoundedButton btnModifica = new RoundedButton("Registrati", 30, 30);
			GridBagConstraints gbc_btnModifica = new GridBagConstraints();
			gbc_btnModifica.anchor = GridBagConstraints.EAST;
			gbc_btnModifica.insets = new Insets(0, 0, 5, 5);
			gbc_btnModifica.gridx = 0;
			gbc_btnModifica.gridy = 12;
			formPanelInterno.add(btnModifica, gbc_btnModifica);
			btnModifica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(controllaCampi()) {
						CustomDialog loadingDialog = new CustomDialog("Aggiornamento in corso","");
						loadingDialog.setLocationRelativeTo(panePrincipale);
						
							SwingWorker<Void, Void> worker = new SwingWorker<>() {
					            @Override
					            protected Void doInBackground() throws Exception {
					                aggiornaInserzione(inserzione, selectedFile);
					                return null;
					            }

					            @Override
					            protected void done() {
					            	try {
					            		get();
					            		loadingDialog.dispose();
					            		aggiornamentoInserzioneRiuscitoDialog();
					            		starter.switchModificaInserzioneToHomePage(homePage);
					                }catch(Exception ex){
					                	loadingDialog.dispose();
					                	aggiornamentoInserzioneFallitoDialog();
					                }
					            }
					        };
					     worker.execute();
					     loadingDialog.setVisible(true);
						
					}else {
						compilaCampiDialog();
					}
				}				
			});
			btnModifica.setText("Modifica");
			btnModifica.setPreferredSize(new Dimension(150, 30));
			btnModifica.setFont(new Font("Arial", Font.PLAIN, 18));
			btnModifica.setBackground(new Color(255, 175, 68));
			
			RoundedButton btnAnnulla = new RoundedButton("Annulla", 30, 30);
			GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
			gbc_btnAnnulla.anchor = GridBagConstraints.WEST;
			gbc_btnAnnulla.insets = new Insets(0, 0, 5, 0);
			gbc_btnAnnulla.gridx = 2;
			gbc_btnAnnulla.gridy = 12;
			formPanelInterno.add(btnAnnulla, gbc_btnAnnulla);
			btnAnnulla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					starter.switchModificaInserzioneToVisualizzaInserzioni();
				}
			});
			btnAnnulla.setPreferredSize(new Dimension(150, 30));
			btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 18));
			btnAnnulla.setBackground(new Color(181, 180, 180));
		
		if(inserzione.getImmobile().isAscensore()) {
			checkboxAscensore.setSelected(true);
		}
		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_fooBar = new GridBagConstraints();
		gbc_fooBar.fill = GridBagConstraints.BOTH;
		gbc_fooBar.gridx = 0;
		gbc_fooBar.gridy = 2;
		panePrincipale.add(fooBar, gbc_fooBar);
	}
	protected void aggiornamentoInserzioneRiuscitoDialog() {
		CustomDialog dialog=new CustomDialog("Aggiornamento inserzione eseguito con successo!","Ok");
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
		
	}
	protected boolean controllaCampi() {
		return !titoloField.getText().isBlank() && !textArea.getText().isBlank() 
				&& !indirizzoField.getText().isBlank() && !codicePostaleField.getText().isBlank(); 
	}
	private File selectFile(JFrame frame) {
        FileDialog fileDialog = new FileDialog(frame, "Seleziona un'immagine", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            return new File(fileDialog.getDirectory() + fileDialog.getFile());
        }
        return null;
    }
	public void aggiornaInserzione(Inserzione inserzione, AtomicReference<File> selectedFile) throws Exception {
		inserzione.setTitolo(titoloField.getText());
		inserzione.setDescrizione(textArea.getText());
		inserzione.setPrezzo(((Number)prezzoField.getValue()).intValue());
		if(!inserzione.getFoto().equals(lblFoto.getText())) {
			S3Utils s3Utils= new S3Utils();
			s3Utils.uploadToS3(selectedFile.get());
			inserzione.setFoto(selectedFile.get().getName());
		}
		inserzione.setTipologia((String) comboBoxTipologia.getSelectedItem());
		inserzione.getImmobile().setIndirizzo(indirizzoField.getText());
		inserzione.getImmobile().setCitta((String) comboBoxCitta.getSelectedItem());
		inserzione.getImmobile().setCodicePostale(codicePostaleField.getText());
		inserzione.getImmobile().setDimensione(((Number)dimensioneField.getValue()).intValue());
		inserzione.getImmobile().setPiano(((Number)pianoField.getValue()).intValue());
		inserzione.getImmobile().setAscensore(checkboxAscensore.isSelected());
		inserzione.getImmobile().setNumeroStanze(((Number)numeroStanzeField.getValue()).intValue());
		inserzione.getImmobile().setClasseEnergetica((String) comboBoxClasseEnergetica.getSelectedItem());
		modificaInserzioneController.aggiornaInserzione(inserzione);
	}
	public void compilaCampiDialog() {
		CustomDialog dialog=new CustomDialog("Compila tutti i campi","Ok");
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}
	public void aggiornamentoInserzioneFallitoDialog() {
		CustomDialog dialog=new CustomDialog("Aggiornamento inserzione non riuscito","Torna alla home");
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public JFrame getHomePage() {
		return homePage;
	}
	public void setHomePage(JFrame homePage) {
		this.homePage = homePage;
	}
}
