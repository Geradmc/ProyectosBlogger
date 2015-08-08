import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class MovFiguras extends Canvas{
    double theta=0.0;
    JFrame winPrincipal;
    
    public static void main(String args[]){
        MovFiguras fig = new MovFiguras();
        fig.infinite();
    }
    
    public MovFiguras(){
        winPrincipal = new JFrame("Animaciones con figuras");
        winPrincipal.setLayout(null);
        winPrincipal.setVisible(true);
        winPrincipal.setBounds(10,10,600,600);
        setBounds(0,0,600,600);
        setVisible(true);
        winPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winPrincipal.add(this);
        winPrincipal.repaint();
    }
    
    public void infinite(){
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            repaint();
        }
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.blue);
        g2.fillRect(0, 0, 600, 600);

        g2.setColor(Color.white);
        g2.translate(600/2, 600/2);
        g2.rotate(theta);
        g2.drawLine(0, 0, 100, 0);
        g2.rotate(theta+1.7);
        g2.translate(100, 100);
        g2.rotate(theta+3.0);
        g2.fillArc(0, 0, 50, 50, 0, 300);
        g2.drawArc(0, 0, 50, 50, 0, 300);
        theta+=0.1;
    }
    
}
