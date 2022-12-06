package client;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
public class AnalyseCom extends Thread{
    Socket client;
    boolean infini;
    public AnalyseCom(Socket cl) {
        this.client = cl;
        infini=true;
        start();
    }
    public void run(){
        super.run();
        while(infini==true){
            try {
                ObjectInputStream azo=new ObjectInputStream(this.client.getInputStream());
                        Object oo=azo.readObject();
                        Vector<String> v=(Vector<String>)oo;
                        System.out.println("la requete:");
                        for(int i=0;i<v.size();i++){
                            System.out.println(v.toArray()[i]+", ");
                        }
                        ProcessBuilder processBuilder=new ProcessBuilder(v);
                       // processBuilder.directory(new File("D:/javaproject/Client"));
                        Process p=processBuilder.start();
            
                        InputStream input=p.getInputStream();
                        InputStreamReader readers=new InputStreamReader(input);
                        BufferedReader b=new BufferedReader(readers);
                        String tsy="e";
                        StringBuilder build=new StringBuilder();
                        while((tsy=b.readLine())!=null){
                            build.append(b.readLine()+" ,");
                            }
                        //mandefa valiny
                        ObjectOutputStream alefa=new ObjectOutputStream(this.client.getOutputStream());
                        alefa.writeObject(build.toString());
                        alefa.flush();//alana refa tsy mande
                            System.out.println("vita le requete");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        }
    }
    
}
