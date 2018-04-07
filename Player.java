import java.awt.image.BufferedImage;

public class Player {
    private int rating;
    private String country;
    private String club;
    private String league;
    private String card;

    public Player(int r, String c, String cl, String l, String ca) {
        rating = r;
        country = c;
        club = cl;
        league = l;
        card = ca;
    }

    public Player() {
        rating = 0;
        country = "";
        club = "";
        league = "";
        card = "";
    }

    public int getRating() { return rating; }
    public String getCountry() { return country; }
    public String getClub() { return club; }
    public String getLeague() { return league; }
    public BufferedImage getCard() { return Application.imageFromFile(card); }
}