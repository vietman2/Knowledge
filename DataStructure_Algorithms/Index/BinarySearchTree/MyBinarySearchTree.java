package Knowledge.DataStructure_Algorithms.Index.BinarySearchTree;

public class MyBinarySearchTree<T extends Comparable<T>> implements IndexInterface<T> {
    private TreeNode<T> root;

    public MyBinarySearchTree() { // 생성자
        root = null;
    }

    public void insert(T x) {
        root = insertItem(root, x);
    }
    private TreeNode<T> insertItem(TreeNode<T> t, T x) {
        if (t == null) {
            t = new TreeNode<T>(x);
        }
        else if (x.compareTo(t.item) < 0) {
            t.left = insertItem(t.left, x);
        }
        else {
            t.right = insertItem(t.right, x);
        }

        return t;
    }

    public void delete(T x) {
        root = findAndDelete(root, x);
    }
    private TreeNode<T> findAndDelete(TreeNode<T> t, T x) {
        if (t == null) return null;
        else {
            if (x.compareTo(t.item) == 0) {
                t = deleteNode(t);
            }
            else if (x.compareTo(t.item) < 0) {
                t.left = findAndDelete(t.left, x);
            }
            else {
                t.right = findAndDelete(t.right, x);
            }
        }

        return t;
    }
    private TreeNode<T> deleteNode(TreeNode<T> t) {
        if (t.left == null && t.right == null) return null;
        else if (t.left == null) return t.right;
        else if (t.right == null) return t.left;
        else {
            returnPair pair = deleteMinItem(t.right);
            t.item = pair.minItem;
            t.right = pair.node;
            return t;
        }
    }
    private returnPair deleteMinItem(TreeNode<T> t) {
        if (t.left == null) return new returnPair(t.item, t.right);
        else {
            returnPair pair = deleteMinItem(t.left);
            t.left = pair.node;
            pair.node = t;
            return pair;
        }
    }
    private class returnPair {
        T minItem;
        TreeNode<T> node;
        private returnPair(T x, TreeNode<T> t) {
            minItem = x;
            node = t;
        }
    }

    public TreeNode<T> search(T x) {
        return searchItem(root, x);
    }
    private TreeNode<T> searchItem(TreeNode<T> t, T x) {
        if (t == null) return null;
        else if (x.compareTo(t.item) == 0) return t;
        else if (x.compareTo(t.item) < 0) return searchItem(t.left, x);
        else return searchItem(t.right, x);
    }

    public int size(TreeNode<T> t) {
        if (t == null) return 0;
        else return 1 + size(t.left) + size(t.right);
    }
}
