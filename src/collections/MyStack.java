package collections;

import java.util.Arrays;

public class MyStack<T> {
    private Object[] array;
    private int size;

    public MyStack() {
        array = new Object[size];
    }

    public int getSize() {
        return size;
    }

    public MyStack push(T t) {
        resizeArray();
        array[size++] = t;
        return this;
    }

    public T peek() {
        return (size != 0) ? (T) array[size - 1] : null;
    }

    public T pop() {
        check();
        T t = peek();
        size--;
        return t;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public T remove(int index) {
        check();
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

    private void resizeArray() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
    }

    protected void check() {
        if (size == 0) {
            throw new MyIndexException();
        }
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
