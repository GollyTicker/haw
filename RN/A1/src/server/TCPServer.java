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

    public void start() {
        System.out.println("Welcome to My Server!");

        while (ThreadMonitor.isRunning) {
            System.out.println(ThreadMonitor.isRunning);
            try {
                if (ThreadMonitor.canCreateMoreThreads()) {
                    clientSocket = listener.accept();
                    ThreadMonitor.execute(clientSocket, listener);
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        System.out.println("Goodbye!");
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
        int port = Integer.valueOf(args[0]); // 6789
        new TCPServer(new ServerSocket(port)).start();
    }
}