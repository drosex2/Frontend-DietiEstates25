package customElements;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class ModernCheckBox extends JCheckBox {
    public ModernCheckBox(String text) {
        super(text);

        
        setFocusPainted(false);
        setOpaque(false);

        
        setForeground(new Color(60, 60, 60)); // Testo grigio scuro
        setFont(new Font("SansSerif", Font.BOLD, 14));

        // Imposta le icone personalizzate
        setIcon(new ImageIcon(createCheckBoxIcon(new Color(192,192,192), false))); // Non selezionata
        setSelectedIcon(new ImageIcon(createCheckBoxIcon(new Color(30, 144, 255), true))); // Selezionata
    }

    // Metodo per creare un'icona personalizzata della checkbox
    private Image createCheckBoxIcon(Color color, boolean selected) {
        int size = 18;
        Image img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) img.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Disegna il quadrato della checkbox arrotondato
        g2.setColor(color);
        g2.fillRoundRect(0, 0, size, size, 6, 6);

        // Disegna il segno di spunta se selezionato
        if (selected) {
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(4, 9, 7, 13);
            g2.drawLine(7, 13, 14, 5);
        }

        g2.dispose();
        return img;
    }
}
