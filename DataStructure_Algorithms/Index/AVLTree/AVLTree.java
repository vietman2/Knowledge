package Knowledge.DataStructure_Algorithms.Index.AVLTree;

public class AVLTree<T extends Comparable<T>> implements AVLTreeInterface<T> {
    private AVLNode<T> root;

    public AVLTree() {
        root = new AVLNode<T>(null, null, null, 0);
    }

    public AVLNode<T> search(T x) {
        return searchItem(root, x);
    }
    private AVLNode<T> searchItem(AVLNode<T> node, T x) {
        if (node.item == null) return null;
        if (node.item.compareTo(x) == 0) return node;
        if (node.item.compareTo(x) > 0) return searchItem(node.left, x);
        return searchItem(node.right, x);
    }

    public void insert(T x) {
        root = insertItem(root, x);
    }
    private AVLNode<T> insertItem(AVLNode<T> node, T x) {
        int type;
        if (node.item == null) node = new AVLNode<T>(x);
        else if (x.compareTo(node.item) < 0) {
            node.left = insertItem(node.left, x);
            node.height = 1 + Math.max(node.right.height, node.left.height);
            type = needBalance(node);
            if (type != NO_NEED) node = balanceAVL(node, type);
        }
        else {
            node.right = insertItem(node.right, x);
            node.height = 1 + Math.max(node.right.height, node.left.height);
            type = needBalance(node);
            if (type != NO_NEED) node = balanceAVL(node, type);
        }
        return node;
    }

    public void delete(T x) {
        root = deleteItem(root, x);
    }
    private AVLNode<T> deleteItem(AVLNode<T> t, T x) {
        if (t.item == null) return null;
        else {
            if (x.compareTo(t.item) == 0) t = deleteNode(t);
            else if (x.compareTo(t.item) < 0) {
                t.left = deleteItem(t.left, x);
                t.height = 1 + Math.max(t.right.height, t.left.height);
                int type = needBalance(t);
                if (type != NO_NEED) t = balanceAVL(t, type);
            }
            else {
                t.right = deleteItem(t.right, x);
                t.height = 1 + Math.max(t.right.height, t.left.height);
                int type = needBalance(t);
                if (type != NO_NEED) t = balanceAVL(t, type);
            }
            
            return t;
        }
    }
    private AVLNode<T> deleteNode(AVLNode<T> t) {
        if ((t.left.item == null) && (t.right.item == null)) {
            return new AVLNode<T>(null, null, null, 0);
        }
        else if (t.left.item == null) return t.right;
        else if (t.right.item == null) return t.left;
        else {
            returnPair pair = deleteMinItem(t.right);
            t.item = pair.item;
            t.right = pair.node;
            t.height = 1 + Math.max(t.right.height, t.left.height);
            int type = needBalance(t);
            if (type != NO_NEED) t = balanceAVL(t, type);
            return t;
        }
    }
    private returnPair deleteMinItem(AVLNode<T> t) {
        if (t.left.item == null) return new returnPair(t.item, t.right);
        else {
            returnPair pair = deleteMinItem(t.left);
            t.left = pair.node;
            t.height = 1 + Math.max(t.right.height, t.left.height);
            int type = needBalance(t);
            if (type != NO_NEED) t = balanceAVL(t, type);
            pair.node = t;
            return pair;
        }
    }
    private class returnPair {
        T item;
        AVLNode<T> node;
        private returnPair(T item, AVLNode<T> node) {
            this.item = item;
            this.node = node;
        }
    }

    private final int LL = 1, LR = 2, RR = 3, RL = 4, NO_NEED = 0;
    private int needBalance(AVLNode<T> t) {
        int type = -1;
        if (t.left.height + 2 <= t.right.height) {
            if (t.right.left.height > t.right.right.height) type = RL;
            else type = RR;
        }
        else if (t.left.height >= t.right.height+2) {
            if (t.left.left.height < t.left.right.height) type = LR;
            else type = LL;
        }
        else type = NO_NEED;

        return type;
    }
    private AVLNode<T> balanceAVL(AVLNode<T> t, int type) {
        AVLNode<T> returnNode = new AVLNode<T>(null, null, null, 0);

        switch(type) {
            case LL:
                returnNode = rightRotate(t);
                break;
            case LR:
                t.left = leftRotate(t.left);
                returnNode = rightRotate(t);
                break;
            case RR:
                returnNode = leftRotate(t);
                break;
            case RL:
                t.right = rightRotate(t.right);
                returnNode = leftRotate(t);
                break;
            default:
                break;
        }

        return returnNode;
    }


    private AVLNode<T> leftRotate(AVLNode<T> t) {
        AVLNode<T> right = t.right;

        if (right.item == null) throw new RuntimeException("Error in leftRotate");
        else {
            AVLNode<T> rightLeft = right.left;
            right.left = t;
            t.right = rightLeft;
            t.height = 1 + Math.max(t.right.height, t.left.height);
            right.height = 1 + Math.max(right.right.height, right.left.height);
            return right;
        }
    }
    private AVLNode<T> rightRotate(AVLNode<T> t) {
        AVLNode<T> left = t.left;

        if (left.item == null) throw new RuntimeException("Error in rightRotate");
        else {
            AVLNode<T> leftRight = left.right;
            left.right = t;
            t.left = leftRight;
            t.height = 1 + Math.max(t.right.height, t.left.height);
            left.height = 1 + Math.max(left.right.height, left.left.height);
            return left;
        }
    }
}