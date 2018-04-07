import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Window extends JPanel implements MouseListener {
    // Loading start screen
    private BufferedImage background;

    public Window(int s) {
        if(s == 1)
            background = Application.imageFromFile("\\images\\Start.jpg");
        else if(s == 2)
            background = Application.imageFromFile("\\images\\MainMenu.jpg");

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
