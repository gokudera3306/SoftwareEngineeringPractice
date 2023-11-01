import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MySystem {
    private final List<Data> dataList = new LinkedList<>();
    private final List<IChart> charts = new LinkedList<>();

    public void AddData(String name, int value) {
        var matchList = getMatchedData(name);

        if(!matchList.isEmpty()) return;

        var newData = new Data(name, value);

        dataList.add(newData);
    }

    public void AddChart(String chartName) throws Exception {
        var newChart = ChartFactory.CreateChart(chartName);
        charts.add(newChart);
    }

    public void ChangeData(String chart, String name, int value) {
        if (!containsChart(chart)) return;

        var matchList = getMatchedData(name);

        if (matchList.isEmpty()) {
            var newData = new Data(name, value);
            dataList.add(newData);
        } else {
            var oldData = matchList.get(0);
            oldData.setValue(value);
        }

        System.out.println(chart + " change " + name + " " + value + ".");

        notifyChanged();
    }

    private List<Data> getMatchedData(String dataName) {
        return dataList.stream().filter(d -> d.getName().equals(dataName)).toList();
    }

    private void notifyChanged() {
        for (var c : charts)
            c.Display(dataList);
    }

    public boolean containsChart(String chartName) {
        for (var chart : charts) {
            if (chart.getClass().getSimpleName().equals(chartName)) return true;
        }
        return false;
    }

    private static class ChartFactory {
        public static IChart CreateChart(String chartName) throws Exception {
            return switch (chartName) {
                case "Spreadsheet" -> new Spreadsheet();
                case "BarChart" -> new BarChart();
                case "PieChart" -> new PieChart();
                default -> throw new Exception("");
            };
        }
    }
}
