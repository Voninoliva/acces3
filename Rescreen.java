package serveur;
import java.awt.*;
import java.net.Socket;
import javax.swing.*;
public class Rescreen extends Thread{
    JPanel panel;
    Socket client;
    public Rescreen(Socket c) {
        this.client=c;
        start();
    }
    public void createInterface(){
        JFrame theframe=new JFrame("the client screen");
        // JDesktopPane desktop=new JDesktopPane();

        // theframe.add(desktop, BorderLayout.CENTER);
        this.panel=new JPanel();

        // JInternalFrame interFrame=new JInternalFrame();
        // interFrame.setLayout(new BorderLayout());
        // interFrame.getContentPane().add(this.panel, BorderLayout.CENTER);
        // interFrame.setSize(100, 100);
        // desktop.add(interFrame);
        theframe.add(this.panel);
        theframe.setVisible(true);
    }
    @Override
    public void run() {
        super.run();
        createInterface();
        GetClientS gs=new GetClientS(this.client,this.panel);
    }
}
