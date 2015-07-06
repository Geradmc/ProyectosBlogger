
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Gerardo
 */
public class AnimacionGIF extends JFrame{
    static Image img;
    static Image fondo;
    public static void main(String arg[]){
        fondo = new ImageIcon("img/fondo.jpg").getImage();
        img = new ImageIcon("img/ptero.gif").getImage();
        AnimacionGIF ani = new AnimacionGIF();
    }
    
    public AnimacionGIF(){
        super("Animacion con imágenes GIF");
        setLayout(null);
        setVisible(true);
        setBounds(0,0,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        repaint();
    }
    
    
    @Override
    public void paint(Graphics g){
        g.drawImage(fondo, 0, 0, this);
        g.drawImage(img, 200, 200, this);
    }
    
}
