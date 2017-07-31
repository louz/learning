package io.jasonlu.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by jiehenglu on 17/06/10.
 */
public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8888)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();

            while (!line.equals("exit")) {
                System.out.println("== input :" + line);
                socket.getOutputStream().write((line + "\r\n").getBytes());
                socket.getOutputStream().flush();
                line = reader.readLine();
            }

            reader.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
