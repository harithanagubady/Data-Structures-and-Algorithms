import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _02_UnderstandImmutabilityConcept {

    public static void main(String[] args) {

        // Creating two lists with the same immutable Fruit objects
        Fruit f = new Fruit("Apple", "Red");
        List<Fruit> list1 = Arrays.asList(f,
                new Fruit("Banana", "Yellow"),
                new Fruit("Cherry", "Red"));

        List<Fruit> list2 = Arrays.asList(new Fruit("Apple", "Red"),
                new Fruit("Banana", "Yellow"),
                new Fruit("Cherry", "Red"));

        // Comparing the two lists
        if (list1.equals(list2)) {
            System.out.println("The two lists are equal.");
        } else {
            System.out.println("The two lists are not equal.");
        }
    }

    //Immutable class
    private static final class Fruit {
        private final String name;
        private final String color;

        public Fruit(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fruit fruit)) return false;
            return Objects.equals(name, fruit.name) && Objects.equals(color, fruit.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, color);
        }
    }
}
