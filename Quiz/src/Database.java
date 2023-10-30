import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<String, LinkedList<Factor>> history;

    public Database() {
        history = new HashMap<>();
    }

    public void Store(String sensorName, Factor data) {
        var sensorHistory = history.getOrDefault(sensorName, new LinkedList<>());
        sensorHistory.add(data);

        history.put(sensorName, sensorHistory);
    }

    public List<Factor> getHistory(String sensorName) {
        return history.getOrDefault(sensorName, new LinkedList<>());
    }
}
