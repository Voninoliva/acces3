package client;
import java.util.Vector;
import java.io.*;
import java.net.Socket;
public class Myclient {
    public static void main(String[] args) throws Exception {
        try {
            Socket client=new Socket("192.168.10.236", 3000);
            ClientScreen cl=new ClientScreen(client); 
        } catch (Exception e) {
            e.printStackTrace();
        }
                                                                                                                 
    }
}
