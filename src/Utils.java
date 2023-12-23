import java.util.function.Consumer;

public class Utils {
    public static <T> void output(T object) {
        Consumer<T> output = System.out::println;
        output.accept(object);
    }
}
