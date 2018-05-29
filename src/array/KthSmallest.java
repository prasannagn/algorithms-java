package array;

import java.util.Arrays;

//K’th Smallest/Largest Element in Unsorted Array
public class KthSmallest {

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr,1));
        System.out.println(kthSmallest(arr,2));
        System.out.println(kthSmallest(arr,3));
        System.out.println(kthSmallest(arr,4));
        System.out.println(kthSmallest(arr,5));
        System.out.println(kthSmallest(arr,6));

    }

    public static int kthSmallest(int[] arr, int k) {
        int pivotal = arr[0];

        int[] left = Arrays.stream(arr).skip(1).filter(i -> pivotal >= i).toArray();
        int[] right = Arrays.stream(arr).skip(1).filter(i -> pivotal < i).toArray();

        if (left.length + 1 == k) {
            return pivotal;
        } else if (left.length >= k) {
            return kthSmallest(left, k);
        } else {
            return kthSmallest(right, k - (left.length + 1));
        }
    }
}
