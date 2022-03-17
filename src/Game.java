import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Game extends JPanel{
    public Game() {//construtor
        setFocusable(true);//para escultar os eventos 
        setLayout(null);//para não usar outros componentes da classe
    }

    //método sobrescrito ----
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//garantir o desenho na tela
        setBackground(Color.LIGHT_GRAY);//atribui a cor ao fundo da tela
        g.setColor(Color.RED);//define a cor do objeto para vermelho
        g.fillOval(100,100,50,50);// desenha o objeto em tela (local da telaX, local da telaY, Largura, Altura)
    }
}