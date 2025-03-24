package hendrizzzz.network_app.main;

import com.sun.net.httpserver.HttpServer;
import hendrizzzz.network_app.http.CommentHandler;
import hendrizzzz.network_app.http.LikeHandler;
import hendrizzzz.network_app.http.PostHandler;
import hendrizzzz.network_app.http.UserHandler;
import hendrizzzz.network_app.websocket.FollowWebSocket;
import hendrizzzz.network_app.websocket.FriendshipWebSocket;
import hendrizzzz.network_app.websocket.MessageWebSocket;
import hendrizzzz.network_app.websocket.NotificationWebSocket;
import jakarta.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        // start the http server
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/comment", new CommentHandler());
        httpServer.createContext("/like", new LikeHandler());
        httpServer.createContext("/post", new PostHandler());
        httpServer.createContext("/user", new UserHandler());
        httpServer.start();
        System.out.println("The http server is running");


        // start the websocket server
        Server websocketServer = new Server("localhost", 1234, "/network_app", null,
                FollowWebSocket.class,
                FriendshipWebSocket.class,
                MessageWebSocket.class,
                NotificationWebSocket.class);
        try {
            websocketServer.start();
            System.out.println("The websocket server is running");
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        }
    }
}



