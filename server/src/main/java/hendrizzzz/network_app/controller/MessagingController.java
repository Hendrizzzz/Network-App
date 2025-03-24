package hendrizzzz.network_app.controller;

import hendrizzzz.network_app.service.MessagingService;

public class MessagingController {
    private final MessagingService messagingService;


    public MessagingController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }


    public void addMessage(int senderId, int receiverId, String contents) {
        try {
            messagingService.addMessage(senderId, receiverId, contents);
        } catch (IllegalArgumentException e) {

        }
    }


    public void deleteMessage(int messageId) {
        messagingService.deleteMessage(messageId);
    }


    public void editMessage(int messageId, String newMessage){
        messagingService.editMessage(messageId, newMessage);
    }
}
