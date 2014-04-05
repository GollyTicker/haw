package client;

/**
 * Created by sacry on 05/04/14.
 */

import server.ServerStringProcessing;

import java.io.*;
import java.net.*;

class TCPClient {

    private String ip;
    private int port;

    private Socket clientSocket;
    private BufferedReader inFromUser;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;

    public static void main(String argv[]) {
        String ip = "localhost";
        int port = 6789;
        new TCPClient(ip, port).start();
    }

    public TCPClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
        try {
            this.clientSocket = new Socket(ip, port);
            initializeBuffers();
        } catch (Exception e) {
        }
    }

    public void start() {
        String sentence = "";
        String serverResponse = "";
        do {
            try {
                sentence = inFromUser.readLine();
                outToServer.writeBytes(sentence + '\n');
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
            this.outToServer = new DataOutputStream(clientSocket.getOutputStream());
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