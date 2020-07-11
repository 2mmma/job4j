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
                    String str = in.readLine();
                    if (!str.isEmpty()) {
                        String[] line = str.split(" ");
                        int index = line[1].lastIndexOf('=');
                        String argument = line[1].substring(index + 1);
                        String answer;
                        if (argument.equals("Exit")) {
                            answer = "Disconnected";

                            check = false;
                        } else {
                            answer = argument;
                        }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write((answer + "\r\n\r\n").getBytes());
                        System.out.println(answer);
                    }
                }
            }
        }
    }
}

