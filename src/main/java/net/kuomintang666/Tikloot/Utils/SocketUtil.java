package net.kuomintang666.Tikloot.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtil {
    /**
     * 
     * @param soc the socket need get ip
     * @return what host the socket connect
     */
    public static String getIP(Socket soc) {
        return soc.getInetAddress().getHostName();
    }

    /**
     * 
     * @return the port can be used
     * @throws IOException
     */
    public static int getFreePort() throws IOException {
        ServerSocket socket = new ServerSocket(0);
        int port = socket.getLocalPort();
        socket.close();
        return port;
    }

    /**
     * 
     * @param port the port need check
     * @return is the port used
     */
    public static boolean isPortUsed(int port) {
        try {
            Socket socket = new Socket("localhost", port);
            socket.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
