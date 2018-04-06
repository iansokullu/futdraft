/* FIFA Draft Program
 * By Ian Sokullu
 * Richmond Hill, Ontario, Canada
 * 2017-2018
 * ICS4U
 *
 * Window Size: 1440 x 810
 *
 * ------------------INDEX------------------
 * Line = Import Statements
 * Line = Class Header
 * Line = Variables
 * Line = Card Images
 * Line = Custom Players
 * Line = Real Players
 * Line = Paint Method
 * Line = MouseListener
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.*;
import java.util.*;

public class Application extends JFrame{

    // Variables

    private static final int SCREEN_WIDTH = 1440;
    private static final int SCREEN_HEIGHT = 810;
    private static final int CARDCHOOSE_WIDTH = 1440;
    private static final int CARDCHOOSE_HEIGHT = 300;
    private static final int CARD_WIDTH = 260;
    private static final int CARD_HEIGHT = 395;
    private static final int SPACING = 14;

    // Custom Players

    Player sokullu = new Player(98, 1,"Canada", "Icons", "Icons", "\\images\\SOKULLU.png");
    Player lil_deeney = new Goalkeeper(90, 1, "Canada","Icons ", "Icons", "\\images\\LIL_DEENEY.png");
    Player lil_drew = new Player(92, 1, "Canada", "Liverpool", "Premier League", "\\images\\DREW.png");
    Player lil_gingy = new Player(89, 1, "Canada", "Manchester City", "Premier League", "\\images\\LIL_GINGY.png");
    Player nibs = new Player(91, 1, "Canada", "Manchester City", "Premier League", "\\images\\NIBS.png");
    Player remo = new Player(86, 1, "Canada", "Southampton", "Premier League", "\\images\\REMO.png");
    Player dj_donnie_d = new Player(70, 2, "Canada", "Everton", "Premier League", "\\images\\DJ_DONNIE_D.png");
    Player martin = new Player(45, 1, "Israel", "Swansea City", "Premier League", "\\images\\MARTIN.png");
    Player ray = new Player(88, 1, "Canada", "Manchester United", "Premier League", "\\images\\RAY.png");

    // Real Players

    Player ronaldo = new Player(94, 2, "Portugal","Real Madrid", "LaLiga", "\\images\\RONALDO.png");

    public Application() {
        // Creating new window
        add(new Window());
        // Setting window size, title, close button behaviour, and centering it
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setTitle("FutDraft");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Prevents window from becoming unresponsive due to background calculations
        EventQueue.invokeLater(() -> {
            Application fut = new Application();
            fut.setVisible(true);
        });
    }

    // Method for retrieving image when given image path

    public static BufferedImage imageFromFile(String path) {
        try {
            URL resource = FutDraft.class.getClassLoader().getResource(path);
            if (resource == null)
                throw new NullPointerException();
            return ImageIO.read(resource);
        } catch (IOException | NullPointerException e) {
            System.err.println("There was an error retrieving " + path);
            e.printStackTrace();
        }
        return null;
    }
}