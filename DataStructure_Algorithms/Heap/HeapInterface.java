package Knowledge.DataStructure_Algorithms.Heap;

public interface HeapInterface<E> {
    public void insert(E item);
    public E deleteMax();
    public E max();
    public boolean isEmpty();
    public void clear();
    public void buildHeap();
}
