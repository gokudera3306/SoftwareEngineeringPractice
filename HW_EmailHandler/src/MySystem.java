public class MySystem {
    private final MailHandler mailHandler;

    public MySystem() {
        var spamHandler = new SpamHandler();
        var fanHandler = new FanHandler();
        var complaintHandler = new ComplaintHandler();

        spamHandler.setNextHandler(complaintHandler);
        complaintHandler.setNextHandler(fanHandler);

        mailHandler = spamHandler;
    }
    public void ReceiveEmail(String type) {
        var newMail = new Mail(type);
        mailHandler.handleMail(newMail);
    }
}
