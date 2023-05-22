import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    int id;
    int Vy;
    int speed = 10;
    int width;
    int height;
    public Paddle(int x, int y,int id){
        //passing these parameters to the super
        super(x, y, (int)Constants.paddle_Width, (int)Constants.paddle_Height);
        this.id = id;
    }
    public void move(){
        //to move via adding the velocity to its current position
        y += Vy;

    }

    void draw(Graphics g){
            //Depending upon the player setting the color
        if(id == 1){

            g.setColor(Color.BLUE);

        } else if (id == 2) {

            g.setColor(Color.RED);

        }

        //To draw the actual paddels
        g.fillRect(x,y,Constants.paddle_Width,Constants.paddle_Height);
    }

    public void keyPressed(KeyEvent e) {
        //Depending upon the player moving its position as per needed
        if(id == 1){
            if(e.getKeyCode() == KeyEvent.VK_W){
                changeDirection(-speed);
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                changeDirection(speed);
            }
        }else if(id == 2){
            if(e.getKeyCode() == KeyEvent.VK_UP){
                changeDirection(-speed);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                changeDirection(speed);
            }
        }
    }

    private void changeDirection(int direction) {
        //setting the direction according to need
        Vy = direction;
    }

    public void keyReleased(KeyEvent e) {
        //stopping it's movement to zero
        if(id == 1){
            if(e.getKeyCode() == KeyEvent.VK_W){
                changeDirection(0);
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                changeDirection(0);
            }
        }else if(id == 2){
            if(e.getKeyCode() == KeyEvent.VK_UP){
                changeDirection(0);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                changeDirection(0);
            }
        }
    }
}
