package org.example.lesson;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleHttpServer {
    public static void main(String[] args) {
        try {
            // 127.0.0.1:8080 или localhost:8080
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
            httpServer.createContext("/", httpExchange -> {
                Path filePath = Path.of("src/main/resources/hello.html");
                if (Files.exists(filePath)) {
                    String htmlContent = Files.readString(filePath);
                    httpExchange.getResponseHeaders().add("Content-Type", "text/html");
                    httpExchange.sendResponseHeaders(200, htmlContent.getBytes().length);

                    try (OutputStream outputStream = httpExchange.getResponseBody()) {
                        outputStream.write(htmlContent.getBytes());
                    }
                } else {
                    String message = "NOT FOUND";
                    try (OutputStream outputStream = httpExchange.getResponseBody()) {
                        outputStream.write(message.getBytes());
                    }
                }
            });
            httpServer.start();
            System.out.println("Сервер запущен");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
