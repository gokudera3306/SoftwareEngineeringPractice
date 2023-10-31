import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MySystem {
    private final List<Data> dataList = new LinkedList<>();
    private final List<IChart> charts = new LinkedList<>();

    public void AddData(String name, int value) {
        var newData = new Data(name, value);

        dataList.add(newData);
    }

    public void AddChart(String chartName) throws Exception {
        var newChart = ChartFactory.CreateChart(chartName);
        charts.add(newChart);
    }

    public void ChangeData(String chart, String name, int value) {
        var matchList = dataList.stream().filter(d -> d.getName().equals(name)).toList();

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

    private void notifyChanged() {
        for (var c : charts)
            c.Display(dataList);
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
