public class MySystem {
    private Window currentWindow;

    public void createWindow(String subType, String impType) {
        var windowImp = switch (impType) {
            case "XWindow" -> new XWindow();
            case "PMWindow" -> new PresentationManagerWindow();
            default -> throw new IllegalArgumentException("Unknown impType: " + impType);
        };

        currentWindow = switch (subType) {
            case "IconWindow" -> new IconWindow(windowImp);
            case "TransientWindow" -> new TransientWindow(windowImp);
            default -> throw new IllegalArgumentException("Unknown subType: " + subType);
        };
    }

    public void drawBorder() {
        if (currentWindow != null) {
            currentWindow.drawBorder();
        }
    }

    public void drawCloseBox() {
        if (currentWindow != null) {
            currentWindow.drawCloseBox();
        }
    }
}
