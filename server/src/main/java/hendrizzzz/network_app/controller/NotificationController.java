package hendrizzzz.network_app.controller;

import hendrizzzz.network_app.service.NotificationService;

public class NotificationController {
    private final NotificationService notificationService;


    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    public void addNotification(int userId, String notificationType, String contents, int id) {

    }
}
