package hendrizzzz.network_app.websocket;


import com.google.gson.Gson;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/follow")
public class FollowWebSocket {
    @OnOpen
    public void onOpen(Session session) {

    }


    @OnClose
    public void onClose(Session session) {

    }


    @OnMessage
    public void onMessage(Session session, String request) {
        Gson gson = new Gson(request).to;
        gson
    }
}
