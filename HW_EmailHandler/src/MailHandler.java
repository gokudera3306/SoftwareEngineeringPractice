public abstract class MailHandler {
    protected MailHandler nextHandler;

    public void setNextHandler(MailHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleMail(Mail mail) {
        if (handle(mail)) return;

        if (this.nextHandler != null) {
            this.nextHandler.handleMail(mail);
        }
    }

    protected abstract boolean handle(Mail mail);
}
