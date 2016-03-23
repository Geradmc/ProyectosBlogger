/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Gerardo
 */
public class DobleBuffering extends JFrame{
    Graphics2D buf; //Graphicos que se utiliza para poder pintar en el buffer
    BufferedImage lienzo; //Imagen donde se dibujan los graficos.
    Image fondo, ani;
    
    public static void main(String args[]){
        DobleBuffering db = new DobleBuffering();
        db.animacion();
    }
    
    public DobleBuffering(){
        super("Doble Buffering");
        setLayout(null);
        setBounds(10,10,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo = new ImageIcon("img/fondo1.jpg").getImage();
        ani = new ImageIcon("img/ptero.gif").getImage();
        lienzo = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
        buf = lienzo.createGraphics();
        setVisible(true);
        repaint();
    }
    
    public void animacion(){
        while(true){
            try {
                repaint();
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /*Sobreecribiendo el metodo update
      y utilizando doble buffering para eliminar parpadeo.*/
    @Override
    public void update(Graphics g){
        int i,j;
        buf.drawImage(fondo, 0, 0, this);
        for(i=1; i<600/20; i++){
            for(j=2; j<400/20-1; j++){
                buf.setColor(Color.white);
                buf.drawRect(i*20-10, j*20, 20-3, 20-3);
                buf.setColor(Color.cyan);
                buf.fillRect(i*20-10, j*20, 20-3, 20-3);
            }
        }
        buf.drawImage(ani, 700, 300, this);
        g.drawImage(lienzo,0,0,this);
    }
    
    @Override
    public void paint(Graphics g){
        update(g);
    }
    
    
    //Metodo paint() donde se nota el parpadeo
    /*@Override
    public void paint(Graphics g){
        int i,j;
        g.drawImage(fondo, 0, 0, this);
        for(i=1; i<600/20; i++){
            for(j=2; j<400/20-1; j++){
                g.setColor(Color.white);
                g.drawRect(i*20-10, j*20, 20-3, 20-3);
                g.setColor(Color.cyan);
                g.fillRect(i*20-10, j*20, 20-3, 20-3);
            }
        }
        g.drawImage(ani, 700, 300, this);
    }*/
}
