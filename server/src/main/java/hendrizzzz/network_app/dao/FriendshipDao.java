package hendrizzzz.network_app.dao;

import exception.DuplicateModelException;
import hendrizzzz.network_app.model.Friendship;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class FriendshipDao {

    public void addFriendship(Friendship friendship) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addFriendship)) {

            statement.setInt(1, friendship.getUserId());
            statement.setInt(2, friendship.getOther_userId());
            statement.setString(3, friendship.getStatus());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicateModelException("Error: Friendship already exists!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int updateFriendship(Friendship updatedFriendship) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.updateFriendship)) {

            statement.setString(1, updatedFriendship.getStatus());
            statement.setInt(2, updatedFriendship.getUserId());
            statement.setInt(3, updatedFriendship.getOther_userId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int removeFriendship(int userId, int otherUserId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.removeFriendship)) {

            statement.setInt(1, userId);
            statement.setInt(2, otherUserId);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
