package client;
import java.util.Vector;

import javax.swing.JOptionPane;

import java.io.*;
import java.net.Socket;
import java.awt.*;
public class Myclient {
    public static void main(String[] args) throws Exception {
        try {
            String ip="";
            ip=JOptionPane.showInputDialog("entrez l'ip");
            System.out.println(ip);
                Socket client=new Socket(ip, 3000);
                ClientScreen cl=new ClientScreen(client);//192.168.92.191 
        } catch (Exception e) {
            e.printStackTrace();
        }
                                                                                                                 
    }
}
