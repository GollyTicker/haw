package client;

/**
 * Created by sacry on 05/04/14.
 */

import server.ServerStringProcessing;
import server.TCPServerThread;

import java.io.*;
import java.net.*;

class TCPClient {

    public static void main(String argv[]) throws Exception {
        Socket clientSocket = new Socket("localhost", 6789);
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        clientStart(clientSocket, inFromUser);
    }

    private static void clientStart(Socket clientSocket, BufferedReader inFromUser) throws Exception {
        String sentence, serverResponse;
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        do {
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            serverResponse = inFromServer.readLine();
            System.out.println("FROM SERVER: " + serverResponse);
        }
        while (noInShutdown(serverResponse));
        clientSocket.close();
    }

    private static boolean noInShutdown(String serverResponse) {
        return !(serverResponse.equals(ServerStringProcessing.SHUTDOWN) ||
                serverResponse.equals(ServerStringProcessing.CONNECTION_CLOSE));
    }

}