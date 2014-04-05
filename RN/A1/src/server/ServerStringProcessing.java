package server;

import java.util.ArrayList;

/**
 * Created by sacry on 05/04/14.
 */
public class ServerStringProcessing {

    private ServerStringProcessing() {
    }

    public static String work(String line) {
        if (line == null) {
            return line;
        }
        String command = get(line, 0, line.indexOf(' '));
        String restLine = get(line, line.indexOf(' '), line.length());
        if (command.equals("REVERSE")) {
            return reverse(restLine);
        }
        if (command.equals("LOWERCASE")) {
            return restLine.toLowerCase();
        }
        if (command.equals("UPPERCASE")) {
            return restLine.toUpperCase();
        }
        return line;
    }

    public static String reverse(String line) {
        return new StringBuffer(line).reverse().toString();
    }

    private static String get(String line, int i, int j) {
        return line.trim().substring(i, j);
    }

}
