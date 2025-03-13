package hendrizzzz.network_app.dao;

import exception.NoChangeException;
import hendrizzzz.network_app.model.User;

import java.time.LocalDate;
import java.util.Locale;

public class UserDao {

    public boolean addUser(User user) {
        return true;
    }


    public boolean changeUsername(String username, String newUsername) throws NoChangeException {
        return true;
    }


    public void changeFirstName(String username, String newFirstName) throws NoChangeException {

    }


    public void changeLastName(String username, String newLastName) throws NoChangeException {

    }

    public void changePassword(String username, String newPassword) {

    }


    public String getHashedPassword(String username) {
        return "";
    }


    public void changeBirthDate(String username, LocalDate birthdate) {

    }


    public LocalDate getBirthDate(String username) {
        return null;
    }


    public void setBirthDate(String username, LocalDate birthdate) {

    }


    public int getFriendCount(String username) {
        return 0;
    }


    public User getUser(String username) {
        return new User();
    }


    public char getUserCommentSettings(String username) {
        return 'a';
    }


    public char getUserFriendRequestsSettings(String username) {
        return 'a';
    }


    public void changeUserCommentSettings(String username, char newCommentSettings) {

    }


    public void changeUserFriendRequestsSettings(String username, char newFriendRequestSettings) {

    }






}
