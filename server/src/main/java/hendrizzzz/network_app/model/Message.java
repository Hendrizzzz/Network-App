package hendrizzzz.network_app.model;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private int senderId;
    private int receiverId;
    private String contents;
    private LocalDateTime timeStamp;

    public Message(int id, int senderId, int receiverId, String contents, LocalDateTime timeStamp) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.contents = contents;
        this.timeStamp = timeStamp;
    }

    public Message(int senderId, int receiverId, String contents, LocalDateTime timeStamp) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.contents = contents;
        this.timeStamp = timeStamp;
    }

    public Message(int senderId, int receiverId, String contents) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
