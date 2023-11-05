public class ScrollBarDecorator extends BaseDecorator {
    public ScrollBarDecorator(ITextView textView) {
        super(textView);
    }

    @Override
    public void display() {
        textView.display();

        System.out.print(" scrollBar");
    }
}
