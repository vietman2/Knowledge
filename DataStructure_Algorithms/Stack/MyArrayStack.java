package Knowledge.DataStructure_Algorithms.Stack;

public class MyArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;

    public MyArrayStack() {
        // 생성자 1
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;
    }

    public MyArrayStack(int capacity) {
        // 생성자 2
        stack = (E[]) new Object[capacity];
        topIndex = -1;
    }

    public void push(E e) {
        if (topIndex == stack.length - 1) {
            // 스택이 꽉 찬 경우 에러처리
            throw new RuntimeException("Stack is full");
        }
        stack[++topIndex] = e;
    }

    public E pop() {
        if (topIndex == -1) {
            // 스택이 비어있는 경우 에러처리
            throw new RuntimeException("Stack is empty");
        }
        return stack[topIndex--];
    }

    public E peek() {
        if (topIndex == -1) {
            // 스택이 비어있는 경우 에러처리
            throw new RuntimeException("Stack is empty");
        }
        return stack[topIndex];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void popAll() {
        stack = (E[]) new Object[DEFAULT_CAPACITY]; // Garbage Collection을 위한 코드
        topIndex = -1;
    }
}
