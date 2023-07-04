package Knowledge.DataStructure_Algorithms.Index.BinarySearchTree;

public class TreeTraversal<T extends Comparable<T>> {
    public void preOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.item);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.item);
        inOrder(root.right);
    }

    public void postOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.item);
    }
}
