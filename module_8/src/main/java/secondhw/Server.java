package main.java.secondhw;

import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Server {
    private static final Map<String, String> users = new HashMap<>();
    static {
        users.put("user1", "1234");
        users.put("admin", "admin");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345:");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter login:");
            String login = in.readLine();
            out.println("Enter password:");
            String password = in.readLine();

            if (!users.containsKey(login) || !users.get(login).equals(password)) {
                out.println("Incorrect password. Disconnecting");
                socket.close();
                System.out.println("Client failed authentication, connection closed.");
                continue;
            }

            out.println("Welcome, " + login + "!");

            Timer timer = new Timer(true);
            TimerTask timeoutTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        System.out.println("Timeout: closing connection for user " + login);
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.schedule(timeoutTask, 30000);

            try {
                String input;
                while ((input = in.readLine()) != null) {
                    timeoutTask.cancel();
                    timeoutTask = new TimerTask() {
                        @Override
                        public void run() {
                            try {
                                System.out.println("Timeout: closing connection for user " + login);
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timer.schedule(timeoutTask, 30000);

                    System.out.println(login + ": " + input);

                    if ("/time".equalsIgnoreCase(input)) {
                        out.println(LocalTime.now());
                    } else {
                        out.println("Unknown command");
                    }
                }
            } catch (IOException e) {
                System.out.println("Client " + login + " disconnected.");
            } finally {
                timer.cancel();
                socket.close();
            }
        }
    }
}

