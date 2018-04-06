import java.awt.image.BufferedImage;

public class Player {
    private int rating;
    private int id;
    private String country;
    private String club;
    private String league;
    private String card;

    public Player(int r, int i, String c, String cl, String l, String ca) {
        rating = r;
        id = i;
        country = c;
        club = cl;
        league = l;
        card = ca;
    }

    public Player() {
        rating = 0;
        id = -1;
        country = "";
        club = "";
        league = "";
        card = "";
    }

    public int getRating() { return rating; }
    public int getId() { return id; }
    public String getCountry() { return country; }
    public String getClub() { return club; }
    public String getLeague() { return league; }
    public BufferedImage getCard() { return Application.imageFromFile(card); }
}
