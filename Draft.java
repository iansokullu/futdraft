import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Draft extends JPanel {

    private int formation = Application.getFormation();
    private BufferedImage background = Application.imageFromFile("\\images\\Draft.jpg");

    public Draft() {

    }
}
