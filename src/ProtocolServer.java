import java.net.*;
import java.io.*;

public class ProtocolServer implements Runnable {
    Socket s;

    public ProtocolServer(Socket ns) {
        s = ns;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Protocol protocol = new Protocol();
            while (true) {
                String fromClient = in.readUTF();
                if (fromClient.equals("Bye")) break;
                out.writeUTF(protocol.processLine(fromClient));
            }
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
