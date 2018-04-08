import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.URL;

public class Game extends JPanel {
    /*
    4-3-3(2):
      [1] [2] [3]
      [4] [5] [6]
    [7] [8] [9] [10]
         [11]

    3-4-1-2:
         [1] [2]
           [3]
     [4] [5] [6] [7]
       [8] [9] [10]
           [11]

    4-1-2-1-2:
         [1] [2]
           [3]
         [4] [5]
           [6]
     [7] [8] [9] [10]
           [11]
     */

    private BufferedImage draftBackground = Application.imageFromFile("\\images\\Draft.jpg");
    private BufferedImage score = Application.imageFromFile("\\images\\Rating.png");
    private Font scoreFont;

    public Game() {
        try {
            URL fontURL = Application.class.getClassLoader().getResource("\\fonts\\EA.ttf");
            scoreFont = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
            scoreFont = scoreFont.deriveFont(Font.PLAIN,12);
        } catch (Exception e) {
            e.getStackTrace();
            scoreFont = new Font("Arial", Font.PLAIN, 12);
        }

    }

    public void paintComponent(Graphics g) {
        g.drawImage(draftBackground, 0, 0, null);
        g.drawImage(score, 1160, 40, null);

    }
}
