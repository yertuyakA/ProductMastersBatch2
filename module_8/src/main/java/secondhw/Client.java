package main.java.secondhw;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        System.out.println(in.readLine());
        String login = scanner.nextLine();
        out.println(login);

        System.out.println(in.readLine());
        String password = scanner.nextLine();
        out.println(password);

        String authResponse = in.readLine();
        System.out.println("Server: " + authResponse);
        if (authResponse.contains("Incorrect")) {
            socket.close();
            return;
        }

        Timer timer = new Timer(true);
        TimerTask timeoutTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("Timeout: closing connection for user " + login);
                    socket.close();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timeoutTask, 30000);

        try {
            while (true) {
                System.out.print("Client: ");
                String msg = scanner.nextLine();
                out.println(msg);

                timeoutTask.cancel();
                timeoutTask = new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Timeout: closing connection for user " + login);
                            socket.close();
                            System.exit(0);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                timer.schedule(timeoutTask, 30000);

                String response = in.readLine();
                if (response == null) break;
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            System.out.println("Отключено от сервера.");
        } finally {
            timer.cancel();
            socket.close();
        }
    }
}

