package hendrizzzz.network_app.model;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private int postId;
    private int authorId;
    private String content;
    private LocalDateTime timeStamp;

    public Comment(int id, int postId, int authorId, String content, LocalDateTime timeStamp) {
        this.id = id;
        this.postId = postId;
        this.authorId = authorId;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public Comment(int postId, int authorId, String content, LocalDateTime timeStamp) {
        this.postId = postId;
        this.authorId = authorId;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
