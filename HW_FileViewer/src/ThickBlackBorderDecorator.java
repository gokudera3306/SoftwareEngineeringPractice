public class ThickBlackBorderDecorator extends BaseDecorator {
    public ThickBlackBorderDecorator(IView view) {
        super(view);
    }

    @Override
    public void display() {
        view.display();

        System.out.print(" thickBlackBorder");
    }
}
