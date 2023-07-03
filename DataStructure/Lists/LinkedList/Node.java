package Knowledge.DataStructure.Lists.LinkedList;

public class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E newItem) {
        // 생성자
        item = newItem;
        next = null;
    }

    public Node(E newItem, Node<E> nextNode) {
        // 생성자 with 다음 노드
        item = newItem;
        next = nextNode;
    }
}
