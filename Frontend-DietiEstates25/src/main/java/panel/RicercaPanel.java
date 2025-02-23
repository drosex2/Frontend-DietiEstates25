package panel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import controller.RicercaController;
import dto.Inserzione;
import dto.Ricerca;
import gui.CustomDialog;
import starter.Starter;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import customElements.RoundedButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class RicercaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Starter starter;
	private Ricerca ricerca;
	private RicercaController ricercaController;
	private String token;
	
	public RicercaPanel(Starter pStarter,Ricerca pRicerca,String pToken,JFrame frame) {
		setMaximumSize(new Dimension(900, 200));
		this.starter=pStarter;
		this.ricerca=pRicerca;
		this.token=pToken;
		this.ricercaController=new RicercaController(token);
		
		setBackground(new Color(220, 220, 220));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{46, 636, 195, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{647, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCitta = new JLabel("Citta: "+ricerca.getCitta());
		lblCitta.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblCitta = new GridBagConstraints();
		gbc_lblCitta.insets = new Insets(0, 0, 5, 0);
		gbc_lblCitta.anchor = GridBagConstraints.WEST;
		gbc_lblCitta.gridx = 0;
		gbc_lblCitta.gridy = 1;
		panel.add(lblCitta, gbc_lblCitta);
		
		JLabel lblTipologia = new JLabel("Tipologia: "+ricerca.getTipologia());
		lblTipologia.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblTipologia = new GridBagConstraints();
		gbc_lblTipologia.insets = new Insets(0, 0, 5, 0);
		gbc_lblTipologia.anchor = GridBagConstraints.WEST;
		gbc_lblTipologia.gridx = 0;
		gbc_lblTipologia.gridy = 2;
		panel.add(lblTipologia, gbc_lblTipologia);
		
		JLabel lblRangePrezzo = new JLabel("Range prezzo: €"+ricerca.getPrezzoMinimo()+"-"+ricerca.getPrezzoMassimo());
		lblRangePrezzo.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblRangePrezzo = new GridBagConstraints();
		gbc_lblRangePrezzo.insets = new Insets(0, 0, 5, 0);
		gbc_lblRangePrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblRangePrezzo.gridx = 0;
		gbc_lblRangePrezzo.gridy = 3;
		panel.add(lblRangePrezzo, gbc_lblRangePrezzo);
		
		JLabel lblNumeroStanze = new JLabel("Numero stanze: "+ricerca.getNumeroStanze());
		lblNumeroStanze.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNumeroStanze = new GridBagConstraints();
		gbc_lblNumeroStanze.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumeroStanze.anchor = GridBagConstraints.WEST;
		gbc_lblNumeroStanze.gridx = 0;
		gbc_lblNumeroStanze.gridy = 4;
		panel.add(lblNumeroStanze, gbc_lblNumeroStanze);
		
		JLabel lblClasseEnergetica = new JLabel("Classe energetica: "+ricerca.getClasseEnergetica());
		lblClasseEnergetica.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblClasseEnergetica = new GridBagConstraints();
		gbc_lblClasseEnergetica.anchor = GridBagConstraints.WEST;
		gbc_lblClasseEnergetica.gridx = 0;
		gbc_lblClasseEnergetica.gridy = 5;
		panel.add(lblClasseEnergetica, gbc_lblClasseEnergetica);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panelButton = new GridBagConstraints();
		gbc_panelButton.anchor = GridBagConstraints.EAST;
		gbc_panelButton.gridx = 2;
		gbc_panelButton.gridy = 0;
		add(panelButton, gbc_panelButton);
		GridBagLayout gbl_panelButton = new GridBagLayout();
		gbl_panelButton.columnWidths = new int[]{207, 8, 0};
		gbl_panelButton.rowHeights = new int[]{34, 0};
		gbl_panelButton.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelButton.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelButton.setLayout(gbl_panelButton);
		
		RoundedButton roundedButton = new RoundedButton("Riesegui ricerca", 30, 30);
		GridBagConstraints gbc_roundedButton = new GridBagConstraints();
		gbc_roundedButton.insets = new Insets(0, 0, 0, 5);
		gbc_roundedButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_roundedButton.gridx = 0;
		gbc_roundedButton.gridy = 0;
		panelButton.add(roundedButton, gbc_roundedButton);
		roundedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog loadingDialog = new CustomDialog("Caricamento in corso", "");
				loadingDialog.setLocationRelativeTo(frame);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() throws Exception {
						List<Inserzione> inserzioni = ricercaController.eseguiRicerca(ricerca);
						if (inserzioni.isEmpty()) {
							throw new Exception("Nessuna risultato disponibile");
						}
						starter.switchVisualizzaRicercheToRisultatiRicerca(ricerca.getUtente(), token, inserzioni,frame);
						return null;
					}

					@Override
					protected void done() {
						try {
							get();
							loadingDialog.dispose();
						} catch (Exception ex) {
							loadingDialog.dispose();
							CustomDialog dialog = new CustomDialog("La ricerca non ha fornito risultati", "Ok");
							dialog.setLocationRelativeTo(frame);
							dialog.setVisible(true);
						}
					}
				};
				worker.execute();
				loadingDialog.setVisible(true);
			
			}
		});
		roundedButton.setBackground(new Color(255, 175, 68));
		roundedButton.setFont(new Font("Arial", Font.PLAIN, 22));

	}

}
