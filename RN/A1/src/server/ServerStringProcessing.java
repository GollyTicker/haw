package server;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sacry on 05/04/14.
 */
public class ServerStringProcessing {

    public static final String SHUTDOWN = "SHUTDOWN";
    public static final String CONNECTION_CLOSE = "CONNECTION_CLOSE";
    private static final String DEFAULT = "ERROR! Unknown Operation!";
    private static final String REVERSE = "REVERSE";
    private static final String LOWERCASE = "LOWERCASE";
    private static final String UPPERCASE = "UPPERCASE";


    private ServerStringProcessing() {
    }

    public static String work(String line) {
        line = normalize(line);
        if (inputDoesNotMatch(line)) {
            return DEFAULT;
        }
        if (line.startsWith(SHUTDOWN)) {
            ThreadMonitor.shutdownSignal();
            return SHUTDOWN;
        }
        if (line.startsWith(CONNECTION_CLOSE)) {
            return CONNECTION_CLOSE;
        }
        String scrappedLine = line.substring(line.indexOf(' '), line.length());
        if (line.startsWith(REVERSE)) {
            return reverse(scrappedLine);
        }
        if (line.startsWith(LOWERCASE)) {
            return scrappedLine.toLowerCase();
        }
        if (line.startsWith(UPPERCASE)) {
            return scrappedLine.toUpperCase();
        }
        return line;
    }

    private static String splitOnNewline(String line) {
        int nl = line.indexOf('\\');
        if (nl == -1) {
            return line;
        }
        return line.substring(0, nl - 1);
    }

    private static boolean inputDoesNotMatch(String line) {
        if (line == null) return false;
        return !line.matches("^((REVERSE|LOWERCASE|UPPERCASE) .*|(SHUTDOWN|CONNECTION_CLOSE))");
    }

    private static String reverse(String line) {
        return new StringBuffer(line).reverse().toString();
    }

    private static String normalize(String line) {
        if (line != null) {
            return splitOnNewline(line.trim());
        }
        return line;
    }

}
