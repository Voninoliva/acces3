package serveur;
import java.awt.*;
import java.io.DataInputStream;
import java.net.Socket;
import javax.swing.*;
public class Repaint extends Thread{
    JPanel panel;
    Socket client;
    double widths;
    double heights;
    public Repaint(Socket c) {
        this.client=c;
        start();
    }
    public void createInterface(){
        JFrame theframe=new JFrame("the client screen");
        //theframe.setSize(new Dimension(500,400));
        //theframe.setDimension(JFrame.MAXIMIZED_BOTH);
        this.panel=new JPanel();
        theframe.add(this.panel);
        theframe.setVisible(true);
    }
    @Override
    public void run() {
        super.run();
        createInterface();
        try {
            DataInputStream d=new DataInputStream(client.getInputStream());
            this.widths=d.readDouble();
            this.heights=d.readDouble();
            System.out.println(this.widths+"  "+this.heights);
            GetClientS gs=new GetClientS(this.client,this.panel);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        EventL event=new EventL(this.client,this.panel,this.widths,this.heights);
    }
}
