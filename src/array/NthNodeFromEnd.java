package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

//Program for n’th node from the end of a Linked List
public class NthNodeFromEnd {
    public static void main(String[] args) {

        Node<Integer> list = getLinkedList();
        nthNodeFromEnd(list, 1);
        nthNodeFromEnd(list, 2);
        nthNodeFromEnd(list, 3);
        nthNodeFromEnd(list, 4);
        nthNodeFromEnd(list, 5);
        nthNodeFromEnd(list, 6);

    }

    private static int nthNodeFromEnd(Node<Integer> node, int n) {
        int ret;
        if (null != node.next) {
            int i = nthNodeFromEnd(node.next, n);
            ret = i + 1;
        } else {
            ret = 1;
        }
        if (ret == n) {
            System.out.println(node.data);
        }
        return ret;
    }

    private static Node<Integer> getLinkedList() {
        int[] arr = {1, 3, 4, 6, 8};

        Node<Integer> head = new Node<>(1);
        Node<Integer> current = head;
        for (int i = 0; i < arr.length; i++) {
            Node<Integer> next = new Node<>(arr[i]);
            current.next = next;
            current = next;
        }
        return head;
    }


}
