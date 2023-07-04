package Knowledge.DataStructure_Algorithms.Index.AVLTree;

public class AVLNode<T extends Comparable<T>> {
    public T item;
    public AVLNode<T> left, right;
    public int height;

    public AVLNode(T x) {
        item = x;
        left = right = new AVLNode<T>(null, null, null, 0);
        height = 1;
    }
    public AVLNode(T x, AVLNode<T> l, AVLNode<T> r, int h) {
        item = x;
        left = l;
        right = r;
        height = h;
    }
}
