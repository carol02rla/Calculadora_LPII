import java.io.*;
import java.net.*;

public class ProtocolClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4444);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fromUser = stdIn.readLine();
            out.writeUTF(fromUser);
            if (fromUser.equals("Bye")) break;
            System.out.println(in.readUTF());
        }
        in.close();
        out.close();
        s.close();
    }
}