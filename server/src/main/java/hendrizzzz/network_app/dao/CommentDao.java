package hendrizzzz.network_app.dao;

import exception.DataAccessException;
import hendrizzzz.network_app.model.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDao {
    private static final Logger logger = LogManager.getLogger(CommentDao.class);

    public void addComment(Comment comment) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addComment)) {

            statement.setInt(1, comment.getPostId());
            statement.setInt(2, comment.getAuthorId());
            statement.setString(3, comment.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while adding comment: postId={}, authorId={}, comment={}, error={}",
                    comment.getPostId(), comment.getAuthorId(), comment.getContent(), e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }


    public void deleteComment(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.deleteComment)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while deleting comment: commentId={}, error={}",
                    id, e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }


    public void editComment(int id, String newContents) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.editComment)) {

            statement.setString(1, newContents);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while updating comment: commentId={}, newComment={}, error={}",
                    id, newContents, e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }
}
