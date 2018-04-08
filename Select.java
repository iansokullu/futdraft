import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Select {
    private Player[] players = new Player[5];

    public Select(String position) throws InterruptedException {
        if(position.equals("LW")) {
            for(int i = 0; i < players.length; i++) {
                int size = Application.leftWingsSize();
                players[i] = new Application().getLeftWing((int)(size * Math.random()));
            }
        }
        showOptions();
    }
    public void showOptions() {
        BufferedImage[] images = new BufferedImage[5];
        for(int i = 0; i < images.length; i++)
            images[i] = players[i].getCard();
    }
}
