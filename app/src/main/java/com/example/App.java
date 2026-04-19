package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException; // This was likely missing or misspelled
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    
    public String getGreeting() {
        return "Hello from your Automated Java Pipeline!";
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        App app = new App();
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        server.createContext("/", (exchange -> {
            String response = app.getGreeting();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }));
        
        server.setExecutor(null); 
        server.start();
        System.out.println("Server is listening on port " + port);
    }
}
