import java.util.LinkedHashSet;
import java.util.Set;

public class AveragePrice {

    public double nonDuplicatedAverage(int[] prices) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int p : prices) {
            set.add(p);
        }

        double sum = 0;
        for (Integer p : set) {
            sum += p;
        }
        return sum / set.size();
    }

}
