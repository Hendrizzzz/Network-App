package hendrizzzz.network_app.model;

public class Friendship {
    private int userId;
    private int other_userId;
    private String status;


    public Friendship(int userId, int other_userId, String status) {
        this.userId = userId;
        this.other_userId = other_userId;
        this.status = status;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOther_userId() {
        return other_userId;
    }

    public void setOther_userId(int other_userId) {
        this.other_userId = other_userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
