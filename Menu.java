import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Menu extends JPanel {

    /*
    1 = 4-3-3 (2)
    2 = 3-4-1-2
    3 = 4-1-2-1-2
     */
    private static int formation = 0;
    private static boolean formationSelected = false;

    // Pictures of formations and background
    private BufferedImage form1 = Application.imageFromFile("\\images\\433-2.jpg");
    private BufferedImage form2 = Application.imageFromFile("\\images\\433-2.jpg");
    private BufferedImage form3 = Application.imageFromFile("\\images\\3412.jpg");
    private BufferedImage background = Application.imageFromFile("\\images\\MainMenu.jpg");

    // Main menu panel

    public Menu() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if(x >= 160 && x <= 400 && y >= 300 && y <= 527)
                formation = 1;
            else if(x >= 600 && x <= 840 && y >= 300 && y <= 527)
                formation = 2;
            else if(x >= 1040 && x <= 1280 && y >= 300 && y <= 527)
                formation = 3;
            repaint();
            }
        });
    }

    // Paint method for drawing all necessary images and shapes

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 5, 5, null);
        if(formation == 1)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.black);
        g.fillRect(140, 210, 280, 267);
        if(formation == 2)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.black);
        g.fillRect(580, 210, 280, 267);
        if(formation == 3)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.black);
        g.fillRect(1020, 210, 280, 267);
        Color c1 = new Color(15,136,189);
        g.setColor(c1);
        g.drawImage(form1, 160, 230, null);
        g.fillRect(160, 417, 240, 40);
        g.drawImage(form2, 600, 230, null);
        g.fillRect(600, 417, 240, 40);
        g.drawImage(form3, 1040, 230, null);
        g.fillRect(1040, 417, 240, 40);
        g.setColor(Color.white);
        Font font = new Font("Arial", Font.PLAIN, 24);
        g.setFont(font);
        g.drawString("4-3-3(2)", 238, 444);
        g.drawString("3-4-1-2", 682, 444);
        g.drawString("4-1-2-1-2", 1113, 444);
    }

    // Methods used by the Application class

    public static boolean formationIsSelected() { return formationSelected; }
    public static int getFormation() { return formation; }
}