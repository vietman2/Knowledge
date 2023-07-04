package Knowledge.DataStructure_Algorithms.Stack;

import Knowledge.DataStructure_Algorithms.Common.Node;

public class MyLinkedStack<E> implements StackInterface<E> {
    private Node<E> topNode;

    public MyLinkedStack() {
        // 생성자
        topNode = null;
    }

    public void push(E e) {
        // 스택에 새로운 노드를 추가
        topNode = new Node<E>(e, topNode);
    }

    public E pop() {
        // 스택의 top 노드를 삭제하고 반환
        if (isEmpty()) {
            // 스택이 비어있는 경우 에러처리
            throw new RuntimeException("Stack is empty");
        } else {
            E topItem = topNode.item;
            topNode = topNode.next;
            return topItem;
        }
    }

    public E peek() {
        // 스택의 top 노드를 반환
        if (isEmpty()) {
            // 스택이 비어있는 경우 에러처리
            throw new RuntimeException("Stack is empty");
        } else {
            return topNode.item;
        }
    }

    public boolean isEmpty() {
        // 스택이 비어있는지 확인
        return topNode == null;
    }

    public void popAll() {
        // 스택의 모든 노드를 삭제
        topNode = null;
    }
}
