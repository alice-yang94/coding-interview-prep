/** Use linked list to implement Queue */
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    QueueNode<T> first;
    QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> itemNode = new QueueNode<T>(item);
        if (last == null) {
            last = itemNode;
            if (first == null) {
                first = itemNode;
            }
        } else {
            last.next = itemNode;
            last = itemNode;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T item = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return item;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
