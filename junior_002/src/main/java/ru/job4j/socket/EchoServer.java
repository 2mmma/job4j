package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean check = true;
            while (check) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    //noinspection CheckStyle
                    while (!(str = in.readLine()).isEmpty()) {
                        if (!str.contains("BYE")) {
                            System.out.println(str);
                        } else {
                            System.out.println("DISCONNECTED");
                            check = false;
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());

                }
            }
        }
    }
}
