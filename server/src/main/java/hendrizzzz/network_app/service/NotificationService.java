package hendrizzzz.network_app.service;

import hendrizzzz.network_app.dao.NotificationDao;
import hendrizzzz.network_app.model.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotificationService {
    private static final Logger logger = LogManager.getLogger(NotificationService.class);
    private final NotificationDao notificationDao;


    public NotificationService(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }


    public void addNotification(int userId, String notificationType, String contents, int id) {
        if (userId < 1) throw new IllegalArgumentException("User id cannot be less than 1");
        if (notificationType == null || notificationType.isBlank()) throw new IllegalArgumentException("Notification type cannot be blank");
        if (contents == null || contents.isBlank()) throw new IllegalArgumentException("Contents cannot be blank");
        if (id < 1) throw new IllegalArgumentException("Foreign id cannot be less than 1");

        Notification notification = new Notification(userId, notificationType, contents, id);
        notificationDao.addNotification(notification);
        logger.info("Notification added successfully: userId={}, notificationType={}, contents={}, foreignKey={}",userId, notificationType, contents, id);
    }


    public void deleteNotification(int id) {
        if (id < 1) throw new IllegalArgumentException("Id cannot be less than 1");
        notificationDao.deleteNotification(id);
        logger.info("Notification deleted successfully: notificationId={}",id);
    }


    public void markNotificationRead(int id) {
        if (id < 1) throw new IllegalArgumentException("Id cannot be less than 1");
        notificationDao.markRead(id);
        logger.info("Notification successfully marked us read: notificationId={}",id);
    }
}
