package Knowledge.DataStructure_Algorithms.Index;

public interface IndexInterface<T extends Comparable<T>> {
    public void insert(T x);
    public void delete(T x);
    public TreeNode<T> search(T x);
}
