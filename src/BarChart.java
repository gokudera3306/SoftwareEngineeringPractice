import java.util.Collection;
import java.util.List;

public class BarChart implements IChart {
    @Override
    public void Display(List<Data> dataList) {
        for (var d : dataList) {
            for (var i = 0; i < d.getValue(); i++)
                System.out.print("=");

            System.out.println(" " + d.getName());
        }
    }
}
