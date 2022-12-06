package serveur;
import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Vector;
public class GetClientS extends Thread{
    Socket client;
    boolean infini;
    JPanel panel;
    public GetClientS(Socket client,JPanel p) {
        this.client = client;
        this.infini=true;
        this.panel=p;
        start();
    }
    @Override
    public void run() {
        super.run();
        DataInputStream ins=null;
        try {
            ins=new DataInputStream(this.client.getInputStream());
        } catch (Exception e) {
           e.printStackTrace();
        }
        while(infini==true){
           try {
            byte[] totalsize=new byte[4];
            ins.readFully(totalsize);

            int taille=ByteBuffer.wrap(totalsize).asIntBuffer().get();
            byte [] finalbyte=new byte[taille];
            int nowInRead=0;
            int addenazy=0;
            while(nowInRead < taille && (addenazy = ins.read(finalbyte, nowInRead, taille-nowInRead)) > 0){
                nowInRead+=addenazy;
            }
            Image image=ImageIO.read(new ByteArrayInputStream(finalbyte));
            Graphics g=this.panel.getGraphics();
            g.drawImage(image,0,0,this.panel.getWidth(),this.panel.getHeight(),this.panel);
           } catch (Exception e) {
                e.printStackTrace();
           }
        }
    }
}
