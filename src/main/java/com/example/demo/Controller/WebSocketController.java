package com.example.demo.Controller;
import com.example.demo.Model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

//ws://localhost:8081/admin
@ServerEndpoint("/admin")
public class WebSocketController {

    private Session session;
    private static Set<WebSocketController> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users  = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        String username = "test";
        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        broadcast(new Message("Server", username, "Connected"));
    }
    @OnMessage
    public void onMessage(Session session, Message message) {
        // Handle new messages
    }
    @OnClose
    public void onClose(Session session) {
        chatEndpoints.remove(this);
        Message message = new Message("Server", users.get(session.getId()), "Disconnected");
        broadcast(message);
    }
    @OnError
    public void onError(Session session, Throwable throwable) {
        Message message = new Message("Server", users.get(session.getId()), throwable.getMessage());
        broadcast(message);
    }

    private static void broadcast(Message message) {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().sendObject(message);
                } catch (Exception ex) {
                    //cry
                }
            }
        });
    }

    private static void privateMessage(Message message) {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                if(users.get(endpoint.session.getId()) == message.to){
                    try {
                        endpoint.session.getBasicRemote().sendObject(message);
                    } catch (Exception ex){
                        //cry
                    }
                }

            }
        });
    }
}
