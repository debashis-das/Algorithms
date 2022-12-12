package debashis.newfeatures.copyOf;

import java.util.List;

/**
 * Java 10
 */
public class CopyOfRunner {
    public static void main(String[] args) {
        var values = List.of(1,2,3,4,5,6);
        values.stream().forEach(System.out::println);
    }
}
