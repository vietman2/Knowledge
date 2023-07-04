package Knowledge.DataStructure_Algorithms.Index.BinarySearchTree;

public class TreeNode<T extends Comparable<T>> {
    public T item;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T newItem) {
        item = newItem;
        left = null;
        right = null;
    }

    public TreeNode(T newItem, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        item = newItem;
        left = leftNode;
        right = rightNode;
    }
}
