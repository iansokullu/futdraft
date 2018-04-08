import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Draft extends JPanel {

    private int formation = Menu.getFormation();
    private BufferedImage background = Application.imageFromFile("\\images\\Draft.jpg");

    public Draft() {
        Application.stopClip();
        setBounds(0, 0, 1440, 1080);
        revalidate();
        repaint();
        System.out.println(formation);
    }

}
