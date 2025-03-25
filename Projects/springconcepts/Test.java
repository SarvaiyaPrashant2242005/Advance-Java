
import javax.management.Notification;

public class Test {
    public static void main(String[] args) {
        NotificationService nService = new NotificationService();
        nService.sendNotification("Prashant", "Hey There", "email");

        NotificationService sservice = new NotificationService();
        sservice.sendNotification("Prashant", "IPL 2025", "sms");
    }
}
