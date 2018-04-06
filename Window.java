import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Window extends JPanel {
    // Loading start screen
    private BufferedImage startScreen = Application.imageFromFile("\\images\\Start.jpg");

    public Window() {
        initWindow();
    }

    private void initWindow() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(startScreen, 0, 0, null);
    }
}
