package cz.marek_b.chat.bean;

import java.io.Serializable;

public class Response implements Serializable {
    
    private static final long serialVersionUID = -7113661488086882921L;

    private final String command;
    
    public Response(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
    
}
