package hendrizzzz.network_app.model;

import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String hashedPassword;
    private byte age;
    private LocalDate birthDate;
    private char gender;
    private int friendsCount;
    private LocalDate joinDate;
    private char whoCanSendFriendRequests;
    private char whoCanComment;

    public User(int id, String firstName, String lastName, String username, String hashedPassword, byte age, LocalDate birthDate, char gender, int friendsCount, LocalDate joinDate, char whoCanSendFriendRequests, char whoCanComment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
        this.friendsCount = friendsCount;
        this.joinDate = joinDate;
        this.whoCanSendFriendRequests = whoCanSendFriendRequests;
        this.whoCanComment = whoCanComment;
    }


    public User(int id, String firstName, String lastName, String username, String hashedPassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public User(String firstName, String lastName, String username, String hashedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public User(String hashedPassword, String username, String lastName, String firstName, byte age, char gender) {
        this.hashedPassword = hashedPassword;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public LocalDate getJoinDate() {
        return joinDate;

    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public char getWhoCanSendFriendRequests() {
        return whoCanSendFriendRequests;
    }

    public void setWhoCanSendFriendRequests(char whoCanSendFriendRequests) {
        this.whoCanSendFriendRequests = whoCanSendFriendRequests;
    }

    public char getWhoCanComment() {
        return whoCanComment;
    }

    public void setWhoCanComment(char whoCanComment) {
        this.whoCanComment = whoCanComment;
    }
}
