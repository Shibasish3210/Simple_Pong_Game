import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame  {

    public MainFrame(){
        this.getContentPane().setBackground(Color.BLACK);
        this.setTitle(Constants.game_Title);

        MainPanel mainPanel = new MainPanel();
        add(mainPanel);

        pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
