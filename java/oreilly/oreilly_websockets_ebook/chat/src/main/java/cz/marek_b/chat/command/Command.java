package cz.marek_b.chat.command;

import cz.marek_b.chat.bean.MessageRequest;
import java.util.List;
import javax.websocket.Session;

public interface Command {
    
    void execute(Session senderSession, List<Session> receiversSessions, MessageRequest request);
    
}
