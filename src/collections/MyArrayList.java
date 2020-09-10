package collections;

import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> extends MyAbstractList<T> {

    private Object[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            array = new Object[initialCapacity];
        } else {
            array = EMPTY_ARRAY;
        }
    }

    public Object[] getArray() {
        return array;
    }

    @Override
    public T get(int index) {
        check(index);
        return (T) array[index];
    }

    @Override
    public MyArrayList add(T t) {
        resizeArray();
        array[size++] = t;
        return this;
    }

    public MyArrayList add(int index, T t) {
        resizeArray();
        check(index);
        int lenghtMoved = size - index;
        if (lenghtMoved > 0) {
            System.arraycopy(array, index, array, index + 1, lenghtMoved);
            array[index] = t;
        }
        size++;
        return this;
    }

    @Override
    public T remove(int index) {
        check(index);
        T temp = (T) array[index];
        int lenghtMoved = size - index - 1;

        if (lenghtMoved > 0) {
            System.arraycopy(array, index + 1, array, index, lenghtMoved);
        }

        array[--size] = null;
        return temp;
    }

    public void remove(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                remove(i);
                size--;
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    private void resizeArray() {
        if (size == array.length) {
            int oldCapacity = array.length;
            array = Arrays.copyOf(array, oldCapacity + 1 + (oldCapacity >> 1));
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < size; i++) {
            str.append("[" + i + "] => " + array[i] + "\n");
        }
        return str.toString();
    }
}
