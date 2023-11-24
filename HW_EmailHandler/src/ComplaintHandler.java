public class ComplaintHandler extends MailHandler {
    @Override
    protected boolean handle(Mail mail) {
        if (mail.Type.equals("COMPLAINT")) {
            System.out.println("Forward to legal department.");
            return true;
        }
        return false;
    }
}
