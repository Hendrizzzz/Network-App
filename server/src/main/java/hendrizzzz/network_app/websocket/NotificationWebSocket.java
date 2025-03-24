package hendrizzzz.network_app.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/notification")
public class NotificationWebSocket {
    @OnOpen
    public void onOpen(Session session) {

    }


    @OnClose
    public void onClose(Session session) {

    }


    @OnMessage
    public void onMessage(Session session, String request) {

    }
}
