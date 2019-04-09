package socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LigarServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Servidor ligado na porta 4444...");
        while (true) {
            Socket socket = serverSocket.accept();

            new SocketLogica(socket).taxas();

        }
    }
}
