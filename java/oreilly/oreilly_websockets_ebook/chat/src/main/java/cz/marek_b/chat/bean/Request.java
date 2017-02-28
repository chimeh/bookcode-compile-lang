package cz.marek_b.chat.bean;

public class Request {

    private String command;
    private MessageRequest data;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public MessageRequest getData() {
        return data;
    }

    public void setData(MessageRequest data) {
        this.data = data;
    }

}
