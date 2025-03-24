package hendrizzzz.network_app.dao;

import exception.DataAccessException;
import hendrizzzz.network_app.model.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotificationDao {
    private static final Logger logger = LogManager.getLogger(NotificationDao.class);

    public void markRead(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.markRead)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while marking notification read: notificationId={}, error={}",
                    id, e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }

    public void addNotification(Notification notification) {
        String column = getNotificationColumn(notification.getNotificationType());

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addNotification(column))) {

            statement.setInt(1, notification.getUserId());
            statement.setString(2, notification.getNotificationType());
            statement.setString(3, notification.getContents());

            Integer foreignKey = getNotificationForeignKey(notification);
            if (foreignKey != null)
                statement.setInt(4, foreignKey);
            else
                statement.setNull(4, java.sql.Types.INTEGER);

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while adding notification: userId={}, notificationType={}, content={}, error={}",
                    notification.getUserId(), notification.getNotificationType(), notification.getContents(), e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }

    /**
     * Returns the correct column name based on notification type.
     */
    private String getNotificationColumn(String type) {
        return switch (type) {
            case "like" -> "like_id";
            case "comment" -> "comment_id";
            case "friend_request" -> "friend_request_sender_id";
            case "message" -> "message_id";
            default -> throw new IllegalArgumentException("Invalid notification type: " + type);
        };
    }

    /**
     * Returns the correct foreign key ID based on notification type.
     */
    private Integer getNotificationForeignKey(Notification notification) {
        return switch (notification.getNotificationType()) {
            case "like" -> notification.getLikeId();
            case "comment" -> notification.getCommentId();
            case "friend_request" -> notification.getFriendRequestSenderId();
            case "message" -> notification.getMessage_id();
            default -> null;
        };
    }



    public void deleteNotification(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.deleteNotification)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Database error occurred while deleting notification: notificationId={}, error={}",
                    id, e.getMessage());
            throw new DataAccessException("Database error occurred");
        }
    }


}
