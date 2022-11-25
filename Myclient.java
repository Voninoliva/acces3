import java.io.*;
import java.net.Socket;
import java.util.Vector;

public class Myclient {
    public static void main(String[] args) throws Exception {
       Socket client=new Socket("localhost", 3000);
        System.out.println("entrez les commandes:");
        Vector<String> commandes=new Vector<String>();
        BufferedReader soratana=new BufferedReader(new InputStreamReader(System.in));
        Thread envoyer=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean bool=true;
                while(bool==true){
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
        });
        envoyer.start();
      Thread recevoir=new Thread(new Runnable() {

        @Override
        public void run() {
            
            while(true){
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
        
      }); 
       recevoir.start(); 
    }
}
