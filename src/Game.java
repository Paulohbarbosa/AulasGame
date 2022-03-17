import java.awt.Color;
import java.awt.Graphics;
import java.net.SocketPermission;

import javax.swing.JPanel;

public class Game extends JPanel{
    private Bola bola;
    public Game() {//construtor
        bola = new Bola();
        setFocusable(true);//para escultar os eventos 
        setLayout(null);//para não usar outros componentes da classe
        new Thread(new Runnable() {
            @Override
            public void run() {
                gameLoop();
            }
        }).start();
    }

    //GameLoop--------------------
    public void gameLoop(){
        while(true) {
            handleEvent();
            update();
            render();
            try {
                Thread.sleep(17);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    public void handleEvent(){}
    public void update(){
        bola.posX = bola.posX + bola.velX;
        bola.posY = bola.posY + bola.velY;
    }
    public void render(){
        repaint();
    }

    //método sobrescrito ----
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//garantir o desenho na tela
        setBackground(Color.LIGHT_GRAY);//atribui a cor ao fundo da tela
        g.setColor(Color.RED);//define a cor do objeto para vermelho
        g.fillOval(bola.posX,bola.posY,bola.raio*2,bola.raio*2);// desenha o objeto em tela (local da telaX, local da telaY, Largura, Altura)
    }
}