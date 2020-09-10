package collections;

public interface MyList<T> {
    T get(int index);

    MyList add(T t);

    T remove(int index);

    void clear();

    int getSize();

}
