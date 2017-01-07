package io.jasonlu.socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Louz on 2016/8/26.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            Socket socket = server.accept();

            BufferedInputStream in = new BufferedInputStream(Server.class.getResourceAsStream("/longText.txt"));

            byte[] buffer = new byte[1024 * 10];
            int count = 0;
            while ((count = in.read(buffer)) != -1) {
                socket.getOutputStream().write(buffer, 0, count);
            }

            socket.getOutputStream().flush();

            in.close();
            socket.close();
        }
    }
}
