import java.util.Collection;
import java.util.List;

public class Spreadsheet implements IChart {
    @Override
    public void Display(List<Data> dataList) {
        for (var d : dataList) System.out.println(d.getName() + " " + d.getValue());
    }
}
