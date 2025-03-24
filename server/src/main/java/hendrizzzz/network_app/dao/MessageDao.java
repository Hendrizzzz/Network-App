package hendrizzzz.network_app.dao;

import exception.DataAccessException;
import hendrizzzz.network_app.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDao {


    public void addMessage(Message message) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Sql.addMessage)) {

            statement.setInt(1, message.getSenderId());
            statement.setInt(2, message.getReceiverId());
            statement.setString(3, message.getContents());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred");
        }
    }


    public void deleteMessage(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Sql.deleteMessage)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
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
            throw new DataAccessException("Database error occurred");
        }

    }
}
