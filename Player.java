import java.awt.image.BufferedImage;

public class Player {
    private int rating;
    private String position;
    private String country;
    private String club;
    private String league;
    private String card;
    private String smallCard;

    public Player(int r, String p, String c, String cl, String l, String ca, String sc) {
        rating = r;
        position = p;
        country = c;
        club = cl;
        league = l;
        card = ca;
        smallCard = sc;
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
    public BufferedImage getSmallCard() { return Application.imageFromFile(smallCard); }
}