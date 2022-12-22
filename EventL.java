package serveur;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JPanel;
public class EventL implements KeyListener, MouseMotionListener, MouseListener {
    Socket client;
    JPanel panel;
    PrintWriter writer; 
    double widths;
    double heights;
    public EventL(Socket client,JPanel p,double w,double h) {
        this.client = client;
        this.panel=p;
        this.widths=w;
        this.heights=h;
        try {
            writer=new PrintWriter(client.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        this.panel.addKeyListener(this);
        this.panel.addMouseListener(this);
        this.panel.addMouseMotionListener(this);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        writer.println("1");
        writer.println(e.getKeyCode());
        writer.flush();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        writer.println("2");
        writer.println(e.getKeyCode());
        writer.flush();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        System.out.print("x");
        writer.println("3");
        double er=this.widths/this.panel.getWidth();
        double ez=this.heights/this.panel.getHeight();
        int eee=(int)(e.getX()*er);
        String ee=(eee)+"";

        int ddd=(int)(e.getY()*ez);
        String dd=(ddd)+"";
        writer.println(Integer.valueOf(ee));
        writer.println(Integer.valueOf(dd));
        writer.flush();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        writer.println("4");
        if(e.getButton()==3){
            writer.println(4);
        }
        else{
            writer.println(16);
        }
        writer.flush();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        writer.println("5");
        if(e.getButton()==3){
            writer.println(4);
        }
        else{
            writer.println(16);
        }
        writer.flush();
    }
    
}