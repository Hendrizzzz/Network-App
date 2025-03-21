package hendrizzzz.network_app.service;

import exception.DuplicateModelException;
import exception.InvalidPasswordException;
import exception.UserNotFoundException;
import hendrizzzz.network_app.dao.UserDao;
import hendrizzzz.network_app.model.User;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void addUser(String username, String firstName, String lastName, String password) {
        validateUserDetails(username, firstName, lastName, password);
        User newUser = new User(firstName, lastName, username, hashPassword(password));
        addUser(newUser);
    }

    private void addUser(User newUser) {
        try {
            userDao.addUser(newUser);
        } catch (DuplicateModelException e) {
            // TODO : log it
            throw e;
        }
    }

    public void addUser(String username, String firstName, String lastName, String password, LocalDate birthDate) {
        validateUserDetails(username, firstName, lastName, password);
        validateBirthDate(birthDate);

        int age = Period.between(birthDate, LocalDate.now()).getYears();
        User newUser = new User(firstName, lastName, username, hashPassword(password), (byte) age, birthDate);
        addUser(newUser);
    }

    public void addUser(String username, String firstName, String lastName, String password, char gender) {
        validateUserDetails(username, firstName, lastName, password);
        User newUser = new User(firstName, lastName, username, hashPassword(password), gender);
        addUser(newUser);
    }

    public void addUser(String username, String firstName, String lastName, String password, char gender, LocalDate birthDate) {
        validateUserDetails(username, firstName, lastName, password);
        validateBirthDate(birthDate);

        int age = Period.between(birthDate, LocalDate.now()).getYears();
        User newUser = new User(firstName, lastName, username, hashPassword(password), gender, (byte) age, birthDate);
        addUser(newUser);
    }

    private void validateUserDetails(String username, String firstName, String lastName, String password) {
        if (username == null || username.isBlank()) throw new IllegalArgumentException("Username cannot be empty.");
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First name cannot be empty.");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be empty.");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password cannot be empty.");
    }

    private void validateBirthDate(LocalDate birthDate) {
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Invalid birthdate.");
    }



    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }


    public void removeUser(String username) {
        int affectedRow = userDao.deleteUser(username);
        if (affectedRow == 0)
            throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public void changeUsername(String username, String newUsername) {
        int affectedRows = userDao.changeUsername(username, newUsername);
        if (affectedRows == 0)
            throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public void changeFirstName(String username, String newFirstName) {
        int affectedRows = userDao.changeFirstName(username, newFirstName);
        if (affectedRows == 0)
            throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public void changeLastName(String username, String newLastName) {
        int affectedRows = userDao.changeLastName(username, newLastName);
        if (affectedRows == 0)
            throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public void changePassword(String username, String inputPassword, String newPassword) {
        String inputHashedPassword = hashPassword(inputPassword);
        String hashedPassword = userDao.getHashedPassword(username);

        if (hashedPassword == null)
            throw new UserNotFoundException("User '" + username + "' not found. ");

        if (hashedPassword.equals(inputHashedPassword))
            userDao.changePassword(username, newPassword);
        else
            throw new InvalidPasswordException("Incorrect password. Please try again.");
    }


    public void changeBirthDate(String username, LocalDate birthdate) {
        int affectedRows = userDao.changeBirthDate(username, Date.valueOf(birthdate));
        if (affectedRows == 0)
            throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public String getFirstName(String username) {
        String firstName = userDao.getFirstName(username);

        if (firstName != null)
            return firstName;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public String getLastName(String username) {
        String lastName = userDao.getLastName(username);

        if (lastName != null)
            return lastName;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public LocalDate getBirthDate(String username) {
        LocalDate birthDate = userDao.getBirthDate(username);

        if (birthDate != null)
            return birthDate;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public int getFriendsCount(String username) {
        int friendsCount = userDao.getFriendsCount(username);

        if (friendsCount != -1)
            return friendsCount;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public char getUserCommentSettings(String username) {
        char commentSettings = userDao.getUserCommentSettings(username);

        if (commentSettings != '0')
            return commentSettings;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public char getFriendRequestSettings(String username) {
        char friendRequestSettings = userDao.getUserFriendRequestsSettings(username);

        if (friendRequestSettings != '0')
            return friendRequestSettings;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public void changeUserCommentSettings(String username, char newCommentSettings) {
        int affectedRows = userDao.changeUserCommentSettings(username, newCommentSettings);

        if (affectedRows == 0)
            throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public void changeUserFriendRequestSettings(String username, char newFriendRequestSettings) {
        int affectedRows = userDao.changeUserFriendRequestsSettings(username, newFriendRequestSettings);

        if (affectedRows == 0)
            throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public LocalDate getJoinDate(String username) {
        LocalDate joinDate = userDao.getJoinDate(username);

        if (joinDate != null)
            return joinDate;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public int getAge(String username) {
        int age = userDao.getAge(username);

        if (age != -1)
            return age;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


    public char gatGender(String username) {
        char gender = userDao.getGender(username);

        if (gender != '0')
            return gender;

        throw new UserNotFoundException("User '" + username + "' not found. ");
    }


}
