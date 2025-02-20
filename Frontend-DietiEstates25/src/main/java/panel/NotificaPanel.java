package panel;

import javax.swing.JPanel;

import dto.Notifica;
import dto.NotificaCorrelazione;
import dto.NotificaPromozionale;
import dto.NotificaVisita;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.time.format.DateTimeFormatter;

public class NotificaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Notifica notifica;
	public NotificaPanel(Notifica pNotifica) {
		this.notifica=pNotifica;
		setMaximumSize(new Dimension(1000, 100));
		setBackground(new Color(220, 220, 220));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{652, 0, 74, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDescrizione = new JLabel(notifica.getDescrizione());
		lblDescrizione.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
		gbc_lblDescrizione.anchor = GridBagConstraints.WEST;
		gbc_lblDescrizione.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescrizione.gridx = 0;
		gbc_lblDescrizione.gridy = 0;
		add(lblDescrizione, gbc_lblDescrizione);
		
		JLabel lblTipologia = new JLabel("");
		if(notifica instanceof NotificaVisita) {
			lblTipologia.setText("Visita");
		}else if(notifica instanceof NotificaPromozionale)  {
			lblTipologia.setText("Promozionale");
		}else if(notifica instanceof NotificaCorrelazione) {
			lblTipologia.setText("Correlazione");
		}
		lblTipologia.setFont(new Font("Arial", Font.PLAIN, 22));
		GridBagConstraints gbc_lblTipologia = new GridBagConstraints();
		gbc_lblTipologia.insets = new Insets(0, 0, 0, 5);
		gbc_lblTipologia.gridx = 1;
		gbc_lblTipologia.gridy = 0;
		add(lblTipologia, gbc_lblTipologia);
		
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM");
		String data=notifica.getData().format(formatter);
		formatter=DateTimeFormatter.ofPattern("HH:mm");
		String ora=notifica.getOra().format(formatter);
		JLabel lblDataOra = new JLabel("<html>"+data+"<br>"+ora+"</html>");
		lblDataOra.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDataOra = new GridBagConstraints();
		gbc_lblDataOra.gridx = 2;
		gbc_lblDataOra.gridy = 0;
		add(lblDataOra, gbc_lblDataOra);

	}

}
