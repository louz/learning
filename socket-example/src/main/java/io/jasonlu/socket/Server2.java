package io.jasonlu.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            Socket socket = server.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println(" input : " + line);
            while (line != null) {
                System.out.println("==== line " + line);
                line = reader.readLine();
            }

//            reader.close();
//            socket.close();
        }
    }
}
