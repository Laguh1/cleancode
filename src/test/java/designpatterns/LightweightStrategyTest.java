package designpatterns;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LightweightStrategyTest {

    private LightweightStrategy lightweightStrategy = new LightweightStrategy();
    private List<Integer> values = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    private Predicate<Integer> evenNumbers = number -> number % 2 == 0;
    private Predicate<Integer> nonNull = number -> number != null;


    @Test
    public void sumValuesWithoutRestrictionTest() {

        int result = lightweightStrategy.sumValues(values, number -> number != null);
        int expectedResult = 45;

        assertEquals(expectedResult, result);

    }

    @Test
    public void sumOnlyEvenValuesTest() {

        int result = lightweightStrategy.sumValues(values, number -> number != null && number % 2 == 0);
        int expectedResult = 20;

        assertEquals(expectedResult, result);

    }

    @Test
    public void sumOnlyOddValuesTest() {

        int result = lightweightStrategy.sumValues(values, nonNull.and(evenNumbers.negate()) );
        int expectedResult = 25;

        assertEquals(expectedResult, result);

    }

}