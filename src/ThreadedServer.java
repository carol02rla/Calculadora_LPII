import java.net.*;
import java.io.*;

public class ThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(4444);
        while (true) {
            Socket ns = s.accept();
            new Thread(new ProtocolServer(ns)).start();
        }
        //s.close();
    }
}