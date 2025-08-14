package strings.Medium.array.slidingwindow;

import java.util.ArrayList;
import java.util.Map;

//Max Sum Subarray of Size K	Sliding Window variant
public class FindMaxSumInEverySubArray {

    public static int getMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static ArrayList<Integer> getMaxSum_SubArray(int[] arr, int k){
        ArrayList<Integer> max_SumArray = new ArrayList<>();

        for(int i = 0; i <= arr.length - k; i++ ){
            max_SumArray.add(getMax(arr, i, i+k-1));
        }
        return max_SumArray;
    }



    // Optimised Deque solution
    /*
    public class FindMaxSumInEverySubArray {

    public static List<Integer> getMaxSum_SubArray(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove out of window elements
            if (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            // Remove all elements smaller than current
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // Add to result after first k elements
            if (i >= k - 1) {
                result.add(arr[deque.peek()]);
            }
        }

        return result;
    }
     */

    public static void main(String[] args) {
        int[] arr = {0,1,2,11,4,5,6,7,8,9,10};
        System.out.println(getMaxSum_SubArray(arr, 4));
    }
}
