package serveur;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
public class SendCom extends Thread{
    Socket client;
    boolean infini;
    public SendCom(Socket client) {
        this.client = client;
        infini=true;
        start();
    }
    public void run(){
        super.run();
        System.out.println("entrez les commandes:");
        Vector<String> commandes=new Vector<String>();
        BufferedReader soratana=new BufferedReader(new InputStreamReader(System.in));
        while(infini==true){
            try {
                String s=soratana.readLine();
                System.out.println("soratra="+s);
                commandes.add(s);
                if(s.equalsIgnoreCase("cmd.exe")){
                    commandes.add("/c");
                }
                ObjectOutputStream o=new ObjectOutputStream(client.getOutputStream());
                o.writeObject(commandes);
                o.flush();
            } catch (Exception e) {
               e.printStackTrace();
            }
            
        }
    }

}
