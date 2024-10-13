import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Unmodifiable View Collection is not necessarily an immutable collection.
It can still be updated by modifying the mutable objects
But throws UnsupportedOperationException with the mutators used to update the list
 */
public class _05_UnmodifiableViewCollectionsExampleWithMutableClass {

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();

        // Get the unmodifiable list of students
        List<Student> studentList = registry.getStudents();

        // Reading the contents
        System.out.println("Students: " + studentList);

        // Attempting to modify the list
        try {
            studentList.add(new Student("David", 23)); // This will throw an UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the student list: " + e.getMessage());
        }

        // Modifying a student's details
        Student student = studentList.get(0); // Get the first student (Alice)
        student.setAge(21); // This is allowed since the object is mutable
        System.out.println("Modified Students: " + registry.getStudents());
    }

    static class StudentRegistry {
        // Internal list of Student objects
        private List<Student> students;

        public StudentRegistry() {
            // Initialize the list with some Student objects
            students = new ArrayList<>();
            students.add(new Student("Alice", 20));
            students.add(new Student("Bob", 22));
            students.add(new Student("Charlie", 21));
        }

        // Method to get an unmodifiable view of the students list
        public List<Student> getStudents() {
            return Collections.unmodifiableList(students);
        }

        // Method to add a new student (internal modification only)
        public void addStudent(String name, int age) {
            students.add(new Student(name, age));
        }
    }

    //Mutable Student Class
    private static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + '}';
        }
    }

}
