package hendrizzzz.network_app.model;

public class Notification {
    private int id;
    private int userId;
    private String notificationType;
    private String contents;
    private int likeId;
    private int commentId;
    private int friendRequestSenderId;
    private int message_id;
    private boolean isRead;

    public Notification(int userId, String notificationType, String contents, int likeId, int commentId, int friendRequestSenderId, int message_id, boolean isRead) {
        this.userId = userId;
        this.notificationType = notificationType;
        this.contents = contents;
        this.likeId = likeId;
        this.commentId = commentId;
        this.friendRequestSenderId = friendRequestSenderId;
        this.message_id = message_id;
        this.isRead = isRead;
    }

    public Notification(int id, int userId, String notificationType, String contents, int likeId, int commentId, int friendRequestSenderId, int message_id, boolean isRead) {
        this.id = id;
        this.userId = userId;
        this.notificationType = notificationType;
        this.contents = contents;
        this.likeId = likeId;
        this.commentId = commentId;
        this.friendRequestSenderId = friendRequestSenderId;
        this.message_id = message_id;
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getFriendRequestSenderId() {
        return friendRequestSenderId;
    }

    public void setFriendRequestSenderId(int friendRequestSenderId) {
        this.friendRequestSenderId = friendRequestSenderId;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
