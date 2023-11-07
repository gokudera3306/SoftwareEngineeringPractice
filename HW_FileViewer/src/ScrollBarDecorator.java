public class ScrollBarDecorator extends BaseDecorator {
    public ScrollBarDecorator(IView view) {
        super(view);
    }

    @Override
    public void display() {
        view.display();

        System.out.print(" scrollBar");
    }
}
