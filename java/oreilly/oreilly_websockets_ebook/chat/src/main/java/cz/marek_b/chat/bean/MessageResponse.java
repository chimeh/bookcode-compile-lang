package cz.marek_b.chat.bean;

import java.io.Serializable;

public class MessageResponse extends Response implements Serializable {

    private static final long serialVersionUID = 6749115254012510969L;

    private final String name;
    private final String message;
    private final String senderClientUUID;

    public MessageResponse(String command, String name, String message, String senderClientUUID) {
        super(command);
        this.name = name;
        this.message = message;
        this.senderClientUUID = senderClientUUID;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderClientUUID() {
        return senderClientUUID;
    }

}
