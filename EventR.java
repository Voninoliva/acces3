package client;
import java.io.*;
import java.net.Socket;
import java.awt.Robot;
public class EventR extends Thread{
    Socket client;
    Robot robot;
    boolean infini;
    BufferedReader reader;
    public EventR(Socket client, Robot robot) {
        this.client = client;
        this.robot = robot;
        this.infini=true;
        start();
    }
    @Override
    public void run() {
        super.run();
        try {
            this.reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
            while(infini==true){
                String com=reader.readLine();
            switch(com){
                case "1":
                    this.robot.keyPress(Integer.valueOf(reader.readLine()));
                    break;
                case "2":
                    this.robot.keyRelease(Integer.valueOf(reader.readLine()));
                    break;
                case "3":
                    this.robot.mouseMove((Integer.valueOf(reader.readLine())),Integer.valueOf(reader.readLine()));
                    break;
                case "4":
                    this.robot.mousePress(Integer.valueOf(reader.readLine()));
                    break;
                case "5":
                    this.robot.mouseRelease(Integer.valueOf(reader.readLine()));
                    break;
                default:
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
