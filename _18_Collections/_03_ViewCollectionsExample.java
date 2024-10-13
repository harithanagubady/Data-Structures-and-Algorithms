import java.util.ArrayList;
import java.util.List;

public class _03_ViewCollectionsExample {

    public static void main(String[] args) {

        // Create a backing collection
        List<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");
        originalList.add("Date");

        //Display original list
        System.out.println("Original: " + originalList); // ["Apple", "Banana", "Cherry", "Date"]

        // Create a view collection (subList)
        List<String> viewList = originalList.subList(1, 3);

        // Display the view
        System.out.println("View created as subList(1, 3): " + viewList); // Output: View created by subList(1, 3): [Banana, Cherry]
        System.out.println();

        // Modify the original list
        originalList.set(1, "Blueberry");
        System.out.println("Modified Original: " + originalList); // Output: Modified Original: [Apple, Blueberry, Cherry, Date]

        // The view reflects changes in the original list
        System.out.println("View reflects changes in original list: " + viewList); // Output: View reflects changes in original list: [Blueberry, Cherry]
    }
}
