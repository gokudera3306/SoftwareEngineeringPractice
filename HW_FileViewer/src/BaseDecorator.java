public abstract class BaseDecorator implements IView {
    protected final IView view;

    public BaseDecorator(IView view) {
        this.view = view;
    }
}
