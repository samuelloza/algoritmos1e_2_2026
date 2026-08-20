package week7;

public class ListasDobles<T> {
    Node<T> first;
    Node<T> last;

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }

    public ListasDobles() {
        first = last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void inser(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
    }

    public boolean delete(T data) {
        Node<T> current = first;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            first = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            last = current.prev;
        }
        return true;

    }

    public void showList() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void showReverseList() {
        Node<T> current = last;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListasDobles<Integer> lista = new ListasDobles<>();
        lista.inser(1);
        lista.inser(2);
        lista.inser(3);

        lista.showList();
        lista.delete(2);

        System.out.println("_______________");
        lista.showReverseList();

    }
}
