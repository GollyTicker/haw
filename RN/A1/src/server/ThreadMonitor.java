package server;

import java.net.Socket;
import java.util.Iterator;

/**
 * Created by sacry on 08/04/14.
 */
public class ThreadMonitor {

    private static final int N = 400;
    private static volatile int count = 0;
    private static volatile boolean isRunning = true;

    private ThreadMonitor() {
    }

    public static void execute(Socket clientSocket) {
        if (count < N) {
            increase();
            new TCPServerThread(clientSocket).run();
        }
    }

    public static void increase() {
        count += 1;
    }

    public static void decrease() {
        count -= 1;
    }

    public static boolean serverShouldBeRunning() {
        return count < N && isRunning;
    }

    public static void shutdownSignal() {
        isRunning = false;
    }
}
