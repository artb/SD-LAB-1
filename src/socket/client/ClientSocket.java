package socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {
    public double taxas(double Q0, double QF, int t) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        out.writeDouble(Q0);
        out.writeDouble(QF);
        out.writeInt(t);
        double resultado = in.readDouble();

        in.close();
        out.close();
        socket.close();

        return resultado;
    }
}
