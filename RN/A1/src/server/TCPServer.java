package server;

import java.io.*;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sacry on 05/04/14.
 */
class TCPServer {

    private ServerSocket listener;
    private Socket clientSocket;

    public TCPServer(ServerSocket listener) {
        this.listener = listener;
    }

    private void run() {
        System.out.println("Welcome to My Server!");

        while (ThreadMonitor.serverShouldBeRunning()) {
            try {

                clientSocket = listener.accept();
                ThreadMonitor.execute(clientSocket);

            } catch (Exception e) {
                closeConnection();
            }
        }
        closeConnection();
    }

    private void closeConnection() {
        try {
            listener.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {
        ServerSocket socket = new ServerSocket(6789);
        TCPServer tcpServer = new TCPServer(socket);
        tcpServer.run();
    }
}