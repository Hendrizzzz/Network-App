package hendrizzzz.network_app.dao;

import exception.NoChangeException;
import hendrizzzz.network_app.model.User;

import java.sql.*;
import java.time.LocalDate;

public class UserDao {

    public void addUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addUser)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getHashedPassword());

            statement.executeUpdate();
        }
//        catch (SQLIntegrityConstraintViolationException e) {
//            throw new DuplicateUserException("Error: Username already exists! ");
//        }
        catch (SQLException e) {
            throw new RuntimeException(e); // TODO : to be improved
        }
    }


    public int changeUsername(String username, String newUsername) throws NoChangeException {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.changeUsername)) {

            statement.setString(1, newUsername);
            statement.setString(2, username);

            return statement.executeUpdate();
//            if (affectedRows == 0)
//                throw new NoChangeException("Your username is already " + newUsername);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int changeFirstName(String username, String newFirstName) throws NoChangeException {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.changeFirstName)) {

            statement.setString(1, newFirstName);
            statement.setString(2, username);

            return statement.executeUpdate();
//            if (affectedRows == 0)
//                throw new NoChangeException("Your first name is already " + newFirstName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int changeLastName(String username, String newLastName) throws NoChangeException {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.changeLastName)) {

            statement.setString(1, newLastName);
            statement.setString(2, username);

            return statement.executeUpdate();
//            if (affectedRows == 0)
//                throw new NoChangeException("Your last name is already " + newLastName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int changePassword(String username, String newPassword) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.changePassword)) {

            statement.setString(1, newPassword);
            statement.setString(2, username);

            return statement.executeUpdate();
//            if (affectedRows == 0)
//                throw new NoChangeException("Your password is the same. ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String getHashedPassword(String username) {
        String hashedPassword;
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.getHashedPassword)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getString("hashed_password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public int changeBirthDate(String username, LocalDate birthdate) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.changeBirthDate)) {

            statement.setDate(1, Date.valueOf(birthdate));
            statement.setString(2, username);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String getFirstName(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.getFirstName)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getString("first_name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public String getLastName(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.getLastName)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getString("last_name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public LocalDate getBirthDate(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.getBirthDate)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getDate("birthday").toLocalDate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    public int getFriendsCount(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.getFriendsCount)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getInt("friends_count");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }


    public User getUser(String username) {
        return new User();
    }


    public char getUserCommentSettings(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.getCommentSettings)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getString("who_can_comment").charAt(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return '0'; // invalid
    }


    public char getUserFriendRequestsSettings(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.getFriendRequestSettings)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getString("who_can_send_friend_requests").charAt(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return '0'; // invalid
    }


    public int changeUserCommentSettings(String username, char newCommentSettings) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.changeUserCommentSettings)) {

            statement.setString(1, String.valueOf(newCommentSettings));
            statement.setString(2, username);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int changeUserFriendRequestsSettings(String username, char newFriendRequestSettings) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.changeUserFriendRequestSettings)) {

            statement.setString(1, String.valueOf(newFriendRequestSettings));
            statement.setString(2, username);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public LocalDate getJoinDate(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.getJoinDate)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getDate("join_date").toLocalDate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public int getAge(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.getAge)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getInt("age");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }


    public char getGender(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.getGender)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getString("gender").charAt(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return '0'; // invalid
    }



}
