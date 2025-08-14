package strings.Medium.array.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Maximum	Find max in every window of size k Sliding Window
//Brute - force approach
public class FindMaxInEverySubArrayOfSizeK {

    public static int getMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static ArrayList<Integer> getMaxInSubArrayOfKSize(int[] arr, int k) {
        if (arr.length < k) {
            return null;
        }
        int left = 0;
        ArrayList<Integer> max_subArray = new ArrayList<>();

        //My first approach
//        for (int right = 0; right < arr.length; right++) {
//            int max = Integer.MIN_VALUE;
//            if (right - left == k - 1) {
//                max = getMax(arr, left, right);
//                max_subArray.add(max);
//                left++;
//            }
//        }

        //Optimized
        for (int right = 0; right <= arr.length - k; right++) {
                max_subArray.add( getMax(arr, right, right+k-1));
        }

        return max_subArray;
    }


    /*
    ✅ Why do we use Deque in Sliding Window Problems?
Key Use Case: Maintain elements in a window efficiently.
Let’s take the classic problem:

"Find maximum in every subarray of size k"

🎯 Goal:
Maintain the maximum element of each window in O(1) time.

❓ Why not use a normal queue or array?
Because you can’t:

Remove elements from the front and back efficiently in an array or queue.

Maintain a decreasing order of useful elements.

✅ Deque in Sliding Window Maximum: How It Works
Idea: Store indices of elements in the window in decreasing order (by value).
So:

The front of the deque is always the index of the maximum in the current window.

As the window moves, you remove elements that are no longer part of the window or smaller than the new element (not useful anymore).
     */


    // ✅ Java Code (Optimized Using Deque):
        public static List<Integer> maxSlidingWindow1(int[] nums, int k) {
            List<Integer> result = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();  // stores indices

            for (int i = 0; i < nums.length; i++) {
                // Remove indices out of the current window
                if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }

                // Remove indices whose values are less than nums[i]
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                deque.offerLast(i);  // add current index

                // Add to result once we have the first window
                if (i >= k - 1) {
                    result.add(nums[deque.peekFirst()]);
                }
            }

            return result;
        }


    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.print(getMaxInSubArrayOfKSize(arr, 3));
    }
}
