package cz.marek_b.chat.command;

import com.google.gson.Gson;
import cz.marek_b.chat.bean.MessageRequest;
import cz.marek_b.chat.bean.UUIDResponse;
import cz.marek_b.chat.service.ChatService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.Session;

@Stateless
public class GetUUIDCommand implements Command {
    public static final String COMMAND_NAME = "getUUID";

    @EJB
    private ChatService chatService;
    
    private final Gson gson = new Gson();
    
    @Override
    public void execute(Session senderSession, List<Session> receiversSessions, MessageRequest request) {
        senderSession.getAsyncRemote()
            .sendObject(gson.toJson(new UUIDResponse(COMMAND_NAME, chatService.generateClientUUID())));
    }
    
}
