import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

An unmodifiable view collection is an immutable collection provided the backed collection has immutable objects
 */
public class _05_UnmodifiableViewCollectionsExampleWithImmutableClass {

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();

        // Get the unmodifiable list of students
        List<String> studentsUnmodifiableViewCollection = registry.getStudents();

        // Reading the contents
        System.out.println("Students: " + studentsUnmodifiableViewCollection);

        // Attempting to modify the students list
        try {
            studentsUnmodifiableViewCollection.add("David"); // This will throw an UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the student list");
        }
    }
}

class StudentRegistry {
    // Internal list of student names
    private List<String> students;

    public StudentRegistry() {
        // Initialize the list with some student names
        students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
    }

    // Method to get an unmodifiable view of the students list
    public List<String> getStudents() {
        return Collections.unmodifiableList(students);
    }

    // Method to add a new student (internal modification only)
    public void addStudent(String student) {
        students.add(student);
    }
}
