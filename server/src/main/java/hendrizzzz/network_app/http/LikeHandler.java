package hendrizzzz.network_app.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class LikeHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();

        switch (requestMethod) {
            case "POST" -> ;
            case "GET" -> ;
            case "PUT" -> ;
            case "DELETE" -> ;
        }
    }
}
