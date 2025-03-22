package hendrizzzz.network_app.model;

import java.time.LocalDateTime;

public class Like {
    private int id;
    private boolean isAPost;
    private int user_id_who_liked;
    private LocalDateTime timeStamp;
    private int commentId;
    private int postId;


    public Like(int id, boolean isAPost, int user_id_who_liked, LocalDateTime timeStamp, int commentId, int postId) {
        this.id = id;
        this.isAPost = isAPost;
        this.user_id_who_liked = user_id_who_liked;
        this.timeStamp = timeStamp;
        this.commentId = commentId;
        this.postId = postId;
    }


    public Like(boolean isAPost, int user_id_who_liked, LocalDateTime timeStamp, int commentId, int postId) {
        this.isAPost = isAPost;
        this.user_id_who_liked = user_id_who_liked;
        this.timeStamp = timeStamp;
        this.commentId = commentId;
        this.postId = postId;
    }

    public Like(boolean isAPost, int userIdWhoLiked, int commentOrPostId) {
        this.isAPost = isAPost;
        this.user_id_who_liked = userIdWhoLiked;
        if (isAPost)
            this.postId = commentOrPostId;
        else
            this.commentId = commentOrPostId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAPost() {
        return isAPost;
    }

    public void setAPost(boolean APost) {
        isAPost = APost;
    }

    public int getUser_id_who_liked() {
        return user_id_who_liked;
    }

    public void setUser_id_who_liked(int user_id_who_liked) {
        this.user_id_who_liked = user_id_who_liked;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
