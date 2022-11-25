import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
public class Myserveur{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(3000);
        Socket client=serverSocket.accept();
        Thread recevoir=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean bool=true;
                while(bool==true){
                    try {
                        ObjectInputStream azo=new ObjectInputStream(client.getInputStream());
                        Object oo=azo.readObject();
                        Vector<String> v=(Vector<String>)oo;
                        System.out.println("la requete:");
                        for(int i=0;i<v.size();i++){
                            System.out.println(v.toArray()[i]+", ");
                        }
                        ProcessBuilder processBuilder=new ProcessBuilder(v);
                    // processBuilder.directory(new File("D:/javaproject"));
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
                        ObjectOutputStream alefa=new ObjectOutputStream(client.getOutputStream());
                        alefa.writeObject(build.toString());
                            System.out.println("vita le requete");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            
        });
        recevoir.start();
    }
}