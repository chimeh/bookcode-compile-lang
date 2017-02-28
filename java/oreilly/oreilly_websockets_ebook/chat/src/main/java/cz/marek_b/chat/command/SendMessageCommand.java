package cz.marek_b.chat.command;

import com.google.gson.Gson;
import cz.marek_b.chat.bean.MessageRequest;
import cz.marek_b.chat.bean.MessageResponse;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.websocket.Session;

@Stateless
public class SendMessageCommand implements Command {
    private static final Logger LOG = Logger.getLogger(SendMessageCommand.class.getName());

    public static final String COMMAND_NAME = "message";
    
    private final Gson gson = new Gson();
    
    @Override
    public void execute(Session senderSession, List<Session> sessions, MessageRequest request) {
        MessageResponse response = new MessageResponse(
                COMMAND_NAME, request.getName(),
                request.getMessage(), request.getUuid());
        for (Session session : sessions) {
            session.getAsyncRemote().sendObject(gson.toJson(response));
        }
    }
    
}
