/* FIFA Draft Program
 * By Ian Sokullu
 * 2018
 * ICS4U
 */

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;


public class Application extends JFrame{

    // Initialize sound clip

    private static Clip clip;

    // Store entered cheatcode

    private static String cheatCode = "None";

    // ArrayLists which contain Players and group them by position

    private static ArrayList<Player> leftWings = new ArrayList<Player>();
    private static ArrayList<Player> strikers = new ArrayList<Player>();
    private static ArrayList<Player> rightWings = new ArrayList<Player>();
    private static ArrayList<Player> centerMids = new ArrayList<Player>();
    private static ArrayList<Player> leftBacks = new ArrayList<Player>();
    private static ArrayList<Player> centerBacks = new ArrayList<Player>();
    private static ArrayList<Player> rightBacks = new ArrayList<Player>();
    private static ArrayList<Player> goalKeepers = new ArrayList<Player>();

    // HashMap for finding each ArrayList using their position

    private static HashMap<String, ArrayList<Player>> playerLists = new HashMap<>();

    // Creating Player variables to be placed into lists

    private static Player sokullu = new Player(98, "LW", "Canada", "Icons", "Icons", "\\images\\SOKULLU.png,", "\\images\\SOKULLU_SMALL.png,");
    private static Player lil_deeney = new Player(90, "GK", "Canada","Icons ", "Icons", "\\images\\LIL_DEENEY.png", "\\images\\LIL_DEENEY_SMALL.png");
    private static Player drew = new Player(92, "CM", "Canada", "Liverpool", "Premier League", "\\images\\DREW.png", "\\images\\DREW_SMALL.png");
    private static Player lil_gingy = new Player(89, "RW", "Canada", "Manchester City", "Premier League", "\\images\\LIL_GINGY.png", "\\images\\LIL_GINGY_SMALL.png");
    private static Player nibs = new Player(91, "Canada", "CB", "Manchester City", "Premier League", "\\images\\NIBS.png", "\\images\\NIBS_SMALL.png");
    private static Player remo = new Player(86, "Canada", "ST", "Southampton", "Premier League", "\\images\\REMO.png", "\\images\\REMO_SMALL.png");
    private static Player lil_jaypee = new Player(84, "LB", "Canada", "Everton", "Premier League", "\\images\\LIL_JAYPEE.png", "\\images\\LIL_JAYPEE_SMALL.png");
    private static Player dj_donnie_d = new Player(70, "GK", "Canada", "Everton", "Premier League", "\\images\\DJ_DONNIE_D.png", "\\images\\DJ_DONNIE_D_SMALL.png");
    private static Player martin = new Player(45, "CM", "Israel", "Swansea City", "Premier League", "\\images\\MARTIN.png", "\\images\\MARTIN_SMALL.png");
    private static Player ray = new Player(88, "RB", "Canada", "Manchester United", "Premier League", "\\images\\RAY.png", "\\images\\RAY_SMALL.png");

    private static Player jason_jugoon = new Player(420, "ST", "Trinidad and Tobago", "Real Madrid", "LaLiga", "\\images\\JASON_JUGOON.png", "\\images\\JASON_JUGOON.png");
    private static Player oreils = new Player(99, "ST", "Canada", "Icons", "Icons", "\\images\\OREILS.png", "\\images\\OREILS_SMALL.png");

    private static Player ronaldo = new Player(94, "LW", "Portugal","Real Madrid", "LaLiga", "\\images\\RONALDO.png", "\\images\\RONALDO_SMALL.png");

    // Initialise the frame to allow it to be accessed by other classes through methods

    private static Application frame;

    // The frame which contains all other panels

    protected Application() {

        // Setting window size, title, close button behaviour, and centering it

        setSize(1440, 810);
        setTitle("Start");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Playing main menu theme

        playSound("MenuTheme.wav");

        // Creating panels
        Start start = new Start();
        Menu menu = new Menu();

        // Adding starting panel and ensuring it fits
        add(start);
        pack();

        // Adding mouseListener for changing to the next panel

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if(cheatCode.equals("None") && x >= 1100 && x <= 1140 && y >= 680 && y <= 705) {
                    cheatCode = JOptionPane.showInputDialog("Enter code: ", null);
                    if(cheatCode == null || cheatCode.isEmpty())
                        cheatCode = "None";
                    System.out.println("Cheat code entered: " + cheatCode);
                }
                else {
                    remove(start);
                    add(menu);
                    revalidate();
                    repaint();
                    setTitle("Main Menu");
                }
            }
        });
    }

    // Main method

    public static void main(String[] args) {
        fillArrLists();
        frame = new Application();
        frame.setVisible(true);
    }

    public static void startGame() {
        Application.stopClip();
        Draft.initUI();
        frame.setVisible(false);
        frame.dispose();
    }

    // Method used to fill the arrLists and map them with the HashMap

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

        playerLists.put("LW", leftWings);
        playerLists.put("ST", strikers);
        playerLists.put("RW", rightWings);
        playerLists.put("CM", centerMids);
        playerLists.put("LB", leftBacks);
        playerLists.put("CB", centerBacks);
        playerLists.put("RB", rightBacks);
        playerLists.put("GK", goalKeepers);
    }

    // Method for retrieving a player from an arraylist

    public static Player getPlayer(String pos, int id) { return playerLists.get(pos).remove(id); }

    // Method for checking the number of remaining players in an arraylist

    public static int listLength(String pos, int id) { return playerLists.get(pos).size(); }

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

    // Method for returning entered cheatcode (if any)

    public static String getCheatCode() { return cheatCode; }

    // Method for playing sound

    public synchronized void playSound(final String url) {
        new Thread(() -> {
            try {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(Application.class.getResourceAsStream("\\sounds\\" + url));
                clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }
    public static void stopClip() { clip.stop(); }
}