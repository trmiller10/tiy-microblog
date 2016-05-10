public class Message {

    // TODO: create a property "text" to hold the text of a message
    private String messageText;

    // TODO: create a constructor for Message that accepts one argument, the text of the message
    public Message(String messageText) {

        this.messageText = messageText;
    }

    // TODO: create a getText method
    public String getMessageText() {

        return messageText;
    }

    // TODO: create a setText method
    public void setMessageText(String messageText) {

        this.messageText = messageText;
    }
}
