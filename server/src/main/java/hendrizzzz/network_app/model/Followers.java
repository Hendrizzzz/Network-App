package hendrizzzz.network_app.model;

import java.time.LocalDateTime;

public class Followers {
    private int userId;
    private int followerId;
    private LocalDateTime timeStamp;


    public Followers(int userId, int followerId, LocalDateTime timeStamp) {
        this.userId = userId;
        this.followerId = followerId;
        this.timeStamp = timeStamp;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
