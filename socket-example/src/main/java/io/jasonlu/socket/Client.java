package io.jasonlu.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by Louz on 2016/8/26.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("99.12.203.21", 8888);
        InputStream in = socket.getInputStream();
        int count = 0;
        byte[] buffer = new byte[1];
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        while ((count = in.read(buffer)) != -1) {
            arrayOutputStream.write(buffer, 0, count);
        }

        System.out.println("== Size : " + arrayOutputStream.size());
        System.out.println("== Content: " + arrayOutputStream.toString("UTF-8"));
    }
}
