package Knowledge.DataStructure_Algorithms.Index.AVLTree;

public interface AVLTreeInterface<T extends Comparable<T>> {
    public void insert(T x);
    public void delete(T x);
    public AVLNode<T> search(T x);
}
