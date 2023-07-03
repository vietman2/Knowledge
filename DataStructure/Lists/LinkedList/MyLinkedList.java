package Knowledge.DataStructure.Lists.LinkedList;

import Knowledge.DataStructure.Lists.ListInterface;

public class MyLinkedList<E extends Comparable<E>> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;
    
    public MyLinkedList() {
        // 생성자
        head = new Node<E>(null, null);
        numItems = 0;
    }

    public void add(int index, E x) {
        // index 위치에 x를 삽입한다.
        if (index < 0 || index > numItems) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node<E> prev = getNode(index - 1);
            Node<E> newNode = new Node<E>(x, prev.next);
            prev.next = newNode;
            numItems++;
        }
    }

    public void append(E x) {
        // 리스트의 끝에 x를 삽입한다.
        Node<E> prev = head; //더미헤드
        while (prev.next != null) {
            prev = prev.next;
        }
        Node<E> newNode = new Node<E>(x, null);
        prev.next = newNode;
        numItems++;
    }

    public E remove(int index) {
        // index 위치의 항목을 삭제한다.
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node<E> prev = getNode(index - 1);
            Node<E> curr = prev.next;
            prev.next = curr.next;
            numItems--;
            return curr.item;
        }
    }
    
    public boolean removeItem(E x) {
        // x를 리스트에서 삭제한다.
        Node<E> curr = head;
        for (int i = 0; i <= numItems-1; i++) {
            Node<E> prev = curr;
            curr = prev.next;
            if (curr.item.compareTo(x) == 0) {
                prev.next = curr.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        // index 위치의 항목을 반환한다.
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException();
        }
        else {
            return getNode(index).item;
        }
    }

    public void set(int index, E x) {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException();
        }
        else {
            getNode(index).item = x;
        }
    }

    private Node<E> getNode(int index) {
        // index 위치의 노드를 반환한다.
        if (index < -1 || index >= numItems) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node<E> curr = head;
            for (int i = -1; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        }
    }

    public int indexOf(E x) {
        // x가 리스트에 있으면 x의 위치를 반환하고, 없으면 -1을 반환한다.
        Node<E> curr = head;
        for (int i = 0; i <= numItems-1; i++) {
            curr = curr.next;
            if (curr.item.compareTo(x) == 0) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        // 리스트의 항목의 수를 반환한다.
        return numItems;
    }

    public boolean isEmpty() {
        // 리스트가 비어있으면 true를 반환한다.
        return numItems == 0;
    }

    public void clear() {
        // 리스트를 공백으로 만든다.
        head = new Node<E>(null, null);
        numItems = 0;
    }
}
