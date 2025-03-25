public class SMSService implements MessagingService {

    SMSService() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendMessage(String receiver, String msg) {
        System.out.println("Send sms to " + receiver + " with msg" + msg);
    }

}