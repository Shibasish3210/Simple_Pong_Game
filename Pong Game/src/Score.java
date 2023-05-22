import java.awt.*;

public class Score {
    int Width, Height;

    protected static int player1 = 0;
    protected static int player2 = 0;

    public Score(int Width, int Height) {
        this.Width = Width;
        this.Height = Height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.getHSBColor(2,4,7)); // setting the color
        g.setFont(new Font("Times new roman", Font.PLAIN, Constants.fontSize));
        g.drawString(String.valueOf(player1), 40,100);
        g.drawString(String.valueOf(player2),Constants.Screen_Width - 90,100);
    }
}
