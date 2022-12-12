package debashis.newfeatures.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateRunner {

    public static void main(String[] args) {
        var numbers = List.of(1,2,3,4,5,6);
        Predicate<Integer> evenNumbers = number -> number%2 == 0;
        Predicate<Integer> divisibleBy3 = number -> number%3 == 0;
        numbers.stream().filter(evenNumbers.and(divisibleBy3).negate()).forEach(System.out::println);

        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        var allPredicates = new ArrayList<Predicate<String>>();
        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));
        allPredicates.add(str -> str.length() > 4);

        names.stream().filter(allPredicates.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
