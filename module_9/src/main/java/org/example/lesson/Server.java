package org.example.lesson;

import java.io.*;
import java.net.*;
import java.util.Objects;

public class Server {
    public static void main(String[] args) {
        int port = 7182;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер включен, ждем соединения...");

            try (Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader consoleInput = new BufferedReader(
                    new InputStreamReader(System.in))) {

                System.out.println("Клиент подкючился: " + clientSocket.getInetAddress());
                String clientMessage;
                String serverMessage;

                while (true) {
                    clientMessage = in.readLine();
                    if (Objects.isNull(clientMessage) || clientMessage.equalsIgnoreCase("exit")) {
                        System.out.println("Клиент отключился: " + clientSocket.getInetAddress());
                        break;
                    }

                    System.out.println("Клиент: " + clientMessage);
                    System.out.print("Сервер: ");
                    serverMessage = consoleInput.readLine();
                    out.println(serverMessage);
                    if (serverMessage.equalsIgnoreCase("exit")) {
                        System.out.println("Завершаем соединение...");
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}