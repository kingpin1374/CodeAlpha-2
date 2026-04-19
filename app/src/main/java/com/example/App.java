public class App {
    // Add this method so the test can find it
    public String getGreeting() {
        return "Hello from your Automated Java Pipeline!";
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        App app = new App(); // Create instance to call the method
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        server.createContext("/", (exchange -> {
            String response = app.getGreeting(); // Use the method here
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
