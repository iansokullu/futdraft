import java.net.URL;
import javax.swing.*;

public class Start extends JPanel {
    public Start() {
        // Simply displays the start screen animation
        URL url = Application.class.getClassLoader().getResource("\\images\\Start.gif");
        Icon icon = new ImageIcon(url);
        JLabel animation = new JLabel(icon);
        add(animation);
    }
}