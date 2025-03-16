package hendrizzzz.network_app.dao;

import hendrizzzz.network_app.model.Followers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FollowersDao {


    public void addFollowers(Followers followers) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addFollowers)) {

            statement.setInt(1, followers.getUserId());
            statement.setInt(2, followers.getFollowerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeFollowers(Followers followers) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.removeFollower)) {

            statement.setInt(1, followers.getUserId());
            statement.setInt(2, followers.getFollowerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
