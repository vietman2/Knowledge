package Knowledge.DataStructure_Algorithms.Stack;

public interface StackInterface<E> {
    public void push(E e);
    public E pop();
    public E peek();
    public boolean isEmpty();
    public void popAll();
}
