package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

/**
 * Created by sacry on 08/04/14.
 */
public class ThreadMonitor {

    private static final int N = 50;
    private static volatile int count = 0;
    public static volatile boolean isRunning = true;

    private ThreadMonitor() {
    }

    public static void execute(Socket clientSocket, ServerSocket listener) {
        ThreadMonitor.increase();
        TCPServerThread t = new TCPServerThread(clientSocket, listener);
        System.out.println("Thread created: " + t.getId());
        t.start();
    }

    public static void increase() {
        count += 1;
    }

    public static boolean canCreateMoreThreads() {
        return count < N && isRunning;
    }

    public static void decrease() {
        count -= 1;
    }

    public static void shutdownSignal() {
        isRunning = false;
    }

}
