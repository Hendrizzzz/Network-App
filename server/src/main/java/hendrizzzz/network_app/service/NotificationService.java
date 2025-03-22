package hendrizzzz.network_app.service;

import hendrizzzz.network_app.dao.NotificationDao;
import hendrizzzz.network_app.model.Notification;

public class NotificationService {

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
    }


    public void deleteNotification(int id) {
        if (id < 1) throw new IllegalArgumentException("Id cannot be less than 1");
        notificationDao.deleteNotification(id);
    }


    public void markNotificationRead(int id) {
        if (id < 1) throw new IllegalArgumentException("Id cannot be less than 1");
        notificationDao.markRead(id);
    }
}
