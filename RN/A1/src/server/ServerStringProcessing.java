package server;

import java.util.ArrayList;

/**
 * Created by sacry on 05/04/14.
 */
public class ServerStringProcessing {

    public static final String SHUTDOWN = "SHUTDOWN";
    public static final String CONNECTION_CLOSE = "CONNECTION_CLOSE";
    private static final String DEFAULT = "Please provide a reasonbale Operation!";

    private ServerStringProcessing() {
    }

    public static String work(String line) {
        line = normalize(line);
        if (line == null) {
            return DEFAULT;
        }
        if (line.startsWith(SHUTDOWN)) {
            return SHUTDOWN;
        }
        if (line.startsWith(CONNECTION_CLOSE)) {
            return CONNECTION_CLOSE;
        }
        if (line.startsWith("REVERSE")) {
            return reverse(get(line, line.indexOf(' '), line.length()));
        }
        if (line.startsWith("LOWERCASE")) {
            return get(line, line.indexOf(' '), line.length()).toLowerCase();
        }
        if (line.startsWith("UPPERCASE")) {
            return get(line, line.indexOf(' '), line.length()).toUpperCase();
        } else {
            return DEFAULT;
        }
    }

    private static String reverse(String line) {
        return new StringBuffer(line).reverse().toString();
    }

    private static String get(String line, int i, int j) {
        return line.trim().substring(i, j);
    }

    private static String normalize(String line) {
        if (line != null) {
            return line.trim();
        }
        return line;
    }

}
