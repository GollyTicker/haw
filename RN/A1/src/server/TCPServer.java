package server;

import java.io.*;
import java.net.*;

/**
 * Created by sacry on 05/04/14.
 */
class TCPServer {

    private static final int N = 500;

    private static void serverRun(ServerSocket socket) throws Exception {
        int currentUsers = 0;
        Socket connectionSocket = null;
        do {
            if (currentUsers < N) {
                connectionSocket = socket.accept();
                new TCPServerThread(connectionSocket).run();
                currentUsers += 1;
            } else {
                break;
            }
        } while (true);

        connectionSocket.close();
        socket.close();
    }

    public static void main(String args[]) throws Exception {
        ServerSocket socket = new ServerSocket(6789);
        serverRun(socket);
    }
}