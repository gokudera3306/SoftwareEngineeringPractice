public class ThickBlackBorderDecorator extends BaseDecorator {
    public ThickBlackBorderDecorator(ITextView textView) {
        super(textView);
    }

    @Override
    public void display() {
        textView.display();

        System.out.print(" thickBlackBorder");
    }
}
