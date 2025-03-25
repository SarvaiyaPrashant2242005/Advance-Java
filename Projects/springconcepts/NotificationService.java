public class NotificationService {

    MessagingService service;

    NotificationService(MessagingService service) {
        this.service = service;
    }

    void sendNotification(String receiver, String msg) {
        service.sendMessage(receiver, msg);
    }
}