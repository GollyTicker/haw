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

    public TCPServerThread(Socket client) {
        this.client = client;
    }

    public void run() {

        String clientSentence = "";
        setUp();

        if (!client.isClosed()) {
            do {

                String line = readFromClient();
                if (line == null)
                    break;
                System.out.println("Thread:Read= " + line);
                clientSentence = ServerStringProcessing.work(line);
                sendToClient(clientSentence);

            } while (!isConnectionClosed(clientSentence));

            closeAll();
        }
        System.out.println("Thread Killed");
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

    private boolean isConnectionClosed(String resp) {
        return resp.equals(ServerStringProcessing.CONNECTION_CLOSE) ||
                resp.equals(ServerStringProcessing.SHUTDOWN) ||
                client.isClosed() ||
                !client.isConnected();
    }

    private String readFromClient() {

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

    private void sendToClient(String message) {
        try {
            if (!client.isClosed()) {
                byte[] byteArray = (message + "\n").getBytes("UTF-8");
                outputStream.write(byteArray, 0, byteArray.length);
            }
        } catch (IOException e) {
            closeAll();
        }
    }

}
