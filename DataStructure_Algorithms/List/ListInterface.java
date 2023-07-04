package Knowledge.DataStructure_Algorithms.List;

public interface ListInterface<T> {
    // ADT 리스트
    public void add(int index, T x);
    public void append(T x);
    public T remove(int index);
    public boolean removeItem(T x);
    public T get(int index);
    public void set(int index, T x);
    public int indexOf(T x);
    public int size();
    public boolean isEmpty();
    public void clear();
}
