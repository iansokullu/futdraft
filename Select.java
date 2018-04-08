import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Select extends JFrame {
    private Player[] players = new Player[5];
    private Player selectedPlayer;

    public Select(String position) {
        setUndecorated(true);
        setSize(1600, 240);
    }
    public void showOptions() {
        BufferedImage[] images = new BufferedImage[5];
        for(int i = 0; i < images.length; i++)
            images[i] = players[i].getCard();
    }
}