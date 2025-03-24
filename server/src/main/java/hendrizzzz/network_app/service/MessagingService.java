package hendrizzzz.network_app.service;

import exception.DataAccessException;
import hendrizzzz.network_app.dao.MessageDao;
import hendrizzzz.network_app.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessagingService {
    private static final Logger logger = LogManager.getLogger(MessagingService.class);
    private final MessageDao messageDao;


    public MessagingService(MessageDao messageDao) {
        this.messageDao = messageDao;
    }


    public void addMessage(int sender_id, int receiver_id, String contents) {
        if (sender_id < 1) throw new IllegalArgumentException("Sender Id cannot be less than 1");
        if (receiver_id < 1) throw new IllegalArgumentException("Receiver Id cannot be less than 1");
        if (contents == null || contents.isBlank()) throw new IllegalArgumentException("Contents cannot be blank. ");

        Message message = new Message(sender_id, receiver_id, contents);

        messageDao.addMessage(message);
        logger.info("Message added successfully: senderId={}, receiverId={}",sender_id, receiver_id);
    }


    public void deleteMessage(int id) {
        if (id < 1) throw new IllegalArgumentException("Id cannot be less than 1");
        messageDao.deleteMessage(id);
        logger.info("Message deleted successfully: messageId={}",id);
    }


    public void editMessage(int id, String newMessage) {
        if (id < 1) throw new IllegalArgumentException("Id cannot be less than 1");
        if (newMessage == null || newMessage.isBlank()) throw new IllegalArgumentException("Message cannot be blank. ");
        messageDao.editMessage(id, newMessage);
        logger.info("Message updated successfully: messageId={}, newMessage={}",id, newMessage);
    }
}
