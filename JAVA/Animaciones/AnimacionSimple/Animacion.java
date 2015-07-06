import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Gerardo
 */
public class Animacion extends JFrame{
    static Image img;
    static Image fondo;
    
    public static void main(String arg[]){
        img = new ImageIcon("img/d0.png").getImage();
        fondo = new ImageIcon("img/fondo.jpg").getImage();
        Animacion ani = new Animacion();
        ani.retardo();
    }
    
    public Animacion(){
        super("Mi primera Animación");
        setLayout(null);
        setVisible(true);
        setBounds(0,0,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        repaint();
    }
    
    public void retardo(){
        ImageIcon icon=null;
        int i;
        while(true){
            for(i=0; i<2; i++){
                icon = new ImageIcon("img/d"+i+".png");
                img = icon.getImage();
                repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(fondo, 0, 0, this);
        g.drawImage(img, 200, 200, this);
    }
}
