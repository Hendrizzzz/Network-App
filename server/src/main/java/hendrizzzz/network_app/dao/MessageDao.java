package hendrizzzz.network_app.dao;

import exception.DataAccessException;
import hendrizzzz.network_app.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDao {
    private static final Logger logger = LogManager.getLogger(MessageDao.class);

    public void addMessage(Message message) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addMessage)) {

            statement.setInt(1, message.getSenderId());
            statement.setInt(2, message.getReceiverId());
            statement.setString(3, message.getContents());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while adding message: senderId={}, receiverId={}, error={}",
                    message.getSenderId(), message.getReceiverId(), e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }


    public void deleteMessage(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.deleteMessage)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while deleting message: messageId={}, error={}",
                    id, e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }


    public void editMessage(int id, String newMessage) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.editMessage)) {

            statement.setString(1, newMessage);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while updating message: messageId={}, newMessage={}, error={}",
                    id, newMessage, e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }
}
