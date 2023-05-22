import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle{
    int initialSpeed ;
    int width,height;
    Random random;
    int Vx,Vy;
    public Ball(int x, int y,int width, int height){
        super(x,y,width,height);
        random = new Random();


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
        g.setColor(Color.cyan);
        g.fillOval(x,y,Constants.ball_size,Constants.ball_size);

        g.setColor(Color.white);
        g.drawLine(Constants.Screen_Width/2, 0, Constants.Screen_Width/2, Constants.screen_Height);
    }
}
