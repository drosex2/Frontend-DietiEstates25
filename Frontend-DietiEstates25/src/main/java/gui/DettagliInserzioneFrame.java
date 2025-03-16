package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import controller.DettagliInserzioneController;
import customElements.RoundedButton;
import dto.Inserzione;
import dto.Utente;
import starter.Starter;
import utils.S3Utils;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import customElements.RoundedFormattedTextField;

public class DettagliInserzioneFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panePrincipale;
	private Inserzione inserzione;
	private Utente utenteConnesso;
	private String token;
	private DettagliInserzioneController dettagliInserzioneController;
	private Starter starter;
	private RoundedFormattedTextField offertaField;





	public DettagliInserzioneFrame(Starter starter,Inserzione inserzione, Utente utente, String token) {
		
		this.starter=starter;
		this.setInserzione(inserzione);
		this.setUtenteConnesso(utente);
		this.setToken(token);
		this.dettagliInserzioneController=new DettagliInserzioneController(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 770, 512);
		
		panePrincipale = new JPanel();
		panePrincipale.setBackground(new Color(240, 240, 240));
		setTitle("Login Utente");

		setContentPane(panePrincipale);
		GridBagLayout gbl_panePrincipale = new GridBagLayout();
		gbl_panePrincipale.columnWidths = new int[]{881, 0};
		gbl_panePrincipale.rowHeights = new int[]{97, 100, 368, 0, 40, 0};
		gbl_panePrincipale.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panePrincipale.rowWeights = new double[]{1.0, 0.0, 10.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblWelcome = new JLabel("Dettagli inserzione");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 40));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 1;
		panePrincipale.add(lblWelcome, gbc_lblWelcome);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		panePrincipale.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 100, 100, 0};
		gbl_panel.rowHeights = new int[]{363, 0, 0};
		gbl_panel.columnWeights = new double[]{5.0, 0.0, 5.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel dettagliInserzionePanel = new JPanel();
		dettagliInserzionePanel.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_dettagliInserzionePanel = new GridBagConstraints();
		gbc_dettagliInserzionePanel.insets = new Insets(0, 0, 5, 5);
		gbc_dettagliInserzionePanel.fill = GridBagConstraints.BOTH;
		gbc_dettagliInserzionePanel.gridx = 1;
		gbc_dettagliInserzionePanel.gridy = 0;
		panel.add(dettagliInserzionePanel, gbc_dettagliInserzionePanel);
		GridBagLayout gbl_dettagliInserzionePanel = new GridBagLayout();
		gbl_dettagliInserzionePanel.columnWidths = new int[]{191, 522, 20, 74, 20, 0};
		gbl_dettagliInserzionePanel.rowHeights = new int[]{20, 363, 0};
		gbl_dettagliInserzionePanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_dettagliInserzionePanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		dettagliInserzionePanel.setLayout(gbl_dettagliInserzionePanel);
		
		JPanel panelMappaPOI = new JPanel();
		panelMappaPOI.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_panelMappaPOI = new GridBagConstraints();
		gbc_panelMappaPOI.insets = new Insets(0, 0, 0, 5);
		gbc_panelMappaPOI.fill = GridBagConstraints.BOTH;
		gbc_panelMappaPOI.gridx = 0;
		gbc_panelMappaPOI.gridy = 1;
		dettagliInserzionePanel.add(panelMappaPOI, gbc_panelMappaPOI);
		GridBagLayout gbl_panelMappaPOI = new GridBagLayout();
		gbl_panelMappaPOI.columnWidths = new int[]{20, 244, 20, 0};
		gbl_panelMappaPOI.rowHeights = new int[]{20, 195, 20, 208, 0};
		gbl_panelMappaPOI.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelMappaPOI.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMappaPOI.setLayout(gbl_panelMappaPOI);
		
		
		JXMapViewer mapViewer=getJxMapViewer(inserzione.getImmobile().getLatitude(),inserzione.getImmobile().getLongitude());
		GridBagConstraints gbc_panelMappa = new GridBagConstraints();
		gbc_panelMappa.insets = new Insets(0, 0, 5, 5);
		gbc_panelMappa.fill = GridBagConstraints.BOTH;
		gbc_panelMappa.gridx = 1;
		gbc_panelMappa.gridy = 1;
		panelMappaPOI.add(mapViewer, gbc_panelMappa);
		
		
		JLabel lblPuntiDiInteresse=new JLabel("");
		String puntiDiInteresse=inserzione.getImmobile().getPuntiDiInteresse();
		if(!puntiDiInteresse.isBlank()) {
			if(!(puntiDiInteresse.charAt(0)==(' '))) puntiDiInteresse=" "+puntiDiInteresse;
			puntiDiInteresse=puntiDiInteresse.replace(";", "<br> •");
			puntiDiInteresse=puntiDiInteresse.replace("_", " ");
			puntiDiInteresse=puntiDiInteresse.substring(0,puntiDiInteresse.length()-1);
			lblPuntiDiInteresse.setText("<html> Vicino a: <br> •"+puntiDiInteresse+"</html>");
		}
		
		lblPuntiDiInteresse.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPuntiDiInteresse = new GridBagConstraints();
		gbc_lblPuntiDiInteresse.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPuntiDiInteresse.insets = new Insets(0, 0, 0, 5);
		gbc_lblPuntiDiInteresse.gridx = 1;
		gbc_lblPuntiDiInteresse.gridy = 3;
		panelMappaPOI.add(lblPuntiDiInteresse, gbc_lblPuntiDiInteresse);
		
		JPanel panelDettagli = new JPanel();
		panelDettagli.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_panelDettagli = new GridBagConstraints();
		gbc_panelDettagli.insets = new Insets(0, 0, 0, 5);
		gbc_panelDettagli.fill = GridBagConstraints.BOTH;
		gbc_panelDettagli.gridx = 1;
		gbc_panelDettagli.gridy = 1;
		dettagliInserzionePanel.add(panelDettagli, gbc_panelDettagli);
		GridBagLayout gbl_panelDettagli = new GridBagLayout();
		gbl_panelDettagli.columnWidths = new int[]{20, 463, 20, 0};
		gbl_panelDettagli.rowHeights = new int[]{20, 73, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 50, 0};
		gbl_panelDettagli.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDettagli.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelDettagli.setLayout(gbl_panelDettagli);
		
		JPanel panelDescrizione = new JPanel();
		panelDescrizione.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_panelDescrizione = new GridBagConstraints();
		gbc_panelDescrizione.insets = new Insets(0, 0, 5, 5);
		gbc_panelDescrizione.fill = GridBagConstraints.BOTH;
		gbc_panelDescrizione.gridx = 1;
		gbc_panelDescrizione.gridy = 1;
		panelDettagli.add(panelDescrizione, gbc_panelDescrizione);
		GridBagLayout gbl_panelDescrizione = new GridBagLayout();
		gbl_panelDescrizione.columnWidths = new int[]{0, 351, 0};
		gbl_panelDescrizione.rowHeights = new int[]{0, 0};
		gbl_panelDescrizione.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelDescrizione.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelDescrizione.setLayout(gbl_panelDescrizione);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
		gbc_lblDescrizione.anchor = GridBagConstraints.NORTH;
		gbc_lblDescrizione.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescrizione.gridx = 0;
		gbc_lblDescrizione.gridy = 0;
		panelDescrizione.add(lblDescrizione, gbc_lblDescrizione);
		
		JTextArea txtAreaDescrizione = new JTextArea();
		String descrizione=inserzione.getDescrizione().trim();
		txtAreaDescrizione.setText(descrizione);
		txtAreaDescrizione.setLineWrap(true);
		txtAreaDescrizione.setWrapStyleWord(true);
		txtAreaDescrizione.setEditable(false);
		txtAreaDescrizione.setFocusable(false);
		txtAreaDescrizione.setFont(new Font("Arial", Font.PLAIN, 22));
		txtAreaDescrizione.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_txtAreaDescrizione = new GridBagConstraints();
		gbc_txtAreaDescrizione.fill = GridBagConstraints.BOTH;
		gbc_txtAreaDescrizione.gridx = 1;
		gbc_txtAreaDescrizione.gridy = 0;
		panelDescrizione.add(txtAreaDescrizione, gbc_txtAreaDescrizione);
		
		JLabel lblDimensioni = new JLabel("Dimensioni: "+inserzione.getImmobile().getDimensione()+" mq");
		lblDimensioni.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDimensioni = new GridBagConstraints();
		gbc_lblDimensioni.anchor = GridBagConstraints.WEST;
		gbc_lblDimensioni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDimensioni.gridx = 1;
		gbc_lblDimensioni.gridy = 3;
		panelDettagli.add(lblDimensioni, gbc_lblDimensioni);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo: "+inserzione.getImmobile().getIndirizzo());
		lblIndirizzo.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.anchor = GridBagConstraints.WEST;
		gbc_lblIndirizzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 4;
		panelDettagli.add(lblIndirizzo, gbc_lblIndirizzo);
		
		JLabel lblComune = new JLabel("Comune: "+inserzione.getImmobile().getCitta());
		lblComune.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblComune = new GridBagConstraints();
		gbc_lblComune.anchor = GridBagConstraints.WEST;
		gbc_lblComune.insets = new Insets(0, 0, 5, 5);
		gbc_lblComune.gridx = 1;
		gbc_lblComune.gridy = 5;
		panelDettagli.add(lblComune, gbc_lblComune);
		
		JLabel lblCodicePostale = new JLabel("Codice Postale: "+inserzione.getImmobile().getCodicePostale());
		lblCodicePostale.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblCodicePostale = new GridBagConstraints();
		gbc_lblCodicePostale.anchor = GridBagConstraints.WEST;
		gbc_lblCodicePostale.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodicePostale.gridx = 1;
		gbc_lblCodicePostale.gridy = 6;
		panelDettagli.add(lblCodicePostale, gbc_lblCodicePostale);
		
		JLabel lblClasseEnergetica = new JLabel("Classe Energetica: "+inserzione.getImmobile().getClasseEnergetica());
		lblClasseEnergetica.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblClasseEnergetica = new GridBagConstraints();
		gbc_lblClasseEnergetica.anchor = GridBagConstraints.WEST;
		gbc_lblClasseEnergetica.insets = new Insets(0, 0, 5, 5);
		gbc_lblClasseEnergetica.gridx = 1;
		gbc_lblClasseEnergetica.gridy = 7;
		panelDettagli.add(lblClasseEnergetica, gbc_lblClasseEnergetica);
		
		JLabel lblNumeroStanze = new JLabel("Numero stanze: "+inserzione.getImmobile().getNumeroStanze());
		lblNumeroStanze.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNumeroStanze = new GridBagConstraints();
		gbc_lblNumeroStanze.anchor = GridBagConstraints.WEST;
		gbc_lblNumeroStanze.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroStanze.gridx = 1;
		gbc_lblNumeroStanze.gridy = 8;
		panelDettagli.add(lblNumeroStanze, gbc_lblNumeroStanze);
		
		JLabel lblPiano = new JLabel("Piano: "+inserzione.getImmobile().getPiano()+"°");
		lblPiano.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPiano = new GridBagConstraints();
		gbc_lblPiano.anchor = GridBagConstraints.WEST;
		gbc_lblPiano.insets = new Insets(0, 0, 5, 5);
		gbc_lblPiano.gridx = 1;
		gbc_lblPiano.gridy = 9;
		panelDettagli.add(lblPiano, gbc_lblPiano);
		String ascensore;
		if(inserzione.getImmobile().isAscensore()) {
			ascensore="Sì";
		}else {
			ascensore="No";
		}
		JLabel lblAscensore = new JLabel("Ascensore: "+ascensore);
		lblAscensore.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblAscensore = new GridBagConstraints();
		gbc_lblAscensore.anchor = GridBagConstraints.WEST;
		gbc_lblAscensore.insets = new Insets(0, 0, 5, 5);
		gbc_lblAscensore.gridx = 1;
		gbc_lblAscensore.gridy = 10;
		panelDettagli.add(lblAscensore, gbc_lblAscensore);
		
		JLabel lblTipologia = new JLabel("Tipologia vendita: "+inserzione.getTipologia());
		lblTipologia.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblTipologia = new GridBagConstraints();
		gbc_lblTipologia.anchor = GridBagConstraints.WEST;
		gbc_lblTipologia.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipologia.gridx = 1;
		gbc_lblTipologia.gridy = 11;
		panelDettagli.add(lblTipologia, gbc_lblTipologia);
		
		JLabel lblPrezzo = new JLabel("Prezzo: €"+inserzione.getPrezzo());
		lblPrezzo.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.gridx = 1;
		gbc_lblPrezzo.gridy = 12;
		panelDettagli.add(lblPrezzo, gbc_lblPrezzo);
		
		JPanel panelOfferta = new JPanel();
		panelOfferta.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_panelOfferta = new GridBagConstraints();
		gbc_panelOfferta.insets = new Insets(0, 0, 5, 5);
		gbc_panelOfferta.fill = GridBagConstraints.BOTH;
		gbc_panelOfferta.gridx = 1;
		gbc_panelOfferta.gridy = 13;
		panelDettagli.add(panelOfferta, gbc_panelOfferta);
		GridBagLayout gbl_panelOfferta = new GridBagLayout();
		gbl_panelOfferta.columnWidths = new int[]{0, 73, 140, 0};
		gbl_panelOfferta.rowHeights = new int[]{0, 0};
		gbl_panelOfferta.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelOfferta.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelOfferta.setLayout(gbl_panelOfferta);
		
		JLabel lblOfferta = new JLabel("La tua offerta:");
		lblOfferta.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblOfferta = new GridBagConstraints();
		gbc_lblOfferta.insets = new Insets(0, 0, 0, 5);
		gbc_lblOfferta.anchor = GridBagConstraints.EAST;
		gbc_lblOfferta.gridx = 0;
		gbc_lblOfferta.gridy = 0;
		panelOfferta.add(lblOfferta, gbc_lblOfferta);
		
		NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
		numberFormatter.setAllowsInvalid(true);
        numberFormatter.setCommitsOnValidEdit(true);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(0);
        int offertaBase = calcolaOffertaBase(inserzione);
        UIManager.put("ToolTip.font", new Font("Arial", Font.PLAIN, 22));
		offertaField = new RoundedFormattedTextField(numberFormatter);
		offertaField.setColumns(10);
		offertaField.setToolTipText("Inserire un offerta di almeno: €"+offertaBase);
		offertaField.setFont(new Font("Arial", Font.PLAIN, 22));
		offertaField.setValue(offertaBase);
		offertaField.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_offertaField = new GridBagConstraints();
		gbc_offertaField.insets = new Insets(0, 0, 0, 5);
		gbc_offertaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_offertaField.gridx = 1;
		gbc_offertaField.gridy = 0;
		panelOfferta.add(offertaField, gbc_offertaField);
		
		RoundedButton btnEffettuaOfferta = new RoundedButton("Effettua Offerta", 30, 30);
		btnEffettuaOfferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int offerta=((Number)offertaField.getValue()).intValue();
				if(offerta>=offertaBase) {
					try {
					dettagliInserzioneController.inserisciOfferta(utente, inserzione, offerta);
					showCustomDialog("Offerta inserita con successo!","Ok");
					} catch (Exception ex) {
						showCustomDialog(ex.getMessage(),"Riprova");
					}
				}else {
					showCustomDialog("L'offerta inserita è troppo bassa","Riprova");
				}
				
			}
		});
		
		btnEffettuaOfferta.setFont(new Font("Arial", Font.PLAIN, 22));
		btnEffettuaOfferta.setBackground(new Color(255, 175, 68));
		GridBagConstraints gbc_btnEffettuaOfferta = new GridBagConstraints();
		gbc_btnEffettuaOfferta.gridx = 2;
		gbc_btnEffettuaOfferta.gridy = 0;
		panelOfferta.add(btnEffettuaOfferta, gbc_btnEffettuaOfferta);
		
		
		JPanel panelFoto = new JPanel();
		panelFoto.setBackground(new Color(181, 180, 180));
		GridBagConstraints gbc_panelFoto = new GridBagConstraints();
		gbc_panelFoto.insets = new Insets(0, 0, 0, 5);
		gbc_panelFoto.fill = GridBagConstraints.BOTH;
		gbc_panelFoto.gridx = 3;
		gbc_panelFoto.gridy = 1;
		dettagliInserzionePanel.add(panelFoto, gbc_panelFoto);
		GridBagLayout gbl_panelFoto = new GridBagLayout();
		gbl_panelFoto.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelFoto.rowHeights = new int[]{0, 0, 0};
		gbl_panelFoto.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFoto.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelFoto.setLayout(gbl_panelFoto);
		
		JLabel lblFoto = new JLabel("");
		S3Utils s3Utils=new S3Utils();
		ImageIcon icon=s3Utils.getIconFromS3(inserzione.getFoto());
		ImageIcon resizedIcon = s3Utils.resizeImageIcon(icon, 150, 150);
		lblFoto.setIcon(resizedIcon);
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.insets = new Insets(0, 0, 0, 5);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 1;
		panelFoto.add(lblFoto, gbc_lblFoto);
		
		RoundedButton btnIndietro = new RoundedButton("Indietro", 30, 30);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starter.switchDettagliInserzioneToRisultatiRicercaFrame();
			}
		});
		btnIndietro.setBackground(new Color(217, 217, 217));
		
		btnIndietro.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_btnIndietro = new GridBagConstraints();
		gbc_btnIndietro.anchor = GridBagConstraints.SOUTH;
		gbc_btnIndietro.insets = new Insets(0, 0, 0, 5);
		gbc_btnIndietro.gridx = 0;
		gbc_btnIndietro.gridy = 1;
		panel.add(btnIndietro, gbc_btnIndietro);
		
		JPanel fooBar = new JPanel();
		fooBar.setBackground(new Color(16, 49, 71));
		GridBagConstraints gbc_fooBar = new GridBagConstraints();
		gbc_fooBar.fill = GridBagConstraints.BOTH;
		gbc_fooBar.gridx = 0;
		gbc_fooBar.gridy = 4;
		panePrincipale.add(fooBar, gbc_fooBar);
	}
	public int calcolaOffertaBase(Inserzione inserzione) {
		int offertaBase;
        if(inserzione.getTipologia().equals("affitto")) {
        	offertaBase=inserzione.getPrezzo()-((inserzione.getPrezzo()/100)*20);
        }else {
        	offertaBase=inserzione.getPrezzo()-((inserzione.getPrezzo()/100)*15);
        }
		return offertaBase;
	}	
	public Starter getStarter() {
		return starter;
	}


	public void setStarter(Starter starter) {
		this.starter = starter;
	}
	private static JXMapViewer getJxMapViewer(double latitudine, double longitudine) {

        JXMapViewer mapViewer = new JXMapViewer();

        OSMTileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        GeoPosition myPoint = new GeoPosition(latitudine, longitudine);
        mapViewer.setZoom(2);
        mapViewer.setAddressLocation(myPoint);

        Set<Waypoint> waypoints = new HashSet<>();
        waypoints.add(new Waypoint() {
            @Override
            public GeoPosition getPosition() {
                return myPoint;
            }
        });

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        mapViewer.setOverlayPainter(waypointPainter);       
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addMouseMotionListener(new PanMouseInputListener(mapViewer));
        return mapViewer;
    }
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Utente getUtenteConnesso() {
		return utenteConnesso;
	}
	public void setUtenteConnesso(Utente utenteConnesso) {
		this.utenteConnesso = utenteConnesso;
	}
	public Inserzione getInserzione() {
		return inserzione;
	}
	public void setInserzione(Inserzione inserzione) {
		this.inserzione = inserzione;
	}
	public void showCustomDialog(String message,String testoButton) {
		message=message.replace("java.lang.Exception: ", "");
		CustomDialog dialog = new CustomDialog(message,testoButton);
		dialog.setLocationRelativeTo(panePrincipale);
		dialog.setVisible(true);
	}
	
}
