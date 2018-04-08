import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Draft extends JFrame {

    // Initializing frame

    private static Draft game;

    // Retrieving formation

    private static int formation = Menu.getFormation();
    private BufferedImage background = Application.imageFromFile("\\images\\Draft.jpg");

    public Draft() {
        setSize(1440, 1080);
        setTitle("Draft Simulator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new Game());
    }

    public static void initUI() {
        System.out.println("Formation " + formation);
        game = new Draft();
        game.setVisible(true);
    }
}
