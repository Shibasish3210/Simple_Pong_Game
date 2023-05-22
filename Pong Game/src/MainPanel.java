import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


public class MainPanel extends Panel implements Runnable{
        //Creating new screen of Const. size
        Dimension screen = new Dimension(Constants.Screen_Width, Constants.screen_Height);
        Image image;
        Graphics graphics;
        Paddle p1,p2;
        Ball ball;
        Score score = new Score(Constants.score_Width, Constants.score_Height);


    Thread mainThread;

    MainPanel(){
        setPreferredSize(screen);// setting the size of the panel otherwise it would be very small(default size)

        mainThread = new Thread(this);// Creating a new thread
        addKeyListener(new Al());// Adding KeyListeners
        setFocusable(true);
        mainThread.start();//Starting the Thread
        newPaddle();
        newBall();
    }

    //Initializing the new Ball and Paddles
    private void newBall() {
        Random random = new Random();
        ball = new Ball(Constants.Screen_Width/2 - 9,random.nextInt(Constants.screen_Height-Constants.ball_size), Constants.ball_size, Constants.ball_size);
    }

    private void newPaddle() {
        p1 = new Paddle(0,(Constants.screen_Height-Constants.paddle_Height)/2,1);
        p2 = new Paddle(Constants.Screen_Width-Constants.paddle_Width,(Constants.screen_Height-Constants.paddle_Height)/2,2);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);//passing the Graphics to super
        image = createImage(getWidth(),getHeight());//creating the Image
        graphics = image.getGraphics();//getting the Graphis of the Image
        draw(graphics);//Passing Graphics to draw
        g.drawImage(image, 0, 0, this );

    }

    public void draw(Graphics g){
        p1.draw(g);
        p2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
        //troublesome Game Loop....just Kidding😂😂😂
    @Override
    public void run() {
        long lastTime = System.nanoTime();//Getting the Starting time
        //just to get how many nano sec in a sec
        double amountOfTicks = 60;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        while (true){
            //Game Loop
            long nowTime = System.nanoTime();
            delta += (nowTime-lastTime) / ns;

            lastTime = nowTime;

            if(delta >= 1){

                repaint();
                move();
                checkCollision();
                delta--;
            }
        }
    }

    private void checkCollision() {
        if(ball.y <= 0){
            ball.setYDir(-ball.Vy);
        }
        if(ball.y >= Constants.screen_Height-Constants.ball_size){
            ball.setYDir(-ball.Vy);
        }
        if (ball.intersects(p1)) {

            ball.Vx = -ball.Vx;
            ball.Vx++;
            if(ball.Vy > 0){
                ball.Vy++;
            }else{
                ball.Vy--;
            }
            ball.setXDir(ball.Vx);
            ball.setYDir(ball.Vy);
        }
        if (ball.intersects(p2)) {

            ball.Vx = -ball.Vx;
            ball.Vx--;
            if(ball.Vy > 0){
                ball.Vy++;
            }else{
                ball.Vy--;
            }
            ball.setXDir(ball.Vx);
            ball.setYDir(ball.Vy);
        }
        if (p1.y <= 0) {
            p1.y = 0;
        }
        if (p1.y >= Constants.screen_Height-Constants.paddle_Height) {
            p1.y = Constants.screen_Height - Constants.paddle_Height;
        }
        if(p2.y <= 0){
            p2.y = 0;
        }
        if (p2.y >= Constants.screen_Height-Constants.paddle_Height) {
            p2.y = Constants.screen_Height-Constants.paddle_Height;
        }
        if(ball.x <= 0){
            newBall();
            newPaddle();
            Score.player2++;

        }
        if(ball.x >= Constants.Screen_Width - Constants.ball_size){
            newBall();
            newPaddle();
            Score.player1++;

        }
    }

    private void move() {
        p1.move();
        p2.move();
        ball.move();
    }

    public   class Al extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            super.keyPressed(e);
            p1.keyPressed(e);
            p2.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e){
            super.keyReleased(e);
            p1.keyReleased(e);
            p2.keyReleased(e);
        }

    }
}
