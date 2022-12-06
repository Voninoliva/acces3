package serveur;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
public class ReceiveResponse extends Thread{
    Socket client;
    boolean infini;
    public ReceiveResponse(Socket s){
        this.client=s;
        this.infini=true;
        start();
    }
    @Override
    public void run() {
        super.run();
        while(infini==true){
            try {
                    
                ObjectInputStream azo=new ObjectInputStream(client.getInputStream());
                String str=(String) azo.readObject();
                String[] ar=str.split(",");
                for(int i=0;i<ar.length;i++){
                    System.out.println(ar[i]);
                }
                System.out.println(str);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
