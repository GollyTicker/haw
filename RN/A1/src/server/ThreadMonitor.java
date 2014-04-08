package server;

/**
 * Created by sacry on 08/04/14.
 */
public class ThreadMonitor {

    private static volatile int count = 0;
    private static volatile boolean isRunning = true;

    private ThreadMonitor() {
    }

    public static boolean serverShouldBeRunning(int N) {
        return count < N && isRunning();
    }

    public static void increase() {
        count += 1;
    }

    public static int getCount() {
        return count;
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static void shutdownSignal() {
        isRunning = false;
    }
}
