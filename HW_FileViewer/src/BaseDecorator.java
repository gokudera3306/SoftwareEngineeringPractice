public abstract class BaseDecorator implements ITextView {
    protected final ITextView textView;

    public BaseDecorator(ITextView textView) {
        this.textView = textView;
    }
}
