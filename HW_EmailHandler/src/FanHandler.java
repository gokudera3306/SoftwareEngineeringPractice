public class FanHandler extends MailHandler {
    @Override
    protected boolean handle(Mail mail) {
        if (mail.Type.equals("FAN")) {
            System.out.println("Forward to CEO.");
            return true;
        }
        return false;
    }
}
