package six.easy;

public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size += 1;
        }
    }

    public int getSize() {
        return size;
    }

    public void add(int index, T value) {
        Node<T> newNode = new Node<>(value);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
            size+=1;
            return;
        }

        Node<T> nodeAtIndex = getNodeAtIndex(index);

        nodeAtIndex.prev.next = newNode;
        newNode.prev = nodeAtIndex.prev;
        newNode.next = nodeAtIndex;
        nodeAtIndex.prev = newNode;
        size +=1;
    }

    public void print() {
        Node<T> current = head;

        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }

    private Node<T> getNodeAtIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        Node<T> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return current;
    }

}
