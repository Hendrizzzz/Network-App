package hendrizzzz.network_app.dao;

import exception.DuplicateModelException;
import hendrizzzz.network_app.model.Follow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class FollowersDao {


    public void addFollow(Follow follow) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addFollowers)) {

            statement.setInt(1, follow.getFolloweeId());
            statement.setInt(2, follow.getFollowerId());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicateModelException("Error: Follow already exists!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeFollow(Follow follow) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.removeFollower)) {

            statement.setInt(1, follow.getFolloweeId());
            statement.setInt(2, follow.getFollowerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
