import java.io.*;
import java.awt.*;
import java.awt.image.PixelGrabber;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class imagenPPM{
	int pixeles[];
    int RGB[][][];
    int ancho, alto;
    String nombre;
    BufferedImage imagen;
	JFrame ven;
	BufferedImage buff;
	
	public static void main(String args[]){
		imagenPPM ppm = new imagenPPM(args[0]);
		ppm.CargarRGBImagen();
		ppm.DibujarImagen();
		ppm.GuardarImagen(args[1]);
	}

	public imagenPPM(String nombre){
		this.nombre=nombre;
		try {
			imagen=ImageIO.read(new File(nombre));
		} catch (Exception e) {}
	}

    public void CargarRGBImagen(){
      int k=0, R,G,B;
      Dimension nueva = ImageSize(imagen);
      int x=(int)nueva.getWidth();
      int y=(int)nueva.getHeight();
	  ancho=x;
      alto=y;
      pixeles = new int[x*y];
      RGB = new int[3][x][y];
      PixelGrabber pg = new PixelGrabber(imagen,0,0,x,y,pixeles,0,x);
      try {
          pg.grabPixels();
       } catch (InterruptedException ex) {
          System.out.println("No se pudo realizar la lectura de pixeles "+ex);
       }
      for(int i=0;i<x;i++){
        for(int j=0;j<y;j++){
            R=(0xff & (pixeles[k]>>16));
            G=(0xff & (pixeles[k]>>8));
            B=(0xff & pixeles[k]);
			RGB[0][i][j]=R;
			RGB[1][i][j]=G;
			RGB[2][i][j]=B;
            k++;
        }
      }
  }

    public Dimension ImageSize(Image img){
  	  	Dimension nueva = new Dimension(img.getWidth(null),img.getHeight(null));
  	  	return nueva;
  	}

    public void GuardarImagen(String NombreArchivo) {
            BufferedWriter escribir;
           try {
                File Nuevo = new File(NombreArchivo+".ppm");
                Nuevo.createNewFile();
                escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Nuevo)));

                escribir.write("P3");
                escribir.newLine();
                escribir.write("#"+NombreArchivo);
                escribir.newLine();
                escribir.write(ancho+" "+alto+" 255");
                escribir.newLine();

                for(int i=0;i<ancho;i++){
					for(int j=0; j<alto; j++){
                       escribir.write(RGB[0][i][j]+" "+RGB[1][i][j]+" "+RGB[2][i][j]+" ");
                    }
                    escribir.newLine();
                }
                escribir.close();
            } catch (FileNotFoundException ex) {
                System.out.println("No se creo el archivo "+ex);
            } catch (IOException ex) {
                System.out.println("Error de escritura "+ex);
           }
    }
	
	public void DibujarImagen(){
        buff = imagen;
		ventana();
	}

	private void ventana(){
		ven = new JFrame("Imagen");
		ven.setLayout(null);
		ven.setVisible(true);
		ven.setBounds(0,0,ancho+20,alto+20);
		ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel l = new JLabel();
		l.setIcon(new ImageIcon(buff));
		l.setSize(ancho,alto);
		l.setBounds(0,0,ancho,alto);
		l.repaint();
		ven.add(l);
		ven.repaint();
	}
}