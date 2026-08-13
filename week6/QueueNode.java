package week6;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}

public class QueueNode<T> {
    public Node<T> first;
    public Node<T> last;
    public int size;

    public QueueNode() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }

        T data = first.data;
        first = first.next;

        size--;

        if (isEmpty()) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }
        return first.data;
    }

    public static void main(String[] args) {
        QueueNode<Integer> queue = new QueueNode<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());

        System.out.println("__________");
        queue.enqueue(4);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        System.out.println("************");
        queue.enqueue(10);
        queue.enqueue(20);

        queue.dequeue(); // saca el primer elemento que es 10
        System.out.println(queue.peek());// Muestra el nuevo primer elemento que ahora es 20
    }
}
