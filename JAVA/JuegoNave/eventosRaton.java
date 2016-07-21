/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Gerardo
 */
public class eventosRaton extends JFrame implements MouseListener, MouseMotionListener{
    private Graphics2D g2d;
    private BufferedImage buffer;
    private int opcion;
    private String mensaje;
    private int xmover, ymover;

    public eventosRaton(){
        super("Ejemplo de eventos al ratón");
        buffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
        g2d = buffer.createGraphics();
        opcion=0;
        mensaje="";
        xmover=100; ymover=100;
        setLayout(null);
        setBounds(10,10,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
        repaint();
    }
    
    public void animacion(){
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
    public void update(Graphics g){
        int i,r1,r2;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 800, 600);
        g2d.setColor(Color.white);
        for(i=0; i<100; i++){
            r1 = (int)(Math.random()*800);
            r2 = (int)(Math.random()*600);
            g2d.drawOval(r1, r2, 2, 2);
        }
        g2d.setFont(new Font("Courier New", 1, 30));
        
        if(opcion==0){
            g2d.setColor(Color.GREEN);
            g2d.fillRoundRect(30, 350,300, 50, 5, 5);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Nuevo Juego", 85, 380);
        }else{ 
            g2d.setColor(Color.BLUE);
            g2d.fillRoundRect(30, 350,300, 50, 5, 5);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Nuevo Juego", 85, 380);
        }
        
        if(opcion==1){
            g2d.setColor(Color.GREEN);
            g2d.fillRoundRect(30, 420,300, 50, 5, 5);
            g2d.setColor(Color.BLACK);
            g2d.drawString("RECORDS", 115, 450);
        }else{ 
            g2d.setColor(Color.BLUE);
            g2d.fillRoundRect(30, 420,300, 50, 5, 5);
            g2d.setColor(Color.WHITE);
            g2d.drawString("RECORDS", 115, 450);
        }
        
        if(opcion==2){
            g2d.setColor(Color.GREEN);
            g2d.fillRoundRect(30, 490,300, 50, 5, 5);
            g2d.setColor(Color.BLACK);
            g2d.drawString("SALIR", 125, 520);
        }else{ 
            g2d.setColor(Color.BLUE);
            g2d.fillRoundRect(30, 490,300, 50, 5, 5);
            g2d.setColor(Color.WHITE);
            g2d.drawString("SALIR", 125, 520);
        }
        
        g2d.setColor(Color.cyan);
        g2d.drawRoundRect(30, 350,300, 50, 5, 5);
        g2d.drawRoundRect(30, 420,300, 50, 5, 5);
        g2d.drawRoundRect(30, 490,300, 50, 5, 5);
        g2d.drawString(mensaje, 100, 50);
        
        g2d.fillRect(xmover,ymover, 20, 20);
        
        g.drawImage(buffer, 0, 0, this);
    }
    
    @Override
    public void paint(Graphics g){
        update(g);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getX()>30 && e.getX()<330 && e.getY()>350 && e.getY()<400 && e.getButton()==MouseEvent.BUTTON1){
            mensaje="JUEGO INICIADO";
        }
        if(e.getX()>30 && e.getX()<330 && e.getY()>420 && e.getY()<470 && e.getButton()==MouseEvent.BUTTON1){
            mensaje="RECORDS DE JUGADORES";
        }
        if(e.getX()>30 && e.getX()<330 && e.getY()>490 && e.getY()<540 && e.getButton()==MouseEvent.BUTTON1){
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mensaje="";
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getX()>xmover && e.getX()<xmover+20 && e.getY()>ymover && e.getY()<ymover+20){
            xmover=e.getX()-10;
            ymover=e.getY()-10;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getX()>30 && e.getX()<330 && e.getY()>350 && e.getY()<400){
            opcion=0;
        }
        if(e.getX()>30 && e.getX()<330 && e.getY()>420 && e.getY()<470){
            opcion=1;
        }
        if(e.getX()>30 && e.getX()<330 && e.getY()>490 && e.getY()<540){
            opcion=2;
        }
    }
    
    public static void main(String args[]){
        eventosRaton er = new eventosRaton();
        er.animacion();
    }
}
