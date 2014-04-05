package server;

import java.io.*;
import java.net.*;

/**
 * Created by sacry on 05/04/14.
 */
class TCPServer {

    private static final int N = 500;
    private static volatile int currentUsers = 0;

    private static void serverRun(ServerSocket socket) {
        System.out.println("Welcome to My Server!");
        Socket connectionSocket = null;
        do {
            try {
                if (currentUsers < N) {
                    connectionSocket = socket.accept();
                    new TCPServerThread(connectionSocket).run();
                    currentUsers += 1;
                } else {
                    break;
                }
            } catch (Exception e) {
                closeConnection(connectionSocket);
            }
        } while (true);

        closeServerConnection(socket);
    }

    private static void closeConnection(Socket connectionSocket) {
        try {
            connectionSocket.close();
        } catch (IOException e) {

        }
    }

    private static void closeServerConnection(ServerSocket serverSocket) {
        try {
            serverSocket.close();
        } catch (IOException e) {

        }
    }

    public static void main(String args[]) throws Exception {
        ServerSocket socket = new ServerSocket(6789);
        serverRun(socket);
    }
}