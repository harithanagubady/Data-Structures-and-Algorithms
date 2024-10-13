import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
This example specifies that even if collections are unmodifiable with mutable objects in it,
then the collections are also mutable. Two lists of objects that hold same data can be compared as false.

On the contrary,
The unmodifiable collections, if they have immutable objects, then they can be compared as true, and the collections are
effectively considered immutable

As of now, we can only say that an unmodifiable collection is a collection that has methods known as mutators which
throw UnsupportedOperationException if modification is done on the collection.
Eg., l.add(e); //throws UnsupportedOperationException for an unmodifiable list l
In this example, if e is mutable object, then the collection is also mutable because we can update mutable objects
Eg., e.setStr("B"); //takes effect and modifies the object in the unmodifiable list

Hence, "unmodifiable collection is not necessarily an immutable collection"
 */
public class _04_UnmodifiableCollectionsExample {

    public static void main(String[] args) {


        //list1
        List<MutableElement> mutableList = new ArrayList<>();
        MutableElement e1 = new MutableElement("A");
        MutableElement e2 = new MutableElement("B");
        mutableList.add(e1);
        mutableList.add(e2);
        List<MutableElement> unmodifiableList = Collections.unmodifiableList(mutableList);

        System.out.print("Unmodifiable list: " + unmodifiableList);
        System.out.println();

        //list2
        List<MutableElement> anotherList = new ArrayList<>();
        anotherList.add(new MutableElement("C"));
        anotherList.add(new MutableElement("B"));
        System.out.println("Another list: " + anotherList);


        System.out.println("Are list1 & list2 equal? " + unmodifiableList.equals(anotherList));
        System.out.println();

        //Mutate an element
        e1.setStr("C");

        System.out.println("After mutation");
        System.out.print("Unmodifiable list: " + unmodifiableList);
        System.out.println();

        System.out.println("Are list1 & list2 equal? " + unmodifiableList.equals(anotherList));
        System.out.println();
    }

    static class MutableElement {
        String str;

        public MutableElement (String str) {
            this.str = str;
        }
        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }
}
