package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customElements.RoundedButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	
	public CustomDialog(String text,String textButton) {
		setBounds(100, 100, 600, 360);
		{
			JPanel panePrincipale = new JPanel();
			panePrincipale.setSize(450, 300);
			setResizable(false);
			setModal(true);
			getContentPane().add(panePrincipale, BorderLayout.NORTH);
			GridBagLayout gbl_panePrincipale = new GridBagLayout();
			gbl_panePrincipale.columnWidths = new int[]{574, 0};
			gbl_panePrincipale.rowHeights = new int[]{65, 172, 40, 0};
			gbl_panePrincipale.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panePrincipale.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			panePrincipale.setLayout(gbl_panePrincipale);
			{
				JPanel navBar = new JPanel();
				navBar.setBackground(new Color(6, 128, 180));
				GridBagConstraints gbc_navBar = new GridBagConstraints();
				gbc_navBar.fill = GridBagConstraints.BOTH;
				gbc_navBar.insets = new Insets(0, 0, 5, 0);
				gbc_navBar.gridx = 0;
				gbc_navBar.gridy = 0;
				panePrincipale.add(navBar, gbc_navBar);
				GridBagLayout gbl_navBar = new GridBagLayout();
				gbl_navBar.columnWidths = new int[]{84, 293, 0};
				gbl_navBar.rowHeights = new int[]{104, 0};
				gbl_navBar.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_navBar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
				navBar.setLayout(gbl_navBar);
				{
					JLabel logoImage = new JLabel("");
					logoImage.setIcon(new ImageIcon(CustomDialog.class.getResource("/DietiEstates25/client/gui/images/logoFigma80.png")));
					GridBagConstraints gbc_logoImage = new GridBagConstraints();
					gbc_logoImage.fill = GridBagConstraints.VERTICAL;
					gbc_logoImage.insets = new Insets(0, 0, 0, 5);
					gbc_logoImage.gridx = 0;
					gbc_logoImage.gridy = 0;
					navBar.add(logoImage, gbc_logoImage);
				}
				{
					JLabel lblTitle = new JLabel("DietiEstates25");
					lblTitle.setForeground(Color.WHITE);
					lblTitle.setFont(new Font("Arial", Font.PLAIN, 22));
					GridBagConstraints gbc_lblTitle = new GridBagConstraints();
					gbc_lblTitle.anchor = GridBagConstraints.WEST;
					gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
					gbc_lblTitle.gridx = 1;
					gbc_lblTitle.gridy = 0;
					navBar.add(lblTitle, gbc_lblTitle);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(217, 217, 217));
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 1;
				panePrincipale.add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{100, 233, 100, 0};
				gbl_panel.rowHeights = new int[]{79, 61, 0, 0};
				gbl_panel.columnWeights = new double[]{5.0, 0.0, 5.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel testo = new JLabel(text);
					testo.setFont(new Font("Arial", Font.PLAIN, 18));
					GridBagConstraints gbc_testo = new GridBagConstraints();
					gbc_testo.anchor = GridBagConstraints.SOUTH;
					gbc_testo.insets = new Insets(0, 0, 5, 5);
					gbc_testo.gridx = 1;
					gbc_testo.gridy = 0;
					panel.add(testo, gbc_testo);
				}
				{
					RoundedButton btnCentrale = new RoundedButton(textButton,30,30);
					btnCentrale.setFont(new Font("Arial", Font.PLAIN, 18));
					btnCentrale.setBackground(new Color(255, 175, 68));
					btnCentrale.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					GridBagConstraints gbc_btnCentrale = new GridBagConstraints();
					gbc_btnCentrale.insets = new Insets(0, 0, 5, 5);
					gbc_btnCentrale.gridx = 1;
					gbc_btnCentrale.gridy = 1;
					panel.add(btnCentrale, gbc_btnCentrale);
				}
			}
			{
				JPanel fooBar = new JPanel();
				fooBar.setBackground(new Color(16, 49, 71));
				GridBagConstraints gbc_fooBar = new GridBagConstraints();
				gbc_fooBar.fill = GridBagConstraints.BOTH;
				gbc_fooBar.gridx = 0;
				gbc_fooBar.gridy = 2;
				panePrincipale.add(fooBar, gbc_fooBar);
			}
		}
	}

}
