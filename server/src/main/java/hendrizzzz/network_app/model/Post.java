package hendrizzzz.network_app.model;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private int authorId;
    private String contents;
    private LocalDateTime datePosted;
    private char privacy;
    private int commentCount;

    public Post(int id, int authorId, String contents, LocalDateTime datePosted, char privacy, int commentCount) {
        this.id = id;
        this.authorId = authorId;
        this.contents = contents;
        this.datePosted = datePosted;
        this.privacy = privacy;
        this.commentCount = commentCount;
    }

    public Post(int authorId, String contents, LocalDateTime datePosted, char privacy) {
        this.authorId = authorId;
        this.contents = contents;
        this.datePosted = datePosted;
        this.privacy = privacy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public char getPrivacy() {
        return privacy;
    }

    public void setPrivacy(char privacy) {
        this.privacy = privacy;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
