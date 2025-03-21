package customElements;

import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class RoundedTextField extends JTextField {
	private int arcWidth;
    private int arcHeight;

    public RoundedTextField(int columns, int arcWidth, int arcHeight) {
        super(15);
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
