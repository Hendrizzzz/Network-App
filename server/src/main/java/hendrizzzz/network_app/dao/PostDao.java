package hendrizzzz.network_app.dao;

import exception.DataAccessException;
import hendrizzzz.network_app.model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDao {


    public void addPost(Post post){
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addPost)) {

            statement.setInt(1, post.getAuthorId());
            statement.setString(2, post.getContents());
            statement.setString(3, String.valueOf(post.getPrivacy()));

            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DataAccessException("Database error occurred");
        }
    }

    public void deletePost(int postId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.deletePost)) {

            statement.setInt(1, postId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred");
        }
    }


    public void updatePost(int postId, String newContents, char privacy) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.updatePost)) {

            statement.setString(1, newContents);
            statement.setString(2, String.valueOf(privacy));
            statement.setInt(3, postId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred");
        }
    }

    public void incrementCommentCount(int postId) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.incrementCommentCount)) {

            statement.setInt(1, postId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred");
        }
    }


    public void decrementCommentCount(int postId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.decrementCommentCount)) {

            statement.setInt(1, postId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred");
        }
    }


    public int getCommentCount(int postId) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.getCommentCount)) {

            statement.setInt(1, postId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                resultSet.getInt("comment_count");
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred");
        }
        return -1; // invalid
    }
}
