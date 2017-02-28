package cz.marek_b.chat.endpoint;

import com.google.gson.Gson;
import cz.marek_b.chat.bean.Request;
import cz.marek_b.chat.command.CommandFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Singleton
@ServerEndpoint("/chatEndpoint")
public class ChatEndpoint {

    private static final Logger LOG = Logger.getLogger(ChatEndpoint.class.getName());
    
    @EJB
    private CommandFactory commandFactory;
    
    private final Gson gson = new Gson();
    private final List<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }
    
    @OnMessage
    public void onMessage(Session session, String message) {
        Request messageObj = gson.fromJson(message, Request.class);
        commandFactory.getCommand(messageObj.getCommand())
            .execute(session, sessions, messageObj.getData());
    }
    
}
