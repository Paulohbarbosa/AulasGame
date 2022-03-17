import javax.swing.JFrame;
import java.awt.Dimension;

public class Pricipal {
    public static final int LARGURA_TELA = 640;
    public static final int ALTURA_TELA = 480;

    public Pricipal() {
        JFrame janela= new JFrame("Jogo2D");//criar um objeto do tipo JFrame como esse nome (" ")
        Game game= new Game();
        game.setPreferredSize(new Dimension(LARGURA_TELA, ALTURA_TELA));
        //janela.setSize(LARGURA_TELA,ALTURA_TELA);//definindo as dimensões da Janela
        janela.getContentPane().add(game);
        janela.setResizable(true);//possibilita o redimensionamento
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Garante que o app seja totalmente fechado
        janela.setLocation(100,100);// posição em que a janela vai ser redenizada na tela.
        janela.setVisible(true);//obrigatória para que a janela apareça
        janela.pack();
    }
    public static void main(String[] args) {
        new Pricipal();
    }
    
}
