package client;

/**
 * Created by sacry on 05/04/14.
 */

import server.ServerStringProcessing;

import java.io.*;
import java.net.*;

class TCPClient {

    private Socket clientSocket;
    private BufferedReader inFromUser;
    private PrintWriter outToServer;
    private BufferedReader inFromServer;

    public static void main(String argv[]) {
        String ip = "localhost"; // argv[0]
        int port = 6789; // argv[1]
        new TCPClient(ip, port).start();
    }

    public TCPClient(String ip, int port) {
        try {
            this.clientSocket = new Socket(ip, port);
            initializeBuffers();
        } catch (Exception e) {
        }
    }

    public void start() {

        String serverResponse = "";
        do {
            try {
                String line = inFromUser.readLine();
                outToServer.println(line);
                outToServer.flush();

                if(clientSocket.isClosed()) break;

                serverResponse = inFromServer.readLine();
                System.out.println("FROM SERVER: " + serverResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (noInShutdown(serverResponse));
        closeAll();
    }

    private boolean noInShutdown(String serverResponse) {
        return !(serverResponse.equals(ServerStringProcessing.SHUTDOWN) ||
                serverResponse.equals(ServerStringProcessing.CONNECTION_CLOSE));
    }

    private void initializeBuffers() {
        try {
            this.inFromUser = new BufferedReader(new InputStreamReader(System.in));
            this.outToServer = new PrintWriter(clientSocket.getOutputStream());
            this.inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {

        }
    }

    private void closeAll() {
        try {
            this.clientSocket.close();
            this.inFromUser.close();
            this.outToServer.close();
            this.inFromServer.close();
        } catch (IOException e) {

        }
    }

}