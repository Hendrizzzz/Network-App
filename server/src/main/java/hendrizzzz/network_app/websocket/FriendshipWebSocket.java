package hendrizzzz.network_app.websocket;

import com.google.gson.Gson;
import hendrizzzz.network_app.model.WebSocketMessage;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/friendship")
public class FriendshipWebSocket {
    @OnOpen
    public void onOpen(Session session) {

    }


    @OnClose
    public void onClose(Session session) {

    }


    @OnMessage
    public void onMessage(Session session, String request) {
        Gson gson = new Gson();
        WebSocketMessage message = gson.fromJson(request, WebSocketMessage.class);
        String type = message.getType();

        switch (type) {
            case "add message" -> {
                int senderId = (int) message.getData().get("sender id");
                int receiverId = (int) message.getData().get("receiver id");
                String contents = (String) message.getData().get("contents");

            }
        }
    }
}
