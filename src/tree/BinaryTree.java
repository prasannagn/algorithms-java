package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {

    private Node<T> root;
    private int size;

    public BinaryTree(T[] arr) {
        this.root = build(arr, 0, arr.length - 1);
        this.size = arr.length;
    }

    private Node<T> build(T[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node<T> node = new Node<T>(arr[mid]);
        node.left = build(arr, start, mid - 1);
        node.right = build(arr, mid + 1, end);
        return node;
    }

    public static <T> BinaryTree<T> balanceTree(BinaryTree<T> tree) {
        List<T> l = new ArrayList<>();
        inOrder(l, tree.root);
        return new BinaryTree<T>((T[]) l.toArray());
    }

    public int height(Node<T> node) {
        if (null == node) {
            return -1;
        }
        int left = height(node.left);
        int right = height(node.right);
        int height = left > right ? left : right;
        return height + 1;
    }

    private static <T> void inOrder(List<T> l, Node<T> n) {
        if (n == null) {
            return;
        }
        inOrder(l, n.left);
        l.add(n.data);
        inOrder(l, n.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }


    private void inOrder(Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        System.out.println(node.data);
        inOrder(node.left);
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.data);
    }

    public Node<T> getRoot() {
        return root;
    }
}
