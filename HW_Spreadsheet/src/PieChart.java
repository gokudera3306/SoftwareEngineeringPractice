import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;

public class PieChart implements IChart {
    @Override
    public void Display(List<Data> dataList) {
        var sum = 0;
        for (var d : dataList)
            sum += d.getValue();

        for (var d : dataList) {
            var percent = (double) d.getValue() / sum;
            var nf = NumberFormat.getPercentInstance();
            nf.setMinimumFractionDigits(1);
            System.out.println(d.getName() + " " + nf.format(percent));
        }
    }
}
