package server;

import java.io.*;
import java.net.Socket;

/**
 * Created by sacry on 05/04/14.
 */
public class TCPServerThread extends Thread {

    private Socket client;
    private InputStreamReader inputStream;
    private OutputStream outputStream;

    public static final String SHUTDOWN = "SHUTDOWN";
    public static final String CONNECTION_CLOSE = "CONNECTION_CLOSE";

    public TCPServerThread(Socket client) {
        this.client = client;
    }

    public void run() {

        String clientSentence = "";
        setUp();

        do {

            String line = readFromClient();
            System.out.println("Thread:Read= " + line);
            clientSentence = ServerStringProcessing.work(line);
            sendToClient(clientSentence);

        } while (!isConnectionClosed(clientSentence));

        closeAll();
        System.out.println();
    }

    private void setUp() {
        try {
            inputStream = new InputStreamReader(client.getInputStream());
            outputStream = client.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeAll() {
        try {
            inputStream.close();
            outputStream.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean isConnectionClosed(String resp) {
        return resp.equals(CONNECTION_CLOSE) || resp.equals(SHUTDOWN);
    }

    String readFromClient() {

        int read;
        byte[] byteArray = new byte[255];
        boolean keepGo = true;

        for (int i = 0; i < byteArray.length && keepGo; i++) {
            try {
                read = inputStream.read();
                if (read == -1 || read == 10) {
                    keepGo = false;
                } else {
                    byteArray[i] = (byte) read;
                }
            } catch (IOException e) {
                keepGo = false;
            }
        }

        try {
            return (new String(byteArray, "UTF-8")).trim();
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    void sendToClient(String message) {
        try {
            byte[] byteArray = (message + "\n").getBytes("UTF-8");
            outputStream.write(byteArray, 0, byteArray.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
