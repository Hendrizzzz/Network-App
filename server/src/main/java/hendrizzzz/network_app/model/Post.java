package hendrizzzz.network_app.model;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private int authorId;
    private String contents;
    private LocalDateTime datePosted;
    private Character privacy;
    private int commentCount;

    public Post(int id, int authorId, String contents, LocalDateTime datePosted, Character privacy, int commentCount) {
        this.id = id;
        this.authorId = authorId;
        this.contents = contents;
        this.datePosted = datePosted;
        this.privacy = privacy;
        this.commentCount = commentCount;
    }

    public Post(int authorId, String contents, LocalDateTime datePosted, Character privacy) {
        this.authorId = authorId;
        this.contents = contents;
        this.datePosted = datePosted;
        this.privacy = privacy;
    }

    public Post(int authorId, String contents, Character privacy) {
        this.authorId = authorId;
        this.contents = contents;
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

    public Character getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Character privacy) {
        this.privacy = privacy;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
