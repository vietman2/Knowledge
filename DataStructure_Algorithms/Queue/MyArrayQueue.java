package Knowledge.DataStructure_Algorithms.Queue;

public class MyArrayQueue<E> implements QueueInterface<E> {
    private E queue[];
    private int front, tail, numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public MyArrayQueue() {
        // 생성자 1
        queue = (E[]) new Object[DEFAULT_CAPACITY];
        front = numItems = 0;
        tail = DEFAULT_CAPACITY - 1;
    }

    public MyArrayQueue(int capacity) {
        // 생성자 2
        queue = (E[]) new Object[capacity];
        front = numItems = 0;
        tail = capacity - 1;
    }

    public void enqueue(E e) {
        if (numItems == queue.length) {
            // 큐가 꽉 찬 경우 에러처리
            throw new RuntimeException("Queue is full");
        }
        tail = (tail + 1) % queue.length;
        queue[tail] = e;
        numItems++;
    }

    public E dequeue() {
        if (isEmpty()) {
            // 큐가 비어있는 경우 에러처리
            throw new RuntimeException("Queue is empty");
        }
        E frontItem = queue[front];
        front = (front + 1) % queue.length;
        numItems--;
        return frontItem;
    }

    public E peek() {
        if (isEmpty()) {
            // 큐가 비어있는 경우 에러처리
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void dequeueAll() {
        queue = (E[]) new Object[DEFAULT_CAPACITY]; // Garbage Collection을 위한 코드
        front = numItems = 0;
        tail = DEFAULT_CAPACITY - 1;
    }
}
