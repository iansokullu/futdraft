import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Draft extends JPanel {

    private int formation = Start.getFormation();
    private BufferedImage background = Application.imageFromFile("\\images\\Draft.jpg");

    public Draft() {
        removeAll();
        validate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 110, null);
    }

}
