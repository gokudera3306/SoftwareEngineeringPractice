import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MySystem {
    private final List<Document> documentList = new LinkedList<>();

    public void addDocument(String type) throws Exception {
        var newDocument = switch (type) {
            case "Text" -> new TextDocument();
            case "Draw" -> new DrawingDocument();
            default -> throw new Exception("No Such Type");
        };

        documentList.add(newDocument);
    }

    public void present() {
        for (var doc : documentList) {
            doc.present();
        }
    }
}
