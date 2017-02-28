package cz.marek_b.chat.bean;

import java.io.Serializable;
import java.util.UUID;

public class UUIDResponse extends Response implements Serializable {

    private static final long serialVersionUID = -5114196324298671641L;

    private final UUID uuid;

    public UUIDResponse(String command, UUID uuid) {
        super(command);
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

}
