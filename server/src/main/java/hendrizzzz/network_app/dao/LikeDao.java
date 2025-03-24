package hendrizzzz.network_app.dao;

import exception.DataAccessException;
import exception.DuplicateModelException;
import hendrizzzz.network_app.model.Like;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class LikeDao {
    private static final Logger logger = LogManager.getLogger(LikeDao.class);

    public void addLike(Like like) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addLike)) {

            statement.setBoolean(1, like.isAPost());
            statement.setInt(2, like.getUser_id_who_liked());

            if (like.isAPost()) {
                statement.setNull(3, java.sql.Types.INTEGER); // comment_id is NULL
                statement.setInt(4, like.getPostId());
            } else {
                statement.setInt(3, like.getCommentId()); // Insert comment_id
                statement.setNull(4, java.sql.Types.INTEGER);
            }

            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicateModelException("Error: Like already exists!");
        } catch (SQLException e) {
            logger.warn("Database error occurred while adding like: isAPost={}, userIdWhoLiked={}, error={}",
                    like.isAPost(), like.getUser_id_who_liked(), e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }



    public void removeLike(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.removeLike)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while deleting comment: likeId={}, error={}",
                    id, e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }



}
