package collections;

public class MyLinkedList<T> extends MyAbstractList<T> {
    private Node<T> head;
    private Node<T> tail;

    private Node<T> node(int index) {
        if (index < (size / 2)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.getNext();
            }
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.getPrev();
            }
            return x;
        }
    }

    @Override
    public T get(int index) {
        check(index);
        return node(index).getItem();
    }

    @Override
    public MyLinkedList add(T t) {
        Node<T> prevNode = tail;
        Node<T> curNode = new Node<>(prevNode, t, null);
        tail = curNode;
        if (prevNode == null) {
            head = curNode;
        } else prevNode.setNext(curNode);
        size++;
        return this;
    }

    private void cutNode(Node<T> node) {
        Node<T> next = node.getNext();
        Node<T> prev = node.getPrev();

        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }

        if (next == null) {
            tail = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }

        node.setItem(null);
        size--;
    }


    public int remove(Object o) {
        int quantity = 0;
        if (o == null) {
            for (Node<T> x = head; x != null; x = x.getNext()) {
                if (x.getItem() == null) {
                    cutNode(x);
                    quantity++;
                }
            }
        } else {
            for (Node<T> x = head; x != null; x = x.getNext()) {
                if (o.equals(x.getItem())) {
                    cutNode(x);
                    quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public T remove(int index) {
        check(index);
        T temp = node(index).getItem();
        cutNode(node(index));
        return temp;
    }

    @Override
    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.getNext();
            x.setItem(null);
            x.setNext(null);
            x.setPrev(null);
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        int i = 0;
        for (Node<T> x = head; x != null; x = x.getNext(), i++) {
            str.append("[" + i + "] => " + x.getItem() + "\n");
        }
        return str.toString();
    }
}
