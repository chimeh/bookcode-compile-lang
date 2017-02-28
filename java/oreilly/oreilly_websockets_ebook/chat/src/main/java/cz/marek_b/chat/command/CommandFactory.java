package cz.marek_b.chat.command;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CommandFactory {
    
    @EJB(beanName = "GetUUIDCommand")
    private Command getUUIDCommand;
    @EJB(beanName = "SendMessageCommand")
    private Command sendMessageCommand;
    
    public Command getCommand(String command) {
        if (null != command) { // todo lip
            switch (command) {
                case GetUUIDCommand.COMMAND_NAME:
                    return getUUIDCommand;
                case SendMessageCommand.COMMAND_NAME:
                    return sendMessageCommand;
            }
        }
        
        throw new UnsupportedOperationException("Command not supported!");
    }
    
}
