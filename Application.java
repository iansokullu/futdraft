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

    public static ArrayList<Player> leftWings = new ArrayList<Player>();
    public static ArrayList<Player> strikers = new ArrayList<Player>();
    public static ArrayList<Player> rightWings = new ArrayList<Player>();
    public static ArrayList<Player> centerMids = new ArrayList<Player>();
    public static ArrayList<Player> leftBacks = new ArrayList<Player>();
    public static ArrayList<Player> centerBacks = new ArrayList<Player>();
    public static ArrayList<Player> rightBacks = new ArrayList<Player>();
    public static ArrayList<Player> goalKeepers = new ArrayList<Player>();

    private static Player sokullu = new Player(98, "Canada", "Icons", "Icons", "\\images\\SOKULLU.png");
    private static Player lil_deeney = new Player(90, "Canada","Icons ", "Icons", "\\images\\LIL_DEENEY.png");
    private static Player drew = new Player(92, "Canada", "Liverpool", "Premier League", "\\images\\DREW.png");
    private static Player lil_gingy = new Player(89, "Canada", "Manchester City", "Premier League", "\\images\\LIL_GINGY.png");
    private static Player nibs = new Player(91, "Canada", "Manchester City", "Premier League", "\\images\\NIBS.png");
    private static Player remo = new Player(86, "Canada", "Southampton", "Premier League", "\\images\\REMO.png");
    private static Player lil_jaypee = new Player(84, "Canada", "Everton", "Premier League", "\\images\\LIL_JAYPEE.png");
    private static Player dj_donnie_d = new Player(70, "Canada", "Everton", "Premier League", "\\images\\DJ_DONNIE_D.png");
    private static Player martin = new Player(45, "Israel", "Swansea City", "Premier League", "\\images\\MARTIN.png");
    private static Player ray = new Player(88, "Canada", "Manchester United", "Premier League", "\\images\\RAY.png");
    private static Player oreils = new Player(99, "Canada", "Icons", "Icons", "\\images\\OREILS.png");

    // Real Players

    static Player ronaldo = new Player(94, "Portugal","Real Madrid", "LaLiga", "\\images\\RONALDO.png");

    public Application() {
        // Creating new window
        add(new Window(1));
        // Setting window size, title, close button behaviour, and centering it
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setTitle("FutDraft");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        fillArrLists();
        // Prevents window from becoming unresponsive due to background calculations
        EventQueue.invokeLater(() -> {
            Application fut = new Application();
            fut.setVisible(true);
        });
    }

    private static void fillArrLists() {
        leftWings.add(sokullu);
        strikers.add(oreils);
        strikers.add(remo);
        rightWings.add(lil_gingy);

        centerMids.add(drew);
        centerMids.add(martin);

        leftBacks.add(lil_jaypee);
        centerBacks.add(nibs);
        rightBacks.add(ray);

        goalKeepers.add(lil_deeney);
        goalKeepers.add(dj_donnie_d);
    }

    // Method for retrieving image when given image path

    public static BufferedImage imageFromFile(String path) {
        try {
            URL resource = Application.class.getClassLoader().getResource(path);
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