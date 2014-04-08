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

    private static final int N = 400;

    private ServerSocket listener;
    private Socket clientSocket;

    public TCPServer(ServerSocket listener) {
        this.listener = listener;
    }

    private void serverRun() {
        System.out.println("Welcome to My Server!");

        while (ThreadMonitor.serverShouldBeRunning(N)) {
            try {
                clientSocket = listener.accept();
                ThreadMonitor.increase();
                new TCPServerThread(clientSocket).run();
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
        TCPServer s = new TCPServer(socket);
        s.serverRun();
    }
}