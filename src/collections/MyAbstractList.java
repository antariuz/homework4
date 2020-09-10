package collections;

public abstract class MyAbstractList<T> implements MyList<T> {
    protected int size;

    public int getSize() {
        return size;
    }

    protected void check(int i) {
        if (i > size || i < 0) {
            throw new MyIndexException(size);
        }
    }
}
