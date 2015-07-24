import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Gerardo
 */
public class AnimacionGIF2 extends JFrame{
    
    public static void main(String arg[]){
        AnimacionGIF2 ani = new AnimacionGIF2();
    }
    
    public AnimacionGIF2(){
        super("Animacion con imágenes GIF");
        setLayout(null);
        setVisible(true);
        setBounds(0,0,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("img/ptero.gif"));
        label.setSize(100,100);
        label.setBounds(0,0,label.getWidth(),label.getHeight());
        add(label);
        repaint();
    }
    
}
