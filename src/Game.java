import java.awt.Color;
import java.awt.Graphics;
import java.net.SocketPermission;

import javax.annotation.processing.SupportedOptions;
import javax.swing.JPanel;

public class Game extends JPanel{
    private Bola bola;
    public Game() {//construtor
        bola = new Bola();
        setFocusable(true);//para escultar os eventos 
        setLayout(null);//para não usar outros componentes da classe
        new Thread(new Runnable() {//cria um instância da classe thread como a classe interna anônima
            @Override
            public void run() {
                gameLoop();//função que dispara o mecanismo Ganeloop
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
                Thread.sleep(17);//método que pausa a execução da thread
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
    public void handleEvent(){}
    public void update(){
        bola.posX = bola.posX + bola.velX;
        bola.posY = bola.posY + bola.velY;
        testecolisos();
    }
    public void render(){
        repaint();//invoca o método paintComponent() pra redesenhar a tela Gameloop
    }
    public void testecolisos(){
        if(bola.posX + bola.raio *2 >= Pricipal.LARGURA_TELA || bola.posX <= 0){
            bola.velX = bola.velX * -1;
        }
        if(bola.posY + bola.raio *2 >= Pricipal.ALTURA_TELA || bola.posY <= 0){
            bola.velY = bola.velY * -1;
        }
    }

    //método sobrescrito ----
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//garantir o desenho na tela
        setBackground(Color.LIGHT_GRAY);//atribui a cor ao fundo da tela
        g.setColor(Color.RED);//define a cor do objeto para vermelho
        //g.fillOval(bola.posX-5,bola.posY-5,bola.raio*2,bola.raio*2);// desenha o objeto em tela (local da telaX, local da telaY, Largura, Altura)
        //g.drawImage(bola.parada, bola.posX, bola.posY, null);
        g.drawImage(bola.obterImagem(),bola.posX, bola.posY, null);
    }
}