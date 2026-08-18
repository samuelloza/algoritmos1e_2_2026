package week7;

public class UVA11988<T> {
    private Node<T> first;
    private Node<T> last;
    private Node<T> cursor;

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }

    public UVA11988() {
        first = null;
        last = null;
        cursor = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void moveFirst() {
        cursor = null;
    }

    public void moveLast() {
        cursor = last;
    }

    public void insertCursor(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            cursor = newNode;
            return;
        }

        // Inserta antes del primer elemento
        if (cursor == null) {
            newNode.next = first;
            first.prev = newNode;

            first = newNode;
            cursor = newNode;
            return;
        }

        newNode.prev = cursor;
        newNode.next = cursor.next;

        if (cursor.next != null) {
            cursor.next.prev = newNode;
        } else {
            last = newNode;
        }

        cursor.next = newNode;
        cursor = newNode;
    }

    public void showList() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        UVA11988<Character> lista = new UVA11988<>();
        String cad = "[[]][][]Happy_Birthday_to_Tsinghua_University";
        for (int i = 0; i < cad.length(); i++) {
            char c = cad.charAt(i);
            if (c == '[') {
                lista.moveFirst();
            } else if (c == ']') {
                lista.moveLast();
            } else {
                lista.insertCursor(c);
            }
        }
        lista.showList();
    }
}
