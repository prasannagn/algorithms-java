package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        Integer[] arr = {2,5,9,10,20,35,47,50,67,78,88,93};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);
        tree.inOrder();
        System.out.print(tree.height(tree.getRoot()));
    }
}
