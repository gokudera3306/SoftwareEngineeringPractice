public class SpamHandler extends MailHandler {
    @Override
    protected boolean handle(Mail mail) {
        if (mail.Type.equals("SPAM")) {
            System.out.println("Put mail to the spam box.");
            return true;
        }

        return false;
    }
}
