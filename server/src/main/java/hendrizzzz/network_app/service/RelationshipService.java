package hendrizzzz.network_app.service;

import exception.DuplicateModelException;
import exception.FriendshipNotFoundException;
import exception.NoChangeException;
import hendrizzzz.network_app.dao.FollowersDao;
import hendrizzzz.network_app.dao.FriendshipDao;
import hendrizzzz.network_app.model.Follow;
import hendrizzzz.network_app.model.Friendship;

public class RelationshipService {
    private FollowersDao followDao;
    private FriendshipDao friendshipDao;


    public RelationshipService(FollowersDao followDao, FriendshipDao friendshipDao) {
        this.followDao = followDao;
        this.friendshipDao = friendshipDao;
    }


    public void addFriendship(int user_id, int other_user_id, String status) {
        validateFriendshipDetails(user_id, other_user_id, status);

        int friend1 = Math.min(user_id, other_user_id);
        int friend2 = Math.max(user_id, other_user_id);

        Friendship newFriendship = new Friendship(friend1, friend2, status);
        try {
            friendshipDao.addFriendship(newFriendship);
        } catch (DuplicateModelException e) {
            // TODO : log it
            throw e;
        }
    }


    public void updateFriendship(int user_id, int other_user_id, String newStatus) {
        validateFriendshipDetails(user_id, other_user_id, newStatus);

        int friend1 = Math.min(user_id, other_user_id);
        int friend2 = Math.max(user_id, other_user_id);

        Friendship newFriendship = new Friendship(friend1, friend2, newStatus);
        int affectedRows = friendshipDao.updateFriendship(newFriendship);

        if (affectedRows == 0)
            throw new FriendshipNotFoundException("No existing friendship between user " + user_id + " and " + other_user_id);
    }

    private void validateFriendshipDetails(int user_id, int other_user_id, String newStatus) {
        if (user_id < 1) throw new IllegalArgumentException("user_id cannot be negative.");
        if (other_user_id < 1) throw new IllegalArgumentException("other_user_id cannot be negative. ");
        if (user_id == other_user_id) throw new IllegalArgumentException("A user cannot be friends with themselves.");
        if (newStatus == null || newStatus.isBlank()) throw new IllegalArgumentException("status cannot be empty.");
    }


    private void removeFriendship(int user_id, int other_user_id) {
        int friend1 = Math.min(user_id, other_user_id);
        int friend2 = Math.max(user_id, other_user_id);

        int affectedRows = friendshipDao.removeFriendship(friend1, friend2);
        if (affectedRows == 0)
            throw new FriendshipNotFoundException("No existing friendship between user " + user_id + " and " + other_user_id);
    }


    private void addFollowers(int followeeId, int followerId) {
        Follow follow = new Follow(followeeId, followerId);
        
        try {
            followDao.addFollow(follow);
        } catch (DuplicateModelException e) {
            // TODO : log it
            throw e;
        }
    }
    
    
    public void removeFollow(int followeeId, int followerId) {
        Follow follow = new Follow(followeeId, followerId);
        followDao.removeFollow(follow);
    }


}
