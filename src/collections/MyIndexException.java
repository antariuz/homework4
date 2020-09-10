package collections;

public class MyIndexException extends RuntimeException {

    public MyIndexException(int index) {
        super("Index:" + index + " out of range");
    }

    public MyIndexException() {
        super("Array Index Out Of Bounds");
    }
}
