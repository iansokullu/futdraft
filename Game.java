import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public class Game extends JPanel {
    /*
    4-3-3(2):
      [0] [1] [2]
      [3] [4] [5]
    [6] [7] [8] [9]
         [10]

    3-4-1-2:
         [0] [1]
           [2]
     [3] [4] [5] [6]
       [7] [8] [9]
           [10]

    4-1-2-1-2:
         [0] [1]
           [2]
         [3] [4]
           [5]
     [6] [7] [8] [9]
           [10]
     */

    // Values for storing current score

    private int chemistry = 0;
    private int rating = 0;

    // Arrays containing currently selected players and their images

    private Player[] team = new Player[11];
    private BufferedImage[] img = new BufferedImage[11];
    private Player[] bench = new Player[7];
    private BufferedImage[] benchImg = new BufferedImage[7];

    // 2D array holding the boundaries for each player image

    int[][] imgBoundaries = new int[11][4];
    int[][] benchImgBoundaries = new int[7][4];

    private Select select;

    private HashMap<Integer, String> positions = new HashMap<>();

    private BufferedImage draftBackground = Application.imageFromFile("\\images\\Draft.jpg");
    private BufferedImage score = Application.imageFromFile("\\images\\Rating.png");
    private Font scoreFont = new Font("Arial", Font.PLAIN, 20);

    private boolean movePlayer = false;
    private int selectedPlayer1 = -1;
    private int selectedPlayer2 = -1;

    private boolean moveBenchedPlayer = false;
    private int selectedBenchedPlayer = -1;
    private int selectedUnbenchedPlayer = -1;

    private int tempX;
    private int tempY;

    private int xpos;
    private int ypos;

    public Game() {
        setImg();
        map();

        int[][] imgBoundaries = new int[11][4];

        if(Draft.getFormation() == 1) {
            imgBoundaries[0][0] = 300;
            imgBoundaries[0][1] = 150;
        }
        else if(Draft.getFormation() == 2) {

        }
        else if(Draft.getFormation() == 3) {

        }
        else
            System.out.println("Error! No formation is selected");

        benchImgBoundaries[0][0] = 300;
        benchImgBoundaries[0][1] = 900;

        if(Draft.getFormation() >= 1 && Draft.getFormation() <= 3) {
            for(int i = 0; i < 11; i++) {
                imgBoundaries[i][2] = imgBoundaries[i][0] + 118;
                imgBoundaries[i][3] = imgBoundaries[i][1] + 180;
            }
        }

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                for(int i = 0; i < 11; i++) {
                    if(x >= imgBoundaries[i][1] && x <= imgBoundaries[i][3] && y >= imgBoundaries[i][2] && y <= imgBoundaries[i][4]) {
                        select = new Select(positions.get(i));
                        select.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        select.setVisible(true);
                        i = 11;
                    }
                }
            }

            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                for(int i = 0; i < imgBoundaries.length; i++) {
                    if(x >= imgBoundaries[i][0] && x <= imgBoundaries[i][2] && y >= imgBoundaries[i][1] && y <= imgBoundaries[i][3]) {
                        if(team[i] != null) {
                            movePlayer = true;
                            selectedPlayer1 = i;
                            xpos = x;
                            ypos = y;
                        }
                        else
                            i = 11;
                    }
                }

                if(!movePlayer) {
                    for(int i = 0; i < benchImgBoundaries.length; i++) {
                        if(x >= benchImgBoundaries[i][0] && x <= benchImgBoundaries[i][2] && y >= benchImgBoundaries[i][1] && y <= benchImgBoundaries[i][3]) {
                            if(team[i] != null) {
                                moveBenchedPlayer = true;
                                selectedBenchedPlayer = i;
                                xpos = x;
                                ypos = y;
                            }
                            else
                                i = 8;
                        }
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if(movePlayer) {
                    for(int i = 0; i < 11; i++) {
                        if(x >= imgBoundaries[i][1] && x <= imgBoundaries[i][3] && y >= imgBoundaries[i][2] && y <= imgBoundaries[i][4]) {
                            if(team[i] != null) {
                                if(i == selectedPlayer1) {
                                    movePlayer = false;
                                    selectedPlayer1 = -1;
                                }
                                else
                                    selectedPlayer2 = i;
                                i = 11;
                            }
                            else {
                                i = 11;
                            }
                        }
                        else {
                            movePlayer = false;
                        }

                    }
                    if(selectedPlayer1 != -1 && selectedPlayer2 != -1 && movePlayer) {
                        swapPlayer(selectedPlayer1, selectedPlayer2);
                        setImg();
                        repaint();
                    }
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if(movePlayer) {

                }
                else if(moveBenchedPlayer) {

                }
            }
        });
}

    public void paintComponent(Graphics g) {
        g.setFont(scoreFont);
        g.drawImage(draftBackground, 0, 0, null);
        g.drawImage(score, 1160, 40, null);

        if(rating < 10)
            g.drawString(String.valueOf(rating), 1287, 90);
        else
            g.drawString(String.valueOf(rating), 1280, 90);

        if(chemistry < 10)
            g.drawString(String.valueOf(chemistry), 1287, 133);
        else
            g.drawString(String.valueOf(chemistry), 1280, 133);

        for(int i = 0; i < team.length; i++)
            g.drawImage(img[i], imgBoundaries[i][0], imgBoundaries[i][1], null);
        for(int i = 0; i < bench.length; i++)
            g.drawImage(benchImg[i], benchImgBoundaries[i][0], benchImgBoundaries[i][0], null);
    }

    public void setImg() {
        for(int i = 0; i < 11; i++) {
            if(team[i] != null)
                img[i] = (team[i].getSmallCard());
            else
                img[i] = Application.imageFromFile("\\images\\EMPTY.png");
        }
        for(int i = 0; i < 7; i++) {
            if(bench[i] != null)
                benchImg[i] = (bench[i].getSmallCard());
            else
                benchImg[i] = Application.imageFromFile("\\images\\EMPTY.png");
        }
    }

    public void swapPlayer(int x, int y) {
        Player temp = team[x];
        team[x] = team[y];
        team[y] = temp;
    }

    // X must be the player currently on the team, and Y must be currently on the bench

    public void unBench(int x, int y) {
        Player temp = team[x];
        team[x] = bench[y];
        bench[y] = temp;
    }

    public void updateScore() {
        rating = 0;
        chemistry = 0;

        for(int i = 0; i < team.length; i++) {
            if(team[i] != null)
                rating += team[i].getRating() / team.length;
        }
    }

    public void map() {
        if(Draft.getFormation() == 1) {
            positions.put(0, "ST");
            positions.put(1, "ST");
            positions.put(2, "CM");
            positions.put(3, "CM");
            positions.put(4, "CM");
            positions.put(5, "CM");
            positions.put(6, "CM");
            positions.put(7, "CB");
            positions.put(8, "CB");
            positions.put(9, "CB");
            positions.put(10, "GK");
        }
        else if(Draft.getFormation() == 2) {
            positions.put(0, "LW");
            positions.put(1, "ST");
            positions.put(2, "RW");
            positions.put(3, "CM");
            positions.put(4, "CM");
            positions.put(5, "CM");
            positions.put(6, "LB");
            positions.put(7, "CB");
            positions.put(8, "CB");
            positions.put(9, "RB");
            positions.put(10, "GK");
        }
        else if(Draft.getFormation() == 3) {
            positions.put(0, "ST");
            positions.put(1, "ST");
            positions.put(2, "CM");
            positions.put(3, "CM");
            positions.put(4, "CM");
            positions.put(5, "CM");
            positions.put(6, "LB");
            positions.put(7, "CB");
            positions.put(8, "CB");
            positions.put(9, "RB");
            positions.put(10, "GK");
        }
        else
            System.out.print("Error! No formation is selected");
    }

    public void closeSelect() {
        select.setVisible(false);
        select.dispose();
    }
}
