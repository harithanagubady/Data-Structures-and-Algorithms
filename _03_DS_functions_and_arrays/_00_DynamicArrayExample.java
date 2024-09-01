import java.util.Iterator;

/*
Implementation of Dynamic Array
 */
public class _00_DynamicArrayExample<T> implements Iterable<T>{

    private T[] arr;
    private int capacity = 0;
    private int len = 0;

    public _00_DynamicArrayExample() {
        this(2);
    }

    public _00_DynamicArrayExample(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set (int i, T elem) {
        arr[i] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add (T elem) {

        if (len >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                new_arr[i] = arr[i];
            }
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    public T removeAt(int rm_index) {
        if (rm_index >= len && rm_index < 0) throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T[] new_arr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == rm_index) j--;
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public boolean remove (Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf (Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains (Object obj) {
        return indexOf(obj) != -1;
    }

    public static void main(String[] args) {
        _00_DynamicArrayExample<Integer> dae = new _00_DynamicArrayExample();
        dae.add(1);
        dae.add(2);
        //dae.add(3);
        for (int i = 0; i < dae.size(); i++) {
            System.out.println(dae.get(i));
        }
        System.out.println(dae.capacity);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(arr[i]).append(", ");
            }
            return sb.append(arr[len - 1]).append("]").toString();
        }
    }
}
