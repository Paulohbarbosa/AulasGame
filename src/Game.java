import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Game extends JPanel{
    public Game() {//construtor
        setFocusable(true);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);
        g.setColor(Color.RED);
        g.fillOval(100,100,50,50);
    }
}