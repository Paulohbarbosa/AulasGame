import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Bola {
    //public BufferedImage parada;
    public BufferedImage direita_baixo;
    public BufferedImage direita_cima;
    public BufferedImage esquerda_baixo;
    public BufferedImage esquerda_cima;
    public int posX;
    public int posY;
    public int raio;
    public int velX;
    public int velY;

    public Bola() {
        try {
            //parada = ImageIO.read(getClass().getResourceAsStream("imgs/parada.gif"));
            direita_baixo = ImageIO.read(getClass().getResourceAsStream("imgs/direita_baixo.gif"));
            direita_cima = ImageIO.read(getClass().getResourceAsStream("imgs/direita_cima.gif"));
            esquerda_baixo = ImageIO.read(getClass().getResourceAsStream("imgs/esquerda_baixo.gif"));
            esquerda_cima = ImageIO.read(getClass().getResourceAsStream("imgs/esquerda_cima.gif"));
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem");
        }

        posX = 200;
        posY = 200;
        raio = 50;
        velX = 3;
        velY = 3;
    }

    public BufferedImage obterImagem(){
        if (velX < 0) {//move-se para a esquerda
            if (velY < 0) {//move-se para a cima
                return esquerda_cima;
            } else {
                return esquerda_baixo;
            }
        } else {//move-se para a direita
            if (velY < 0) {
                return direita_cima;
            } else {
                return direita_baixo;
            }
        }
    }
}
