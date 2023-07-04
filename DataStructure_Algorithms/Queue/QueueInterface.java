package Knowledge.DataStructure_Algorithms.Queue;

public interface QueueInterface<E> {
    public void enqueue(E e);
    public E dequeue();
    public E peek();
    public boolean isEmpty();
    public void dequeueAll();
}
