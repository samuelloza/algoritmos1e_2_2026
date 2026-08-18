package week7;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}

public class ListaSimples<T> {
    private Node<T> first;
    private Node<T> last;

    public ListaSimples() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public boolean delete(T data) {
        if (isEmpty()) {
            return false;
        }

        Node<T> current = first;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            first = first.next;
            if (first == null) {
                last = null;
            }
            return true;
        }

        prev.next = current.next;

        if (current == last) {
            last = prev;
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

    public static void main(String[] args) {
        ListaSimples<Integer> lista = new ListaSimples<>();
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);

        System.out.println("Show List");
        lista.showList();
        System.out.println("End Show List");

        lista.delete(2);

        System.out.println("Delete 2");
        lista.showList();
        System.out.println("End Delete 2");

        lista.insertFirst(100);
        lista.insertFirst(200);

        System.out.println("Insert first");
        lista.showList();
    }
}


