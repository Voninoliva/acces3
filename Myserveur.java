package serveur;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
public class Myserveur{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(3000);
        Socket client=serverSocket.accept();
        Repaint r=new Repaint(client);
    }
}