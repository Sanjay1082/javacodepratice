package strings.Medium.array.presum;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthOfSubArraySumToK {

/*    Longest Subarray with Sum K	Return length of longest subarray with sum = K	Prefix Sum, HashMap

Input: arr = [10, 5, 2, 7, 1, 9], K = 15
Output: 4
Explanation: The subarray [5, 2, 7, 1] has a sum = 15.

 */

    //Brute - force approach O(n2)
    public static int getMaxLengthOfTheSubArrayForGivenSum(int[] arr, int k) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int currentLen = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                currentLen++;
                if (sum == k) {
                    maxLength = Math.max(maxLength, currentLen);
                }
            }
        }
        return maxLength;
    }


    // O(n)
    //Using the single for loop and hashmap/ hashset

    public static int getMaxLengthOfSubArray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_length = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            if (sum == k) {
                max_length = i + 1;
            }

            if (map.containsKey(sum - k)) {
                int length = i - map.get(sum - k);
                max_length = Math.max(max_length, length);
            } else {
                map.putIfAbsent(sum, i);
            }
        }
        return max_length;
    }


    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, 7, 1, 10, 18,};
        System.out.print(getMaxLengthOfSubArray(arr, 18));
    }

}
