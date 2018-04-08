import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Select {
    private Player[] players = new Player[5];
    private Player selectedPlayer;

    public Select(String position) {

    }
    public void showOptions() {
        BufferedImage[] images = new BufferedImage[5];
        for(int i = 0; i < images.length; i++)
            images[i] = players[i].getCard();
    }
}