package client;
import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Vector;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ClientScreen extends Thread{
    Socket client;
    Robot robot;
    boolean infini;
    Dimension dimension;
    public ClientScreen(Socket cl)throws Exception {
        this.client = cl;
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
        this.robot=new Robot(gDev);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.dimension=dim;
        this.infini=true;
        start();
    }
    @Override
    public void run() {
        super.run();
        try {
            DataOutputStream datao=new DataOutputStream(this.client.getOutputStream());
            while(infini==true){
                BufferedImage image=robot.createScreenCapture(new Rectangle(this.dimension));
                try {
                    ByteArrayOutputStream outs=new ByteArrayOutputStream();
                    ImageIO.write(image, "png",outs);
                    byte[] len=ByteBuffer.allocate(4).putInt(outs.size()).array();
                    datao.write(len);
                    datao.write(outs.toByteArray());
                    datao.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
