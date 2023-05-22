import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle{
    int initialSpeed ;
    int width,height;
    Random random;
    int Vx,Vy;

    Color color;
    public Ball(int x, int y,int width, int height, Color color){
        super(x,y,width,height);
        random = new Random();
        this.color = color;

        int RandomXDirection = random.nextInt(2);
        if(RandomXDirection == 0){
            RandomXDirection --;
        }
        setXDir(RandomXDirection);


        int RandomYDirection = random.nextInt(2);
        if(RandomYDirection == 0){
            RandomYDirection--;
        }
        setYDir(RandomYDirection);
    }

    protected void setYDir(int RandomYDirection) {
        Vy = RandomYDirection;
    }

    protected void setXDir(int RandomXDirection) {
        Vx = RandomXDirection;
    }

    public void move(){
        x += Vx;
        y += Vy;
    }

    void draw(Graphics g){

        g.setColor(color);
        g.fillOval(x,y,Constants.ball_size,Constants.ball_size);

        g.setColor(Color.white);
        g.drawLine(Constants.Screen_Width/2, 0, Constants.Screen_Width/2, Constants.screen_Height);
        g.drawArc(Constants.Screen_Width/2-57, Constants.screen_Height/2 - 50, (int) (Constants.paddle_Width*7.5f), Constants.paddle_Height+10,0,360);
    }
}
