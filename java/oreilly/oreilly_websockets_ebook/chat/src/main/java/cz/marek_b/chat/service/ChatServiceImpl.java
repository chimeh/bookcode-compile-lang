package cz.marek_b.chat.service;

import java.util.UUID;
import javax.ejb.Stateless;

@Stateless
public class ChatServiceImpl implements ChatService {

    @Override
    public UUID generateClientUUID() {
        return UUID.randomUUID();
    }
    
}
