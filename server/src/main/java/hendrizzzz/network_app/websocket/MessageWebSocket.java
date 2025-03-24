package hendrizzzz.network_app.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/message")
public class MessageWebSocket {
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
