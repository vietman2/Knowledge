package Knowledge.DataStructure_Algorithms.Queue;

import Knowledge.DataStructure_Algorithms.Common.Node;

public class MyLinkedQueue<E> implements QueueInterface<E> {
    private Node<E> tail;
    
    public MyLinkedQueue() {
        // 생성자
        tail = null;
    }

    public void enqueue(E e) {
        // 큐에 새로운 노드를 추가
        if (isEmpty()) {
            tail = new Node<E>(e, null);
            tail.next = tail;
        } else {
            tail.next = new Node<E>(e, tail.next);
            tail = tail.next;
        }
    }

    public E dequeue() {
        // 큐의 front 노드를 삭제하고 반환
        if (isEmpty()) {
            // 큐가 비어있는 경우 에러처리
            throw new RuntimeException("Queue is empty");
        } else {
            E frontItem = tail.next.item;
            if (tail.next == tail) {
                tail = null;
            } else {
                tail.next = tail.next.next;
            }
            return frontItem;
        }
    }

    public E peek() {
        // 큐의 front 노드를 반환
        if (isEmpty()) {
            // 큐가 비어있는 경우 에러처리
            throw new RuntimeException("Queue is empty");
        } else {
            return tail.next.item;
        }
    }

    public boolean isEmpty() {
        // 큐가 비어있는지 확인
        return tail == null;
    }

    public void dequeueAll() {
        // 큐의 모든 노드를 삭제
        tail = null;
    }
}
