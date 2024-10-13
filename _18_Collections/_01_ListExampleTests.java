import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _01_ListExampleTests {

    /*
    Test case for unmodifiable list throws UnsupportedOperationException
     */
    @Test(expected = UnsupportedOperationException.class)
    public void listOfThrowsUnsupportedOperationException () {
        List<Integer> list1 = List.of(1, 2, 3);
        list1.remove(0);
        list1.add(5);
        list1.set(0, 5);
    }

    /*
    Test case for unmodifiable list throws UnsupportedOperationException
     */
    @Test(expected = UnsupportedOperationException.class)
    public void listCopyThrowsUnsupportedOperationException () {
        ArrayList<Integer> l = new ArrayList<>();
        List<Integer> list1 = List.copyOf(l);
        list1.add(0);
    }

    /*
    Test case for unmodifiable list throws NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void listCopyThrowsNullPointerException () {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(null);
        List<Integer> list1 = List.copyOf(l);
    }

    /*
    Test case for unmodifiable list throws ClassCastException
     */
    @Test(expected = ClassCastException.class)
    public void listOfThrowsClassCastException () {
        ArrayList<Integer> l = (ArrayList<Integer>) List.of(1, 2, 3);
    }

    /*
    Test case for unmodifiable list throws UnsupportedOperationException
     */
    @Test(expected = UnsupportedOperationException.class)
    public void listOfAdditionOfZeroElementsThrowsException () {
        List<Integer> l =  List.of(1, 2, 3);
        ArrayList<Integer> newL = new ArrayList<>();
        l.addAll(newL);
    }

    /*
    Test case for subList method in List interface
     */
    @Test
    public void subList () {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        int i = 0, j = 4;
        List<Integer> subList = l.subList(i, j);
        assertEqualsList(l, subList, i, j);
    }

    /*
    Test case for a list throws ArrayIndexOutOfBoundsException
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void listSetThrowsArrayIndexOutOfBoundsException () {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        l.set(5, 7);
    }

    /*
    Test case for fixed-size list throws UnsupportedOperationException
     */
    @Test (expected = UnsupportedOperationException.class)
    public void ArraysAsListThrowsUnsupportedOperationException () {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, null);
        l.remove(6);
    }

    /*
    Test case for fixed-size list which allows null
     */
    @Test
    public void ArraysAsListAllowsNull () {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, null);
    }

    /*
    Test case for fixed-size list which allows update
     */
    @Test
    public void ArraysAsListAllowsUpdate () {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        l.set(0, 5);
        l.set(2, null);
    }

    /*
    Test case for fixed-size list throws ArrayIndexOutOfBoundsException
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void ArraysAsListThrowsArrayIndexOutOfBoundsException () {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        l.set(4, 5);
    }

    /*
    Test case for IllegalArgumentException on List
     */
    @Test(expected = IllegalArgumentException.class)
    public void ArrayListThrowsIllegalArgumentException () {
        List<Integer> l = new ArrayList<>(-1);
        l.add(1);
    }

    private void assertEqualsList(List<Integer> l, List<Integer> subList, int i, int j) {
        for (int start = i; start < j; start++) {
            assertEquals(l.get(start), subList.get(start));
        }
    }
}
