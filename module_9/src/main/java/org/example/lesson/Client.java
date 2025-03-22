package org.example.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Objects;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 7182;


        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Подключаемся...");
            String clientMessage;
            String serverMessage;

            while (true) {
                System.out.print("Клиент: ");
                clientMessage = consoleInput.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Клиент отключился: " + socket.getInetAddress());
                    break;
                }

                serverMessage = in.readLine();
                if (Objects.isNull(serverMessage) || serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Завершаем соединение...");
                    break;
                }

                System.out.println("Сервер: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
