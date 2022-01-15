package designpatterns;

import java.util.List;
import java.util.function.Predicate;

public class LightweightStrategy {

    public int sumValues (List<Integer> values, Predicate<Integer> strategy){
        return values.stream().filter(strategy).mapToInt(Integer::intValue).sum();
    }


}
