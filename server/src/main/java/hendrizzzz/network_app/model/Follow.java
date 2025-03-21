package hendrizzzz.network_app.model;

import java.time.LocalDateTime;

public class Follow {
    private int followeeId;
    private int followerId;
    private LocalDateTime timeStamp;


    public Follow(int followeeId, int followerId, LocalDateTime timeStamp) {
        this.followeeId = followeeId;
        this.followerId = followerId;
        this.timeStamp = timeStamp;
    }

    public Follow(int followeeId, int followerId) {
        this.followeeId = followeeId;
        this.followerId = followerId;
    }


    public int getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(int followeeId) {
        this.followeeId = followeeId;
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
