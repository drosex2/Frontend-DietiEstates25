package customElements;

import javax.swing.*;
import java.awt.*;
public class RoundedTextField extends JTextField {
	private int arcWidth;
    private int arcHeight;

    public RoundedTextField(int columns, int arcWidth, int arcHeight) {
        super(columns);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // Evita il riempimento rettangolare standard
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding interno
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Sfondo arrotondato
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        super.paintComponent(g);
        g2.dispose();
    }
}
