package customElements;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

@SuppressWarnings("serial")
public class RoundedFormattedTextField extends JFormattedTextField {
	private int arcWidth;
    private int arcHeight;

    public RoundedFormattedTextField(NumberFormatter formatter) {
        super(formatter);
        this.arcWidth = 30;
        this.arcHeight = 30;
        setOpaque(false); 
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        super.paintComponent(g);
        g2.dispose();
    }
}
