import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Start extends JPanel {

    /*
    1 = 4-3-3 (2)
    2 = 3-4-1-2
    3 = 4-1-2-1-2
     */
    private static int formation = 0;

    // Loading start screen
    private BufferedImage background;
    private int scr = 1;
    private BufferedImage form1 = Application.imageFromFile("\\images\\433-2.jpg");
    private BufferedImage form2 = Application.imageFromFile("\\images\\3412.jpg");
    private BufferedImage form3 = Application.imageFromFile("\\images\\41212.jpg");

    // Set start screen background, then change to formation selection

    public Start() {
        background = Application.imageFromFile("\\images\\Start.jpg");
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(scr == 1) {
                    background = Application.imageFromFile("\\images\\MainMenu.jpg");
                    scr = 2;
                    repaint();
                }
                else if(scr == 2) {
                    int x = e.getX();
                    int y = e.getY();
                    if(x >= 160 && x <= 400 && y >= 300 && y <= 527)
                        formation = 1;
                    else if(x >= 600 && x <= 840 && y >= 300 && y <= 527)
                        formation = 2;
                    else if(x >= 1040 && x <= 1280 && y >= 300 && y <= 527)
                        formation = 3;
                    if(formation != 0)
                        add(new Draft());
                }
            }
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        if(scr == 1)
            g.drawImage(background, 0, 110, null);
        else {
            g.drawImage(background, 0, 110, null);
            Color c1 = new Color(15,136,189);
            g.setColor(c1);
            g.drawImage(form1, 160, 300, null);
            g.fillRect(160, 487, 240, 40);
            g.drawImage(form2, 600, 300, null);
            g.fillRect(600, 487, 240, 40);
            g.drawImage(form3, 1040, 300, null);
            g.fillRect(1040, 487, 240, 40);
            g.setColor(Color.white);
            Font font = new Font("Arial", Font.PLAIN, 24);
            g.setFont(font);
            g.drawString("4-3-3(2)", 238, 514);
            g.drawString("3-4-1-2", 682, 514);
            g.drawString("4-1-2-1-2", 1113, 514);
        }
    }
    public static int getFormation() { return formation; }
}