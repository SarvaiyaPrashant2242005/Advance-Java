
public class DIController {
    MessagingService getMessagingService(String type) {
        if (type.equals("email")) {
            return new EmailService();
        } else if (type.equals("sms")) {
            return new SMSService();
        } else {
            System.out.println("Invalid choice");
            return null;
        }
    }
}
